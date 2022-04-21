package hunter.destruct.client.controller;

import hunter.destruct.client.controller.diagrams.BarChart;
import hunter.destruct.client.controller.diagrams.LineChart;
import hunter.destruct.client.controller.diagrams.PieChart;
import hunter.destruct.client.dto.GroupHuntResult;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.SplitMenuButton;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

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
    @FXML
    public Button getGraphic;
    @FXML
    SplitMenuButton choseMonth;
    @FXML
    MenuItem Jan;

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

                int allCommentsCount =  Arrays.stream(result.getTotalPosts()).sum();        //

                int destroyCommentsCount = Arrays.stream(result.getDestructPosts()).sum();
                String stringResult = destroyCommentsCount < result.getPostCount() - destroyCommentsCount ?

                                String.format("Сообщество \"%s\" не является деструктивным."+ "\n"+ "Общее количество комментариев (постов): %d" +"\n"+" Процент деструктивных комментариев (постов): %d", result.getGroupName(), allCommentsCount, destroyCommentsCount / result.getPostCount() * 100) :
                                String.format("Сообщество \"%s\"  потенциально деструктивно."+ "\n"+ "Общее колиество комментариев (постов): %d"  +"\n"+"Процент деструктивных комментариев (постов): %d", result.getGroupName(), allCommentsCount, destroyCommentsCount * 100 / result.getPostCount());

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

        getGraphic.setOnAction(event -> {
            BarChart.callVerticalBarChart();
            BarChart.callHorizontalBarChart();
            LineChart.callLineChart();
        });

//        choseMonth.setOnAction(event ->{
//            PieChart.callPieChart();
//        });
        Jan.setOnAction(event ->{
            SplitMenu.callJan();        //добавить остальные кнопки
        });

        log.info("Main scene successfully initialize.");
    }




}
