package hunter.destruct.client.controller.diagrams;

import hunter.destruct.client.controller.RandNumber;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static hunter.destruct.client.controller.Month.*;


public class BarChart {



    public static void callVerticalBarChart() {

        CategoryAxis yAxis = new CategoryAxis();
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("млн. сообщений");




        // Create a BarChart
        javafx.scene.chart.BarChart<String, Number> barChart = new javafx.scene.chart.BarChart<String, Number>(yAxis, xAxis);

        // Series 1 - Data of 2020
        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
        dataSeries1.setName("Деструктивные сообщения");

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


        //общее количество
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


        // Add Series to BarChart.
        barChart.getData().add(dataSeries1);
        barChart.getData().add(dataSeries2);

        barChart.setTitle("Годовая статистика");

        VBox vbox = new VBox(barChart);

        Stage primaryStage2 = new Stage();
        primaryStage2.setTitle("Destruct_Hunter");
        Scene scene = new Scene(vbox, 10500, 800);

        primaryStage2.setScene(scene);
        primaryStage2.setHeight(500);
        primaryStage2.setWidth(1000);
        primaryStage2.setY(10);
        primaryStage2.setX(5);
        primaryStage2.toFront();
        primaryStage2.show();


    }

//    public static void callHorizontalBarChart(){
//
//        CategoryAxis xAxis = new CategoryAxis();
//        xAxis.setLabel("Programming Language");
//
//        NumberAxis yAxis = new NumberAxis();
//        yAxis.setLabel("Percent");
//
//        // Create a BarChart
//        javafx.scene.chart.BarChart<Number, String> barChart = new   javafx.scene.chart.BarChart<Number, String>(yAxis, xAxis);
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
//
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
//
//    }

}
