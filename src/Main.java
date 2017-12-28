//import javafx.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by GrayOwl on 12/27/17.
 */
public class Main extends Application {
    //Stage primaryStage = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("coreui.fxml"));
        primaryStage.setTitle("Simple Music player");
        primaryStage.setScene(new Scene(root,300,400));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
