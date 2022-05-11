package hunter.destruct.client.controller.diagrams;

import hunter.destruct.client.constansts.Month;
import hunter.destruct.client.dto.GroupHuntResult;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class LineChart {

    public static void callLineChart(Map<LocalDate, GroupHuntResult.Stats> dataMap){

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("млн. сообщений");

        javafx.scene.chart.LineChart<String,Number> lineChart = new javafx.scene.chart.LineChart<String,Number>(xAxis,yAxis);  // Create a LineChart

        XYChart.Series<String, Number> destructData = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> allData = new XYChart.Series<String, Number>();
        destructData.setName("Деструктивные сообщения");
        allData.setName("Общее количество сообщений");

        dataMap.keySet().stream()
                .sorted(dateComparator())
                .forEach(date -> {
                    destructData.getData().add(
                            new XYChart.Data<>(
                                    date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()),
                                    dataMap.containsKey(date.minusMonths(1)) ? dataMap.get(date).getDestructComments() - dataMap.get(date.minusMonths(1)).getDestructComments() : 0
                            )
                    );
                    allData.getData().add(
                            new XYChart.Data<>(
                                    date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()),
                                    dataMap.containsKey(date.minusMonths(1)) ? dataMap.get(date).getAllComments() - dataMap.get(date.minusMonths(1)).getAllComments() : 0
                            )
                    );
                });

//        var destructDataList = dataMap.keySet().stream()
//                .sorted(dateComparator())
//                .map(date -> dataMap.get(date).getDestructComments())
//                .toList();

//        for (int i = 0; i < destructDataList.size(); i++) {
//            if (i == 0)
//                continue;
//            destructData.getData().add(new XYChart.Data<>())
//        }

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

    private static Comparator<LocalDate> dateComparator() {
        return new Comparator<LocalDate>() {
            @Override
            public int compare(LocalDate o1, LocalDate o2) {
                if (o1.isAfter(o2))
                    return 1;
                if (o1.isBefore(o2))
                    return -1;
                else
                    return 0;
            }
        };
    }
}
