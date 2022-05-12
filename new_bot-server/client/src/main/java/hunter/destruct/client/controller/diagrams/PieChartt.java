package hunter.destruct.client.controller.diagrams;

import hunter.destruct.client.constansts.DestructClassName;
import hunter.destruct.client.dto.GroupHuntResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class PieChartt {

    public static void get(Month month, GroupHuntResult.Stats stats) {

        if (stats==null)return;
        StackPane root = new StackPane();

        ObservableList<javafx.scene.chart.PieChart.Data> valueList = dataFrom(stats);

        javafx.scene.chart.PieChart pieChart = new javafx.scene.chart.PieChart(valueList);
        pieChart.setTitle("Статистика за " + month.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()));
        pieChart.setData(valueList);

        final Label caption = new Label("");
        caption.setTextFill(Color.BLACK);
        caption.setStyle("-fx-font: 12 arial;");

        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    caption.setTranslateX(mouseEvent.getX());
                    caption.setTranslateY(mouseEvent.getY());
                    caption.setText(String.valueOf(data.getPieValue()));
                }
            });
        }

        root.getChildren().addAll(pieChart, caption);

        pieChart.setStartAngle(30);
        Scene scene = new Scene(root, 900, 600);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("DkSearcher");
        primaryStage.setScene(scene);
        primaryStage.setX(950);
        primaryStage.setY(350);
        primaryStage.toFront();

        primaryStage.getIcons().add(new Image("image.png"));


        primaryStage.show();
    }

    private static ObservableList<javafx.scene.chart.PieChart.Data> dataFrom(GroupHuntResult.Stats stats) {
        return FXCollections.observableArrayList(
                new javafx.scene.chart.PieChart.Data(DestructClassName.GOVERMENT, stats.getMessagesAboutSeparatism()),
                new javafx.scene.chart.PieChart.Data(DestructClassName.ETNOS, stats.getMessagesAboutTerrorism()),
                new javafx.scene.chart.PieChart.Data(DestructClassName.DRUGS, stats.getMessagesAboutDrugs()),
                new javafx.scene.chart.PieChart.Data(DestructClassName.NEUTRAL, (stats.getAllComments() - stats.getDestructComments()))
        );
    }
}
