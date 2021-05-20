
package myfleet.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This the principal class to run the app
 * @author vmatag
 * @version javaFx_1.0
 * @since 8
 */
public class Main extends Application {

    /**
     * This method will start the application showing the window with the name and size specified
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("My Fleet");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be launched through deployment artifacts,
     * e.g., in IDEs with limited FX support.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
