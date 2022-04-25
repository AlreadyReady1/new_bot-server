package hunter.destruct.client.controller.diagrams;

import hunter.destruct.client.constansts.Month;
import hunter.destruct.client.dto.GroupHuntResult;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;

public class LineChart {

    public static void callLineChart(Map<Month, GroupHuntResult.Stats> dataMap){

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("млн. сообщений");

        javafx.scene.chart.LineChart<String,Number> lineChart = new javafx.scene.chart.LineChart<String,Number>(xAxis,yAxis);  // Create a LineChart

        XYChart.Series<String, Number> destructData = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> allData = new XYChart.Series<String, Number>();
        destructData.setName("Деструктивные сообщения");
        allData.setName("Общее количество сообщений");

        for (Map.Entry<Month, GroupHuntResult.Stats> monthStat : dataMap.entrySet()) {
            destructData.getData().add(new XYChart.Data<>(monthStat.getKey().getRussianName(), monthStat.getValue().getDestructComments()));
            allData.getData().add(new XYChart.Data<>(monthStat.getKey().getRussianName(), monthStat.getValue().getAllComments()));
        }

        lineChart.getData().add(destructData);
        lineChart.getData().add(allData);
        lineChart.setTitle("Годовая динамика сообщений");

        VBox vbox = new VBox(lineChart);

        Stage primaryStage3 = new Stage();
        primaryStage3.setTitle("Destruct_Hunter");
        Scene scene = new Scene(vbox, 600, 500);

        primaryStage3.setScene(scene);
        primaryStage3.setHeight(500);
        primaryStage3.setWidth(1000);
        primaryStage3.setY(500);
        primaryStage3.setX(5);
        primaryStage3.toFront();

        primaryStage3.show();

    }

}
