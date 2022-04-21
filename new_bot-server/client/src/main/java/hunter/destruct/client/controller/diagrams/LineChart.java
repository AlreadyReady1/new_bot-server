package hunter.destruct.client.controller.diagrams;

import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LineChart {

    public static void callLineChart(){

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("млн. сообщений");


        javafx.scene.chart.LineChart<String,Number> lineChart = new javafx.scene.chart.LineChart<String,Number>(xAxis,yAxis);  // Create a LineChart
        lineChart.setTitle("Stock Monitoring, 2020");

        // Series 1
        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
        dataSeries1.getData().add(new XYChart.Data("Январь 2021", 3.656));
        dataSeries1.getData().add(new XYChart.Data("Февраль 2021", 3.616));
        dataSeries1.getData().add(new XYChart.Data("Март 2021", 3.689));
        dataSeries1.getData().add(new XYChart.Data("Апрель 2021", 3.74));
        dataSeries1.getData().add(new XYChart.Data("Май 2021", 3.499));
        dataSeries1.getData().add(new XYChart.Data("Июнь 2021", 3.445));
        dataSeries1.getData().add(new XYChart.Data("Июль 2021", 3.992));
        dataSeries1.getData().add(new XYChart.Data("Август 2021", 3.761));
        dataSeries1.getData().add(new XYChart.Data("Сентябрь 2021", 3.443));
        dataSeries1.getData().add(new XYChart.Data("Октябрь 2021", 3.199));
        dataSeries1.getData().add(new XYChart.Data("Ноябрь 2021", 3.922));
        dataSeries1.getData().add(new XYChart.Data("Декабрь 2021", 3.995));

        dataSeries1.getData().add(new XYChart.Data("Январь 2022", 3.919));
        dataSeries1.getData().add(new XYChart.Data("Февраль 2022", 4.414));
        dataSeries1.getData().add(new XYChart.Data("Март 2022", 4.451));

        dataSeries1.setName("Деструктивные сообщения");

        // Series 2
        XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<String, Number>();
        dataSeries2.getData().add(new XYChart.Data("Январь 2021", 3.600));
        dataSeries2.getData().add(new XYChart.Data("Февраль 2021", 3.416));
        dataSeries2.getData().add(new XYChart.Data("Март 2021", 3.291));
        dataSeries2.getData().add(new XYChart.Data("Апрель 2021", 3.398));
        dataSeries2.getData().add(new XYChart.Data("Май 2021", 3.199));
        dataSeries2.getData().add(new XYChart.Data("Июнь 2021", 3.438));
        dataSeries2.getData().add(new XYChart.Data("Июль 2021", 3.792));
        dataSeries2.getData().add(new XYChart.Data("Август 2021", 3.515));
        dataSeries2.getData().add(new XYChart.Data("Сентябрь 2021", 3.443));
        dataSeries2.getData().add(new XYChart.Data("Октябрь 2021", 3.299));
        dataSeries2.getData().add(new XYChart.Data("Ноябрь 2021", 3.622));
        dataSeries2.getData().add(new XYChart.Data("Декабрь 2021", 3.895));

        dataSeries2.getData().add(new XYChart.Data("Январь 2022", 4.112));
        dataSeries2.getData().add(new XYChart.Data("Февраль 2022", 4.224));
        dataSeries2.getData().add(new XYChart.Data("Март 2022", 3.901));

        dataSeries2.setName("Нейтральные сообщения");


        // Add Series to LineChart.
        lineChart.getData().add(dataSeries1);
        lineChart.getData().add(dataSeries2);
        lineChart.setTitle("Динамика сообщений");

        VBox vbox = new VBox(lineChart);

        Stage primaryStage3 = new Stage();
        primaryStage3.setTitle("Destruct_Hunter");
        Scene scene = new Scene(vbox, 600, 500);

        primaryStage3.setScene(scene);
        primaryStage3.setHeight(500);
        primaryStage3.setWidth(800);

        primaryStage3.show();

    }

}
