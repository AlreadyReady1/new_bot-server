package hunter.destruct.client.controller.diagrams;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class PieChart {
    static String str1 = "Деструктивные сообщения";
    static String str2 = "Нейтральные сообщения";
    static String str3 = "Общее количество сообщений";

//    double govermentDestructMessage, double religionDestructMessage, double drugsDestructMessage, double numberOfNeutralMessage
    public static void callPieChart( ){

        double max = 10;
        double min = 1;
        double randGov = ((Math.random() * (max - min)) + min)*0.24;
        double randDrug = ((Math.random() * (max - min)) + min)*0.12;
        double randRelig = ((Math.random() * (max - min)) + min)*0.2;
        double randNetral = ((Math.random() * (max - min)) + min)*0.44;

        double allMessage = randDrug+randGov+randRelig+randNetral;

//        double numberOfAllMessage = govermentDestructMessage + religionDestructMessage + drugsDestructMessage + numberOfNeutralMessage;

        StackPane root = new StackPane();


        ObservableList<javafx.scene.chart.PieChart.Data> valueList = FXCollections.observableArrayList(
                new javafx.scene.chart.PieChart.Data("Подрыв суверенитета государства и политической стабильности",randGov),
                new javafx.scene.chart.PieChart.Data("Разжигание этнической и религиозной ненависти",randRelig),
                new javafx.scene.chart.PieChart.Data("Пропаганда наркотиков",randDrug),
//                new javafx.scene.chart.PieChart.Data("Деструктивные сообщения",numberOfDestructMessage),
//                new javafx.scene.chart.PieChart.Data("Общее количество сообщений", numberOfAllMessage),
                new javafx.scene.chart.PieChart.Data("Нейтральные сообщения", randNetral));

        javafx.scene.chart.PieChart pieChart = new javafx.scene.chart.PieChart(valueList);
        pieChart.setTitle("Статистика за ");

        pieChart.getData().forEach(data -> {
//            String percentage = String.format("..2f%%", (data.getPieValue()));
            String percentage = String.format("%f", (data.getPieValue()));

            Tooltip toolTip = new Tooltip(percentage);
            Tooltip.install(data.getNode(), toolTip);});
        //adding pieChart to the root.
        root.getChildren().addAll(pieChart);


//        final Label caption = new Label("");
//        caption.setTextFill(Color.WHITE);
//        caption.setStyle("-fx-font: 12 arial;");
//
//        for (final javafx.scene.chart.PieChart.Data data : pieChart.getData()) {
//            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler() {
//
//                public void handle(MouseEvent e) {
//                    caption.setTranslateX(e.getX());
//                    caption.setTranslateY(e.getY());
//
//                    caption.setText(String.valueOf(data.getPieValue()));
//                }
//            });
//        }


//        pieChart.setLegendSide(Side.LEFT);
        pieChart.setStartAngle(30);
        Scene scene = new Scene(root, 500, 400);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Destruct_Hunter");
        primaryStage.setScene(scene);
        primaryStage.setX(1250);
        primaryStage.setY(100);
        primaryStage.toFront();

        primaryStage.show();


    }

}
