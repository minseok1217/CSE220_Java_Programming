import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
    private ImageView[][] pokemon_grid = new ImageView[2][3];
    private Pokemon user_pokemon;
    Pokemon wild = Pokemon.PIKACHU;
    private ImageView userPokemonImageView;
    private ImageView wildPokemonImageView;
    
    // private Group pokemonGrid = new Group();

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
        nameField.setOnKeyPressed(event -> {
        if (event.getCode() == KeyCode.ENTER) {changeName(primaryStage);}
        });

        primaryStage.setTitle("PokeMon");
        primaryStage.setScene(new Scene(inputUserName, 500, 300));
        primaryStage.show();
    }

    private void changeName(Stage primaryStage) {
        primaryStage.close();


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

        Stage welcomeStage_2 = new Stage();
        welcomeStage_2.setScene(new Scene(welcomePane_2, 500, 300));
        welcomeStage_2.setTitle("WelCome Mesege");
        welcomeStage_2.show();
        welcomePane_2.setOnMouseClicked(event -> selectPokemonScreen(welcomeStage_2));
    }

    private Pokemon getDesiredPokemon(int row, int col) {
        Pokemon[][] pokemonGrid = {
                {Pokemon.BULBASAUR, Pokemon.CHARMANDER, Pokemon.CYNDAQUIL},
                {Pokemon.EEVEE, Pokemon.JIGGLYPUFF, Pokemon.SQUIRTLE}
        };
        return pokemonGrid[row][col];
    }

    private void addClickEventHandler(ImageView imageView) {
        imageView.setOnMouseClicked(event -> {
            user_pokemon = handlePokemonSelection((ImageView) event.getSource());
        });
    }

    private Pokemon handlePokemonSelection(ImageView selectedImageView) {
        for (int i = 0; i < pokemon_grid.length; i++) {
            for (int j = 0; j < pokemon_grid[i].length; j++) {
                if (pokemon_grid[i][j] == selectedImageView) {
                    Pokemon selectedPokemon = getDesiredPokemon(i, j);
                    return selectedPokemon;
                }
            }
        }
        double d = Math.random();
        int row = (int)(d * 10 % 2);
        int col = (int)(d * 10 % 3);
        return getDesiredPokemon(row, col);
    }

    private void selectPokemonScreen(Stage currentStage){
        currentStage.close();
        
        
        for (int i = 0; i < pokemon_grid.length; i++) {
            for (int j = 0; j < pokemon_grid[i].length; j++) {
                Pokemon pokemon = getDesiredPokemon(i, j);
                ImageView imageView = new ImageView(pokemon.getImage());
                imageView.setFitWidth(100); 
                imageView.setFitHeight(100);

                pokemon_grid[i][j] = imageView;
            }
        }

        GridPane seletePane = new GridPane();
        for (int i = 0; i < pokemon_grid.length; i++) {
            for (int j = 0; j < pokemon_grid[i].length; j++) {
                addClickEventHandler(pokemon_grid[i][j]);
                seletePane.add(pokemon_grid[i][j], j, i);
            }
        }
        Stage seleteStage_2 = new Stage();
        seleteStage_2.setScene(new Scene(seletePane, 300, 250));
        seleteStage_2.setTitle("WelCome Mesege");
        seleteStage_2.show();
        seletePane.setOnMouseClicked(event -> before_battle(seleteStage_2));
    }

    private void before_battle(Stage currenStage){
        currenStage.close();

        GridPane welcomePane_2 = new GridPane();
        welcomePane_2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        welcomePane_2.setPadding(new Insets(20));
        welcomePane_2.setHgap(10);

        Label welcomeLabel_2 = new Label("야생 피카츄를 만났습니다.");
        welcomeLabel_2.setTextFill(Color.WHITE);
        welcomeLabel_2.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        welcomePane_2.add(welcomeLabel_2, 0, 0);
        welcomePane_2.setAlignment(Pos.CENTER);

        Stage welcomeStage_2 = new Stage();
        welcomeStage_2.setScene(new Scene(welcomePane_2, 500, 300));
        welcomeStage_2.setTitle("WelCome Mesege");
        welcomeStage_2.show();

        welcomePane_2.setOnMouseClicked(event -> prepare_battle(welcomeStage_2));
    }

    private void prepare_battle(Stage currenStage){
        currenStage.close();

        GridPane welcomePane_2 = new GridPane();
        welcomePane_2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        welcomePane_2.setPadding(new Insets(20));
        welcomePane_2.setHgap(10);

        Label welcomeLabel_2 = new Label("당신의 포켓몬을 이용해서 \n야생 피카추를 잡아주세요.");
        welcomeLabel_2.setTextFill(Color.WHITE);
        welcomeLabel_2.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        welcomePane_2.add(welcomeLabel_2, 0, 0);
        welcomePane_2.setAlignment(Pos.CENTER);

        Stage welcomeStage_2 = new Stage();
        welcomeStage_2.setScene(new Scene(welcomePane_2, 500, 300));
        welcomeStage_2.setTitle("WelCome Mesege");
        welcomeStage_2.show();

        welcomePane_2.setOnMouseClicked(event -> {
            showCatchPokemonScreen(welcomeStage_2);
        });
    }

    private void showCatchPokemonScreen(Stage currenStage){
        // currenStage.close();
        Start_Catching sc = new Start_Catching();
        sc.run(currenStage);
    }

    public static void main(String[] args) {
        launch();
    }
}
