package hunter.destruct.client.controller;

import hunter.destruct.client.controller.diagrams.BarChart;
import hunter.destruct.client.controller.diagrams.LineChart;
import hunter.destruct.client.controller.diagrams.PieChartt;
import hunter.destruct.client.dto.GroupHuntResult;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class MainController {

    @FXML protected Button groupHunt;
    @FXML protected TextField groupIdEnter;
    @FXML protected TextArea commentsArea;
    @FXML protected Button getDetails;
    @FXML public Button getGraphic;
    @FXML public Button csvSave;
    @FXML SplitMenuButton choseMonth;
    @FXML MenuItem Jan;
    @FXML MenuItem Feb;
    @FXML MenuItem Mar;
    @FXML MenuItem Apr;
    @FXML MenuItem May;
    @FXML MenuItem Jun;
    @FXML MenuItem Jul;
    @FXML MenuItem Aug;
    @FXML MenuItem Sep;
    @FXML MenuItem Oct;
    @FXML MenuItem Nov;
    @FXML MenuItem Dec;

    private GroupHuntResult result;

    private final RestTemplate rest = new RestTemplate();

    @FXML
    private void initialize() {
        log.info("Init main scene...");
        commentsArea.setWrapText(true);
        groupHunt.setOnAction(event -> {
            String id = groupIdEnter.getText();
            try {
                var resultEntity = rest.exchange("http://localhost:8080/destruct-hunter/api/v1/hunt/group/" + id, HttpMethod.GET, null, GroupHuntResult.class);

                result = resultEntity.getBody();

                int allCommentsCount = result.getDataMap().values().stream()
                        .mapToInt(GroupHuntResult.Stats::getAllComments)
                        .sum();

                int destroyCommentsCount = result.getDataMap().values().stream()
                        .mapToInt(GroupHuntResult.Stats::getDestructComments)
                        .sum();
                String stringResult = destroyCommentsCount < allCommentsCount - destroyCommentsCount ?

                        String.format("Сообщество \"%s\" не является деструктивным." + "\n" + "Общее количество комментариев (постов): %d" + "\n" + " Процент деструктивных комментариев (постов): %d", result.getGroupName(), allCommentsCount, destroyCommentsCount * 100 / allCommentsCount) :
                        String.format("Сообщество \"%s\"  потенциально деструктивно." + "\n" + "Общее количество комментариев (постов): %d" + "\n" + "Процент деструктивных комментариев (постов): %d", result.getGroupName(), allCommentsCount, destroyCommentsCount * 100 / allCommentsCount);

                commentsArea.setText(stringResult);
            } catch (HttpClientErrorException exception) {
                if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                    result = GroupHuntResult.empty();
                    commentsArea.setText(String.format("Сообщество с id %s не найдено или не может быть просмотрено", id));
                }
            }
        });

        getDetails.setOnAction(event -> {
            List<String> destructList = result.getDestructComments();
            commentsArea.setText(destructList.toString());
        });


        csvSave.setOnAction(event -> {
            CSVSaver CSVSaver = new CSVSaver();
            List<String> destructListt = result.getDestructComments();
            CSVSaver.saveCSV(destructListt);
            commentsArea.setText("Данные сохранены" + "\n");

        });

        getGraphic.setOnAction(event -> {
            if (result != null && result.getDataMap() != null) {
                BarChart.callVerticalBarChart(result.getDataMap());
                LineChart.callLineChart(result.getDataMap());
            }
//            BarChart.callHorizontalBarChart();

        });

        Jan.setOnAction(event -> PieChartt.get(Month.JANUARY, result.getStatsByMonth(Month.JANUARY)));
        Feb.setOnAction(event -> PieChartt.get(Month.FEBRUARY, result.getStatsByMonth(Month.FEBRUARY)));
        Mar.setOnAction(event -> PieChartt.get(Month.MARCH, result.getStatsByMonth(Month.MARCH)));
        Apr.setOnAction(event -> PieChartt.get(Month.APRIL, result.getStatsByMonth(Month.APRIL)));
        May.setOnAction(event -> PieChartt.get(Month.MAY, result.getStatsByMonth(Month.MAY)));
        Jun.setOnAction(event -> PieChartt.get(Month.JUNE, result.getStatsByMonth(Month.MAY)));
        Jul.setOnAction(event -> PieChartt.get(Month.JULY, result.getStatsByMonth(Month.JULY)));
        Aug.setOnAction(event -> PieChartt.get(Month.AUGUST, result.getStatsByMonth(Month.AUGUST)));
        Sep.setOnAction(event -> PieChartt.get(Month.SEPTEMBER, result.getStatsByMonth(Month.SEPTEMBER)));
        Oct.setOnAction(event -> PieChartt.get(Month.OCTOBER, result.getStatsByMonth(Month.OCTOBER)));
        Nov.setOnAction(event -> PieChartt.get(Month.NOVEMBER, result.getStatsByMonth(Month.NOVEMBER)));
        Dec.setOnAction(event -> PieChartt.get(Month.DECEMBER, result.getStatsByMonth(Month.DECEMBER)));

        log.info("Main scene successfully initialize.");
    }
}
