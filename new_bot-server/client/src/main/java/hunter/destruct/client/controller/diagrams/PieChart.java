package hunter.destruct.client.controller.diagrams;

import hunter.destruct.client.constansts.DestructClassName;
import hunter.destruct.client.constansts.Month;
import hunter.destruct.client.dto.GroupHuntResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class PieChart {

    public static void get(Month month, GroupHuntResult.Stats stats) {

        if (stats==null)return;
        StackPane root = new StackPane();

        ObservableList<javafx.scene.chart.PieChart.Data> valueList = dataFrom(stats);

        javafx.scene.chart.PieChart pieChart = new javafx.scene.chart.PieChart(valueList);
        pieChart.setTitle("Статистика за " + month.getRussianName());
        pieChart.setData(valueList);
        root.getChildren().addAll(pieChart);

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

    private static ObservableList<javafx.scene.chart.PieChart.Data> dataFrom(GroupHuntResult.Stats stats) {
        return FXCollections.observableArrayList(
                new javafx.scene.chart.PieChart.Data(DestructClassName.GOVERMENT, stats.getMessagesAboutSeparatism()),
                new javafx.scene.chart.PieChart.Data(DestructClassName.ETNOS, stats.getMessagesAboutTerrorism()),
                new javafx.scene.chart.PieChart.Data(DestructClassName.DRUGS, stats.getMessagesAboutDrugs()),
                new javafx.scene.chart.PieChart.Data(DestructClassName.NEUTRAL, (stats.getAllComments()) - stats.getDestructComments()));
    }

}
