package hunter.destruct.client.controller.diagrams;

import hunter.destruct.client.dto.GroupHuntResult;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;


public class BarChart {


    public static void callVerticalBarChart(Map<LocalDate, GroupHuntResult.Stats> dataMap) {

        CategoryAxis yAxis = new CategoryAxis();
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("млн. сообщений");

        // Create a BarChart
        javafx.scene.chart.BarChart<String, Number> barChart = new javafx.scene.chart.BarChart<>(yAxis, xAxis);

        // Series 1 - Data of 2020
        XYChart.Series<String, Number> destructData = new XYChart.Series<>();
        XYChart.Series<String, Number> allData = new XYChart.Series<String, Number>();
        destructData.setName("Деструктивные сообщения");
        allData.setName("Общее количество сообщений");

        dataMap.keySet().stream()
                .sorted(dateComparator())
                .forEach(date -> {
                    destructData.getData().add(new XYChart.Data<>(date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()), dataMap.get(date).getDestructComments()));
                    allData.getData().add(new XYChart.Data<>(date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()), dataMap.get(date).getAllComments()));
                });

        barChart.getData().add(destructData);
        barChart.getData().add(allData);

        //


        //

        barChart.setTitle("Годовая статистика");

        VBox vbox = new VBox(barChart);


        Stage primaryStage2 = new Stage();
        primaryStage2.setTitle("DkSearcher");
        Scene scene = new Scene(vbox, 10500, 800);



        primaryStage2.setScene(scene);
        primaryStage2.setHeight(500);
        primaryStage2.setWidth(1000);
        primaryStage2.setY(10);
        primaryStage2.setX(5);
        primaryStage2.toFront();

        primaryStage2.getIcons().add(new Image("image.png"));

        primaryStage2.show();
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



































































































