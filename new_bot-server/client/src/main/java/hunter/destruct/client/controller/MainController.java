package hunter.destruct.client.controller;

import hunter.destruct.client.controller.diagrams.BarChart;
import hunter.destruct.client.controller.diagrams.LineChart;
import hunter.destruct.client.dto.GroupHuntResult;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//todo: переменные все public. Нехорошо)
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
    public Button csvSave;
    @FXML
    SplitMenuButton choseMonth;
    @FXML
    MenuItem Jan;
    @FXML
    MenuItem Feb;
    @FXML
    MenuItem Mar;
    @FXML
    MenuItem Apr;
    @FXML
    MenuItem May;
    @FXML
    MenuItem Jun;
    @FXML
    MenuItem Jul;
    @FXML
    MenuItem Aug;
    @FXML
    MenuItem Sep;
    @FXML
    MenuItem Oct;
    @FXML
    MenuItem Nov;
    @FXML
    MenuItem Dec;



    private final RestTemplate rest = new RestTemplate();

//
//    @FXML
//    Button vbMenu;
//    @FXML
//    private void choseSaveFile() {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setInitialDirectory(new File("D:\\git"));
//        Window stage = vbMenu.getScene().getWindow();
//        fileChooser.setTitle("Выберите файл сохранения");
//        fileChooser.setInitialFileName("mysave");
//        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"),
//                new FileChooser.ExtensionFilter("csv", "*.csv"), new FileChooser.ExtensionFilter("pdf", "*.pdf")
//        );
//        try {
//            File file = fileChooser.showSaveDialog(stage);
//            fileChooser.setInitialDirectory(file.getParentFile());
//        }catch (Exception e)
//        {
//            System.out.println("Ошибка сохранения");
//        }
//
//    }


    @FXML
    private void initialize() {
        log.info("Init main scene...");
        commentsArea.setWrapText(true);
        groupHunt.setOnAction(event -> {
            String id = groupIdEnter.getText();
            try {
                var resultEntity = rest.exchange("http://localhost:8080/destruct-hunter/api/v1/hunt/group/" + id, HttpMethod.GET, null, GroupHuntResult.class);

                GroupHuntResult result = resultEntity.getBody();

                int allCommentsCount = Arrays.stream(result.getTotalPosts()).sum();        //

                int destroyCommentsCount = Arrays.stream(result.getDestructPosts()).sum();
                String stringResult = destroyCommentsCount < result.getPostCount() - destroyCommentsCount ?

                        String.format("Сообщество \"%s\" не является деструктивным." + "\n" + "Общее количество комментариев (постов): %d" + "\n" + " Процент деструктивных комментариев (постов): %d", result.getGroupName(), allCommentsCount, destroyCommentsCount / result.getPostCount() * 100) :
                        String.format("Сообщество \"%s\"  потенциально деструктивно." + "\n" + "Общее колиество комментариев (постов): %d" + "\n" + "Процент деструктивных комментариев (постов): %d", result.getGroupName(), allCommentsCount, destroyCommentsCount * 100 / result.getPostCount());

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


        csvSave.setOnAction(event -> {
            String id = groupIdEnter.getText();
            var resultEntity = rest.exchange("http://localhost:8080/destruct-hunter/api/v1/hunt/group/" + id, HttpMethod.GET, null, GroupHuntResult.class);
            GroupHuntResult result = resultEntity.getBody();
            List<String> destructListt = result.getDestructComments();
//            String str = CSVconverter.listToCsv(destructListt, '.');
            commentsArea.setText("Данные сохранены"+"\n");
            CSVconverter.saveCSV(destructListt);


        });

        getGraphic.setOnAction(event -> {
            BarChart.callVerticalBarChart();
//            BarChart.callHorizontalBarChart();
            LineChart.callLineChart();
        });

//        choseMonth.setOnAction(event ->{
//            PieChart.callPieChart();
//        });
//
// добавить остальные кнопки
        //todo: имена полей должны начинаться с маленькой буквы
        //todo: написал, как стоит это поменять в SplitMenu
        Jan.setOnAction(event -> {
            SplitMenu.callJan();
        });

        Feb.setOnAction(event -> {
            SplitMenu.callFeb();
        });

        Mar.setOnAction(event -> {
            SplitMenu.callMar();
        });

        Apr.setOnAction(event -> {
            SplitMenu.callApr();
        });

        May.setOnAction(event -> {
            SplitMenu.callMay();
        });

        Jun.setOnAction(event -> {
            SplitMenu.callJun();
        });

        Jul.setOnAction(event -> {
            SplitMenu.callJul();
        });

        Aug.setOnAction(event -> {
            SplitMenu.callAug();
        });

        Sep.setOnAction(event -> {
            SplitMenu.callSep();
        });

        Oct.setOnAction(event -> {
            SplitMenu.callOct();
        });

        Nov.setOnAction(event -> {
            SplitMenu.callNow();
        });

        Dec.setOnAction(event -> {
            SplitMenu.callDec();
        });

        log.info("Main scene successfully initialize.");
    }


}
