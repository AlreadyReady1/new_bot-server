package hunter.destruct.client.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class Diagrams {

//    public static void callHorisontalBarChart() {
//
//        CategoryAxis xAxis = new CategoryAxis();
//        xAxis.setLabel("Programming Language");
//
//        NumberAxis yAxis = new NumberAxis();
//        yAxis.setLabel("Percent");
//
//        // Create a BarChart
//        BarChart<Number, String> barChart = new BarChart<Number, String>(yAxis, xAxis);
//
//        // Series 1 - Data of 2020
//        XYChart.Series<Number, String> dataSeries1 = new XYChart.Series<Number, String>();
//        dataSeries1.setName("2020");
//
//        dataSeries1.getData().add(new XYChart.Data(3.256,"Январь 2021"));
//        dataSeries1.getData().add(new XYChart.Data(2.856,"Февраль 2021"));
//        dataSeries1.getData().add(new XYChart.Data(2.989,"Март 2021"));
//        dataSeries1.getData().add(new XYChart.Data(3.14,"Апрель 2021"));
//        dataSeries1.getData().add(new XYChart.Data(3.499,"Май 2021"));
//        dataSeries1.getData().add(new XYChart.Data(3.345,"Июнь 2021"));
//        dataSeries1.getData().add(new XYChart.Data(3.392,"Июль 2021"));
//        dataSeries1.getData().add(new XYChart.Data(3.515,"Август 2021"));
//        dataSeries1.getData().add(new XYChart.Data(3.443,"Сентябрь 2021"));
//        dataSeries1.getData().add(new XYChart.Data(3.199,"Октябрь 2021"));
//        dataSeries1.getData().add(new XYChart.Data(3.922,"Ноябрь 2021"));
//        dataSeries1.getData().add(new XYChart.Data(3.995,"Декабрь 2021"));
//
//        dataSeries1.getData().add(new XYChart.Data(3.919,"Январь 2022" ));
//        dataSeries1.getData().add(new XYChart.Data(4.414,"Февраль 2022" ));
//        dataSeries1.getData().add(new XYChart.Data(4.151,"Март 2022"));
////        dataSeries1.getData().add(new XYChart.Data<Number, String>(20.973, "Java"));
////        dataSeries1.getData().add(new XYChart.Data<Number, String>(4.429, "C#"));
////        dataSeries1.getData().add(new XYChart.Data<Number, String>(2.792, "PHP"));
//
//        // Series 2 - Data of 2021
//        XYChart.Series<Number, String> dataSeries2 = new XYChart.Series<Number, String>();
//        dataSeries2.setName("2021");
//
//        dataSeries2.getData().add(new XYChart.Data( 3.600,"Январь 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.416,"Февраль 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.291,"Март 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.398,"Апрель 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.199,"Май 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.438,"Июнь 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.792,"Июль 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.515,"Август 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.443,"Сентябрь 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.299,"Октябрь 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.422,"Ноябрь 2021"));
//        dataSeries2.getData().add(new XYChart.Data(3.695,"Декабрь 2021"));
//
//        dataSeries2.getData().add(new XYChart.Data(4.112,"Январь 2022"));
//        dataSeries2.getData().add(new XYChart.Data(4.224,"Февраль 2022"));
//        dataSeries2.getData().add(new XYChart.Data(4.101,"Март 2022"));
//
//        //общее количество
//        XYChart.Series<Number, String> dataSeries3 = new XYChart.Series<Number, String>();
//        dataSeries3.setName("Общее количество сообщений");
//        dataSeries3.getData().add(new XYChart.Data(6.856,"Январь 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 6.272,"Февраль 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 6.280,"Март 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 6.538,"Апрель 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 6.698,"Май 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 6.783,"Июнь 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 7.184,"Июль 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 7.276,"Август 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 6.971,"Сентябрь 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 6.498,"Октябрь 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 7.344,"Ноябрь 2021"));
//        dataSeries3.getData().add(new XYChart.Data( 7.690,"Декабрь 2021"));
//
//        dataSeries3.getData().add(new XYChart.Data(8.031,"Январь 2022"));
//        dataSeries3.getData().add(new XYChart.Data(8.638,"Февраль 2022"));
//        dataSeries3.getData().add(new XYChart.Data( 8.252,"Март 2022"));
//
//        // Add Series to BarChart.
//        barChart.getData().add(dataSeries1);
//        barChart.getData().add(dataSeries2);
//        barChart.getData().add(dataSeries3);
//
//        barChart.setBarGap(5);
//
//        barChart.setTitle("Статистика");
//
//        VBox vbox = new VBox(barChart);
//
//        Stage primaryStage1 = new Stage();
//        primaryStage1.setTitle("Destruct_Hunter");
//        Scene scene = new Scene(vbox, 400, 200);
//
//        primaryStage1.setScene(scene);
//        primaryStage1.setHeight(500);
//        primaryStage1.setWidth(1000);
//
//        primaryStage1.show();
//    }

    protected static void callPieChart(){
        Pane root = new Pane();
//        ObservableList<PieChart.Data> valueList = FXCollections.observableArrayList(
//                new PieChart.Data("Android", 55),
//                new PieChart.Data("IOS", 33),
//                new PieChart.Data("Windows", 12));
//        // create a pieChart with valueList data.
//        PieChart pieChart = new PieChart(valueList);
//        pieChart.setTitle("Popularity of Mobile OS");
        ObservableList<PieChart.Data> valueList = FXCollections.observableArrayList(
                new PieChart.Data("Деструктивные сообщения",4.451),
                new PieChart.Data("Нейтральные сообщения", 3.901),
                new PieChart.Data("Общее количество сообщений", 8.352));

        PieChart pieChart = new PieChart(valueList);
        pieChart.setTitle("Статистика за март");

        pieChart.getData().forEach(data -> {
            String percentage = String.format("%.2f%%", (data.getPieValue()));
            Tooltip toolTip = new Tooltip(percentage);
            Tooltip.install(data.getNode(), toolTip);});
        //adding pieChart to the root.
        root.getChildren().addAll(pieChart);
        Scene scene = new Scene(root, 450, 450);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Destruct_Hunter");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    protected static void callVerticalBarChart() {

        CategoryAxis yAxis = new CategoryAxis();


        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("млн. сообщений");


        // Create a BarChart
        BarChart<String, Number> barChart = new BarChart<String, Number>(yAxis, xAxis);

        // Series 1 - Data of 2020
        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
        dataSeries1.setName("Деструктивные сообщения");

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

        // Series 2 - Data of 2021
        XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<String, Number>();
        dataSeries2.setName("Нейтральные сообщения");

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
        //общее количество
        XYChart.Series<String, Number> dataSeries3 = new XYChart.Series<String, Number>();
        dataSeries3.setName("Общее количество сообщений");
        dataSeries3.getData().add(new XYChart.Data("Январь 2021", 6.856));
        dataSeries3.getData().add(new XYChart.Data("Февраль 2021", 6.272));
        dataSeries3.getData().add(new XYChart.Data("Март 2021", 6.280));
        dataSeries3.getData().add(new XYChart.Data("Апрель 2021", 6.538));
        dataSeries3.getData().add(new XYChart.Data("Май 2021", 6.698));
        dataSeries3.getData().add(new XYChart.Data("Июнь 2021", 6.783));
        dataSeries3.getData().add(new XYChart.Data("Июль 2021", 7.184));
        dataSeries3.getData().add(new XYChart.Data("Август 2021", 7.276));
        dataSeries3.getData().add(new XYChart.Data("Сентябрь 2021", 6.971));
        dataSeries3.getData().add(new XYChart.Data("Октябрь 2021", 6.498));
        dataSeries3.getData().add(new XYChart.Data("Ноябрь 2021", 7.344));
        dataSeries3.getData().add(new XYChart.Data("Декабрь 2021", 7.690));

        dataSeries3.getData().add(new XYChart.Data("Январь 2022", 8.031));
        dataSeries3.getData().add(new XYChart.Data("Февраль 2022", 8.638));
        dataSeries3.getData().add(new XYChart.Data("Март 2022", 8.252));

        // Add Series to BarChart.
        barChart.getData().add(dataSeries1);
        barChart.getData().add(dataSeries2);
        barChart.getData().add(dataSeries3);

        barChart.setTitle("Годовая статистика");

        VBox vbox = new VBox(barChart);

        Stage primaryStage2 = new Stage();
        primaryStage2.setTitle("Destruct_Hunter");
        Scene scene = new Scene(vbox, 10500, 800);

        primaryStage2.setScene(scene);
        primaryStage2.setHeight(1000);
        primaryStage2.setWidth(1200);

        primaryStage2.show();
    }

    protected static void callLineBarChart() {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("млн. сообщений");


        LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);  // Create a LineChart
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




