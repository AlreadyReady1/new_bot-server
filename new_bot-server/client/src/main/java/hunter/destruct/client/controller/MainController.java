package hunter.destruct.client.controller;

import hunter.destruct.client.dto.GroupHuntResult;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.ImageView;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class MainController {

    @FXML
    protected Button groupHunt;
    @FXML
    protected TextField groupIdEnter;
    @FXML
    protected TextArea commentsArea;
    @FXML
    protected Button getDetails;

    private final RestTemplate rest = new RestTemplate();

    @FXML
    private void initialize() {
        log.info("Init main scene...");
        commentsArea.setWrapText(true);
        groupHunt.setOnAction(event -> {
            String id = groupIdEnter.getText();
            try {
                var resultEntity = rest.exchange("http://localhost:8080/destruct-hunter/api/v1/hunt/group/" + id, HttpMethod.GET, null, GroupHuntResult.class);

                GroupHuntResult result = resultEntity.getBody();
                int destroyCommentsCount = Arrays.stream(result.getDestructPosts()).sum();
                String stringResult =
                        destroyCommentsCount < result.getPostCount() - destroyCommentsCount ?
                                String.format("Сообщество \"%s\" не является деструктивным." +"\n"+" Процент деструктивных комментариев (постов): %d", result.getGroupName(), destroyCommentsCount / result.getPostCount() * 100) :
                                String.format("Сообщество \"%s\"  потенциально деструктивно." +"\n"+"Процент деструктивных комментариев (постов): %d", result.getGroupName(), destroyCommentsCount * 100 / result.getPostCount());

                commentsArea.setText(stringResult);
            } catch (HttpClientErrorException exception) {
                if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                    commentsArea.setText(String.format("Сообщество с id %s не найдено или не может быть просмотрено", id));
                }
            }
        });

        getDetails.setOnAction(event -> {
            String id = groupIdEnter.getText();
            var resultEntity = rest.exchange("http://localhost:8080/destruct-hunter/api/v1/hunt/group/" + id, HttpMethod.GET, null, GroupHuntResult.class);

            GroupHuntResult result = resultEntity.getBody();
            List<String> destructList = result.getDestructComments();
            commentsArea.setText(destructList.toString());
        });


//        Diagrams.callHorisontalBarChart();
        Diagrams.callVerticalBarChart();
        Diagrams.callLineBarChart();
        Diagrams.callPieChart();

        log.info("Main scene successfully initialize.");
    }




}
