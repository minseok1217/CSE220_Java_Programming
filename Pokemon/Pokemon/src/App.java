import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class App extends Application{
    @Override
    public void start(Stage primarStage) throws Exception{
        Label myLabel =new Label("Hello world");
        StackPane pane = new StackPane();
        pane.getChildren().add(myLabel);
        primarStage.setTitle("Simple JavaFX app");
        primarStage.setScene((new Scene(pane,300,200)));
        primarStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}