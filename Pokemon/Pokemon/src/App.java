import javax.crypto.SealedObject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application {
    private TextField nameField = new TextField();
    private User user = new User();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane inputUserName = new GridPane();
        inputUserName.setPadding(new Insets(10));
        inputUserName.setHgap(10);

        Label nameLabel = new Label("User Name");
        Button nameButton = new Button("Save");
        inputUserName.add(nameLabel, 0, 0);
        inputUserName.add(nameButton, 2, 0, 2, 1);
        inputUserName.add(nameField, 1, 0);
        inputUserName.setAlignment(Pos.CENTER);

        nameButton.setOnAction(event -> changeName(primaryStage));

        primaryStage.setTitle("PokeMon");
        primaryStage.setScene(new Scene(inputUserName, 500, 300));
        primaryStage.show();
    }

    private void changeName(Stage primaryStage) {
        String newName = nameField.getText();
        user.setUserName(newName);
        String welcomeMessage = user.getUserName() + "님 환영합니다.";

        showWelcomeMessage(primaryStage, welcomeMessage);
    }

    private void showWelcomeMessage(Stage primaryStage, String welcomeMessage) {
        GridPane welcomePane = new GridPane();
        welcomePane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        welcomePane.setPadding(new Insets(20));
        welcomePane.setHgap(10);

        Label welcomeLabel = new Label(welcomeMessage);
        welcomeLabel.setTextFill(Color.WHITE);
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        welcomePane.add(welcomeLabel, 0, 0);
        welcomePane.setAlignment(Pos.CENTER);

        Stage welcomeStage = new Stage();
        welcomeStage.setScene(new Scene(welcomePane, 500, 300));
        welcomeStage.setTitle("WelCome Mesege");
        welcomeStage.show();
        welcomePane.setOnMouseClicked(event -> goToNextScreen(welcomeStage));
    }

    private void goToNextScreen(Stage currentStage) {
        currentStage.close();

       GridPane welcomePane_2 = new GridPane();
        welcomePane_2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        welcomePane_2.setPadding(new Insets(20));
        welcomePane_2.setHgap(10);

        Label welcomeLabel_2 = new Label("야생 포켓몬을 잡을 때 \n사용할 포켓몬을 선택해주세요.");
        welcomeLabel_2.setTextFill(Color.WHITE);
        welcomeLabel_2.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        welcomePane_2.add(welcomeLabel_2, 0, 0);
        welcomePane_2.setAlignment(Pos.CENTER);

        Stage welcomeStage = new Stage();
        welcomeStage.setScene(new Scene(welcomePane_2, 500, 300));
        welcomeStage.setTitle("WelCome Mesege");
        welcomeStage.show();
    }

    private void selectPokemonScreen(Stage currentStage){
        currentStage.close();
        GridPane seletePane_2 = new GridPane();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
