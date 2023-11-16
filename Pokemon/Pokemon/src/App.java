// import java.awt.Color;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
// import javafx.scene.text.FontWeight;

public class App extends Application{
    private TextField nameField= new TextField ( ) ;
    private MenuItem nameChoice = new MenuItem("name");
    private User user = new User();
    @Override
    public void start(Stage primarStage) throws Exception{
        // Label myLabel =new Label("Hello world");
        // StackPane pane = new StackPane();
        // pane.getChildren().add(myLabel);
        GridPane input_user_name = new GridPane( );
        input_user_name.setPadding (new Insets (10));
        input_user_name.setHgap(10) ;
        
        Label nameLabel = new Label("user name") ;
        Button nameButton = new Button("save"); 
        input_user_name.add(nameLabel,0,0);
        input_user_name.add(nameButton, 0, 1, 2, 1);
        input_user_name.add(nameField,1,0);
        // input_user_name.setPadding()
        input_user_name.setAlignment(Pos.CENTER);
        // input_user_name.getColumnConstraints().add(new javafx.scene.layout.ColumnConstraints(150));

        //이름 저장해주기
        nameButton.setOnAction(event -> changeName(event));

        primarStage.setTitle("PokeMon");
        primarStage.setScene((new Scene(input_user_name,300, 200)));
        primarStage.show();

        

    }

    public void changeName(ActionEvent event){
        String newName = nameField.getText();
        user.setUserName(newName);
        // user.printName();

        Stage explanationStage = new Stage();
        GridPane explanation = new GridPane();
        explanationStage.setScene(new Scene(explanation, 500, 300));
        explanationStage.setTitle("설명 창");
        explanation(explanationStage, explanation);
        explanationStage.show();
        // Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // primarStage.close();
        Stage primaryStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        primaryStage.close();
    }

    public void explanation(Stage explationStage, GridPane explation){
        String str_ex = "님 환영합니다.";
        String str = user.getUserName();
        Label start_page = new Label(str + str_ex);
        start_page.setTextFill(Color.WHITE);
        // start_page.setFont("Arial", FontWeight.BOLD, 40 );

        //배경과 글자 설정
        start_page.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        BackgroundFill backgroundFill = new BackgroundFill(Color.BLACK, null, null);
        Background background = new Background(backgroundFill);
        explation.setBackground(background);

        explation.setPadding (new Insets (20));
        explation.setHgap(10) ;
        explation.add(start_page,0,0);
        explation.setAlignment(Pos.CENTER);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    
}