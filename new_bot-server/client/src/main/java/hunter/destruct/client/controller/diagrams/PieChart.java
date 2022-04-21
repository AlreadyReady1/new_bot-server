package hunter.destruct.client.controller.diagrams;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.beans.EventHandler;


public class PieChart {


    public static void callPieChart(){
        StackPane root = new StackPane();
        ObservableList<javafx.scene.chart.PieChart.Data> valueList = FXCollections.observableArrayList(
                new javafx.scene.chart.PieChart.Data("Деструктивные сообщения",4.451),
                new javafx.scene.chart.PieChart.Data("Нейтральные сообщения", 3.901),
                new javafx.scene.chart.PieChart.Data("Общее количество сообщений", 8.352));

        javafx.scene.chart.PieChart pieChart = new javafx.scene.chart.PieChart(valueList);
        pieChart.setTitle("Статистика за март");

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
        pieChart.setLegendSide(Side.LEFT);
        pieChart.setStartAngle(30);
        Scene scene = new Scene(root, 1000, 900);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Destruct_Hunter");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
