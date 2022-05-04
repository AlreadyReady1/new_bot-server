package hunter.destruct.client.controller.diagrams;

import hunter.destruct.client.constansts.DestructClassName;
import hunter.destruct.client.constansts.Month;
import hunter.destruct.client.dto.GroupHuntResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class PieChartt {

    public static void get(Month month, GroupHuntResult.Stats stats) {

        if (stats==null)return;
        StackPane root = new StackPane();

        ObservableList<javafx.scene.chart.PieChart.Data> valueList = dataFrom(stats);

        javafx.scene.chart.PieChart pieChart = new javafx.scene.chart.PieChart(valueList);
        pieChart.setTitle("Статистика за " + month.getRussianName());
        pieChart.setData(valueList);
        root.getChildren().addAll(pieChart);

        pieChart.setStartAngle(30);
        Scene scene = new Scene(root, 900, 900);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Destruct_Hunter");
        primaryStage.setScene(scene);
        primaryStage.setX(900);
        primaryStage.setY(100);
        primaryStage.toFront();

//        for (final PieChart.Data data : pieChart.getData()) {
//            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//                @Override
//
//            });

        primaryStage.show();
    }

    private static ObservableList<javafx.scene.chart.PieChart.Data> dataFrom(GroupHuntResult.Stats stats) {
        return FXCollections.observableArrayList(
                new javafx.scene.chart.PieChart.Data(DestructClassName.GOVERMENT, stats.getMessagesAboutSeparatism()),
                new javafx.scene.chart.PieChart.Data(DestructClassName.ETNOS, stats.getMessagesAboutTerrorism()),
                new javafx.scene.chart.PieChart.Data(DestructClassName.DRUGS, stats.getMessagesAboutDrugs()),
                new javafx.scene.chart.PieChart.Data(DestructClassName.NEUTRAL, (stats.getAllComments()) - stats.getDestructComments()));
    }
//        public void handle(MouseEvent e, javafx.scene.chart.PieChart.Data data) {
//            final Label caption = new Label("");
//            caption.setTextFill(Color.WHITE);
//            caption.setStyle("-fx-font: 12 arial;");
//            caption.setTranslateX(e.getSceneX());
//            caption.setTranslateY(e.getSceneY());
//
//            caption.setText(String.valueOf(data.getPieValue()));
//        }
}
