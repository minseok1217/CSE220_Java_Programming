import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Catch_pokemon extends Application{
    Pokemon wild = Pokemon.PIKACHU;
    Stage currentStage = new Stage();
    private ImageView userPokemonImageView;
    private ImageView wildPokemonImageView;
    private Pokemon user_pokemon;

    public void set_user_pokemon(Pokemon user){
        user_pokemon = user;
    }

    public Catch_pokemon(Pokemon user_pokemon){
        // this.currentStage = currentStage;
        this.user_pokemon = user_pokemon;
    }

    public void run(){
        Application.launch();
    }


    public void start(Stage currentStage) throws Exception {
        currentStage.close();

        GridPane battle_stage = new GridPane();
        battle_stage.setPadding(new Insets(20));
        battle_stage.setHgap(10);

        userPokemonImageView = new ImageView(user_pokemon.getImage());
        userPokemonImageView.setFitWidth(100);
        userPokemonImageView.setFitHeight(100);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.ALWAYS);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.ALWAYS);

        battle_stage.getColumnConstraints().add(columnConstraints);
        battle_stage.getRowConstraints().add(rowConstraints);

        GridPane.setRowIndex(userPokemonImageView, 1);
        GridPane.setColumnIndex(userPokemonImageView, 0);
        GridPane.setValignment(userPokemonImageView, VPos.BOTTOM);

        battle_stage.getChildren().add(userPokemonImageView);

        wildPokemonImageView = new ImageView(wild.getImage());
        wildPokemonImageView.setFitWidth(100);
        wildPokemonImageView.setFitHeight(100);
        GridPane.setRowIndex(wildPokemonImageView, 0);
        GridPane.setColumnIndex(wildPokemonImageView, 2);
        GridPane.setValignment(wildPokemonImageView, VPos.TOP);
        battle_stage.getChildren().add(wildPokemonImageView);

        Button skillButton = new Button("skill");
        skillButton.setPrefWidth(200);
        skillButton.setPrefHeight(200);

        GridPane.setHalignment(skillButton, HPos.CENTER);
        GridPane.setValignment(skillButton, VPos.CENTER);

        battle_stage.add(skillButton, 1, 1, 1, 1);

        Scene battleScene = new Scene(battle_stage, 600, 400);
        Stage battleStage = new Stage();
        battleStage.setScene(battleScene);
        battleStage.setTitle("Battle");
        battleStage.show();

    }
    public static void main(String[] args) {
    //     launch(args);
    }
}
