package hunter.destruct.server.bot;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
//@Component
public class VKBot implements Runnable{

    private final VkApiClient vk;
    private final GroupActor groupActor;
    private final VKCommand command;

    private volatile boolean isWork = false;
    private int ts;
    private int maxMsgId = -1;
    private static final ExecutorService MESSAGE_EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    @Autowired
    public VKBot(VkApiClient vk, GroupActor groupActor,  VKCommand command){
        this.vk = vk;
        this.groupActor = groupActor;
        this.command = command;

        log.info("vk bot");

        try {
            ts = this.vk.messages().getLongPollServer(this.groupActor).execute().getTs();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    private void init(){
        log.info("init");
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        log.info("Bot is started!");
        isWork=true;
        try {
            while (isWork) {
                Thread.sleep(2000);
                gettingAndProcessMessage();
            }
        } catch (InterruptedException | ClientException | ApiException e) {
            e.printStackTrace();
        }
    }

    private void gettingAndProcessMessage() throws ClientException, ApiException {
        Message message = getMessage();
        if (message!=null){
            final Message messageForExecute = message;
            Runnable messageExecutor = createExecutor(messageForExecute);
            MESSAGE_EXECUTOR_SERVICE.execute(messageExecutor);
        }
    }

    private Message getMessage() throws ClientException, ApiException {
        MessagesGetLongPollHistoryQuery eventsQuery = vk.messages()
                .getLongPollHistory(groupActor)
                .ts(ts);
        if (maxMsgId>0){
            eventsQuery.maxMsgId(maxMsgId);
        }
        List<Message> messages = eventsQuery.execute()
                .getMessages()
                .getItems();
        if (!messages.isEmpty()){
            ts = vk.messages()
                    .getLongPollServer(groupActor)
                    .execute()
                    .getTs();
        }
        if (!messages.isEmpty() && !messages.get(0).isOut()){
            int messageId = messages.get(0).getId();
            if (messageId>maxMsgId){
                maxMsgId = messageId;
            }
            return messages.get(0);
        }
        return null;
    }

    private Runnable createExecutor(Message message){
        return () -> {
            log.info("Getting message: " + message);
            String result = command.processMessage(message, vk, groupActor);
            sendAnswer(result, message.getPeerId());
        };
    }

    private int sendAnswer(String msg, int peerId){
        try {
            return vk.messages()
                    .send(groupActor)
                    .peerId(peerId)
                    .message(msg)
                    .randomId(ThreadLocalRandom.current().nextInt())
                    .execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
