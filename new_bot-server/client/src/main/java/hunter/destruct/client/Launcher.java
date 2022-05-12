package hunter.destruct.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class Launcher extends Application {

    private static Stage primaryStage;
    private static BorderPane rootLayout;
    private static final String TITLE = "DkSearcher";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setMinWidth(600);
        this.primaryStage.setMinHeight(550);
        this.primaryStage.setTitle(TITLE);
        this. primaryStage.getIcons().add(new Image("image.png"));

        initRootLayout();
        showMainScene();
    }
    public void initRootLayout() throws Exception{
        log.info("Initialization root layout...");

        FXMLLoader rootLoader = new FXMLLoader();
        rootLoader.setLocation(Launcher.class.getResource("/RootLayout.fxml"));
        rootLayout = (BorderPane) rootLoader.load();
        Scene rootScene = new Scene(rootLayout);

        primaryStage.setResizable(true);
        primaryStage.setScene(rootScene);
        primaryStage.show();

        log.info("Complete");
    }

    public static void showMainScene() throws IOException {
        log.info("Initialization main application scene...");
        FXMLLoader mainLoader = new FXMLLoader();
        mainLoader.setLocation(Launcher.class.getResource("/Main.fxml"));
        AnchorPane mainScene = (AnchorPane) mainLoader.load();
        rootLayout.setCenter(mainScene);

        log.info("Complete");
    }
}
