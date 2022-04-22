package hunter.destruct.client.controller.diagrams;

import hunter.destruct.client.controller.RandNumber;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static hunter.destruct.client.controller.Month.*;

//todo: сделай, что бы метод хэшмапу принимал. И тогда сможешь по нормальному сборку сделать
public class LineChart {

    public static void callLineChart(){

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("млн. сообщений");


        javafx.scene.chart.LineChart<String,Number> lineChart = new javafx.scene.chart.LineChart<String,Number>(xAxis,yAxis);  // Create a LineChart
        lineChart.setTitle("Stock Monitoring, 2020");

        // Series 1
        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
        dataSeries1.getData().add(new XYChart.Data(JANUARY.getName(), RandNumber.getRand1()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(FEBRUARY.getName(), RandNumber.getRand2()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(MARCH.getName(), RandNumber.getRand3()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(APRIL.getName(), RandNumber.getRand4()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(MAY.getName(), RandNumber.getRand5()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(JUNE.getName(), RandNumber.getRand6()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(JULY.getName(), RandNumber.getRand7()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(AUGUST.getName(), RandNumber.getRand8()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(SEPTEMBER.getName(), RandNumber.getRand9()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(OCTOBER.getName(), RandNumber.getRand10()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(NOVEMBER.getName(), RandNumber.getRand11()* RandNumber.getRandFactor()));
        dataSeries1.getData().add(new XYChart.Data(DECEMBER.getName(), RandNumber.getRand12()* RandNumber.getRandFactor()));

//        dataSeries1.getData().add(new XYChart.Data(JANUARY.getName(), RandNumber.getRand13()*RandNumber.getRandFactor()));
//        dataSeries1.getData().add(new XYChart.Data(FEBRUARY.getName(), RandNumber.getRand14()*RandNumber.getRandFactor()));
//        dataSeries1.getData().add(new XYChart.Data(MARCH.getName(), RandNumber.getRand15()*RandNumber.getRandFactor()));

        dataSeries1.setName("Деструктивные сообщения");

        // Series 2
        XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<String, Number>();
        dataSeries2.setName("Общее количество сообщений");
        dataSeries2.getData().add(new XYChart.Data(JANUARY.getName(), RandNumber.getRand1()));
        dataSeries2.getData().add(new XYChart.Data(FEBRUARY.getName(), RandNumber.getRand2()));
        dataSeries2.getData().add(new XYChart.Data(MARCH.getName(), RandNumber.getRand3()));
        dataSeries2.getData().add(new XYChart.Data(APRIL.getName(), RandNumber.getRand4()));
        dataSeries2.getData().add(new XYChart.Data(MAY.getName(), RandNumber.getRand5()));
        dataSeries2.getData().add(new XYChart.Data(JUNE.getName(), RandNumber.getRand6()));
        dataSeries2.getData().add(new XYChart.Data(JULY.getName(), RandNumber.getRand7()));
        dataSeries2.getData().add(new XYChart.Data(AUGUST.getName(), RandNumber.getRand8()));
        dataSeries2.getData().add(new XYChart.Data(SEPTEMBER.getName(), RandNumber.getRand9()));
        dataSeries2.getData().add(new XYChart.Data(OCTOBER.getName(), RandNumber.getRand10()));
        dataSeries2.getData().add(new XYChart.Data(NOVEMBER.getName(), RandNumber.getRand11()));
        dataSeries2.getData().add(new XYChart.Data(DECEMBER.getName(), RandNumber.getRand12()));

//        dataSeries2.getData().add(new XYChart.Data(JANUARY.getName(), RandNumber.getRand13()));
//        dataSeries2.getData().add(new XYChart.Data(FEBRUARY.getName(), RandNumber.getRand14()));
//        dataSeries2.getData().add(new XYChart.Data(MARCH.getName(), RandNumber.getRand15()));


        // Add Series to LineChart.
        lineChart.getData().add(dataSeries1);
        lineChart.getData().add(dataSeries2);
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
