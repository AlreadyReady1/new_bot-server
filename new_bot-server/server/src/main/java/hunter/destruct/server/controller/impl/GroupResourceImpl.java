package hunter.destruct.server.controller.impl;

import hunter.destruct.server.controller.GroupResource;
import hunter.destruct.server.dto.GroupHuntResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class GroupResourceImpl implements GroupResource {

    @Override
    public ResponseEntity<GroupHuntResult> hunt(String groupId) {
        log.info("Checking group with id {} by destructive comments", groupId);
        if ("toportg".equals(groupId)) {
            return ResponseEntity.ok(GroupHuntResult.builder()
                    .groupName("ТОПОР")
                    .groupId(groupId)
                    .destructPosts(new int[]{56,10})
                    .postCount(100)
                    .destructComments(
                            List.of(

                                    "\n" + "На лбу каленым железом себе зешки набивайте. Идиоты." +"\n" +
                                           "Власть пора менять -  заигрались, зажрались" +"\n" +
                                           "Песков как п..данет че-нить ...позорник пути" +"\n" +
                                    "Дочь пермского депутата-миллиардера Плотникова, сидя в Дубае (где она и проводит большую часть жизни), пишет у себя в Инсте (который запрещён в РФ), что «Россия - лучшая страна, и все стали ещё сильнее патриотами»",
                                    "Уже не-депутат Николай Бондаренко о лже-национализации, от которой не пострадает ни один олигарх, «прихватизатор» и сырьевой барон!\n" +
                                            "Это позор, а не национализация! Яхты, виллы и миллиардные счета «золотой сотни Forbes” - это святое для правящей «элитки».\n" +
                                            "Национализацию надо начинать не с IKEA, McDonalds и ZARA, а с нефти, газа, леса, металлов, угля, золота, никеля, аллюминия, удобрений и других природных богатств России!",
                                    "Байден, вон, в Польшу приехал... встретился со своими солдатами и поел с ними пиццу.\n" +
                                            "Зеленский недавно посещал раненых украинских военнослужащих в госпитале.\n" +
                                            "А президент мира с рейтингом +100500% из бункера вообще вылезает? Ну, его же поддерживают более 73%... То есть 7-мь человек из 10-ти. Чего ж он с бойцами-то не встретится? Боится, что насмерть залюбят и зацелуют?\n" +
                                            "*Переадресуйте этот вопрос ватникам.",
                                    "Светлое будущее\n" +
                                            "\n" +
                                            "Чем бы ни завершилась «спец-операция» на Украине (а по текущим тенденциям у нее может быть два основных результата — переход к позиционной бесконечной не-войне-не-миру на достигнутых рубежах или заключение какого-то договора и вывод войск с сохранением занятых территорий на Донбассе и продолжение ни-войны-ни-мира), санкции уже никто снимать не будет. Усилят — возможно, но снимать — точно нет. Что в практическом плане будет означать экономическую катастрофу уже к лету. Надежды, что Китай нам поможет, выглядят не слишком обоснованными. Простой вопрос — а зачем? Второй момент: Китай — это ширпотреб. Он не заменит выпавшие технологии и комплектующие, расходники и сырье для этих технологий.\n" +
                                            "\n" + "Вот \"герои\" Донбасса имитируют \"обстрелы Донецка украинскими войсками.\"....\n" +
                                            "И со смехом: - \"- Чтобы не спали долго!\":",
                                    "Имбецил стреляет по своим",

                                    "Коммунисты КПРФ в шовинистическом угаре подзабыли видать тезисы своего вождя:",
                                    "ОНА ВАМ НЕ ПРОПАГАНДИСТ! Скандал вокруг редактора \"Первого канала\" Овсянниковой расколол россиян",
                                    "PR Овсянниковой продолжается, все Телеграмм-каналы забиты сообщениями:\n" +
                                            "Как быстро можно стать героем в этой горе-стране! Огромное количество журналистов уволилось из пропагандистских СМИ ещё в 2014-ом.\n" +
                                            "\n" +
                                            "Овсянниковы же... рисковать побоялись. Зато за 8 лет помогли разгореться тлеющему конфликту в настоящий пожар. А потом... просто извинились. И этого оказалось достаточно.\n" +
                                            "Может.. и мне в 14-ом надо было наплевать на совесть? Сейчас бы покаялся, да и все. Зато все эти 8 лет жил бы \"сытно\"."

                            )
                    ).build()
            );
        }

        return ResponseEntity.notFound().build();
    }
}