import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Start_Catching extends Application{
    private User user = new User();
    private Pokemon user_pokemon;
    Pokemon wild = Pokemon.PIKACHU;
    private ImageView userPokemonImageView;
    private ImageView wildPokemonImageView;
    private int user_hp = 600;
    private int wild_hp = 600;
    private Skill sk;
    private String[] Skill_name;
    private Skill wild_skill = new Pikachu_skill();
    private ImageView explossion_wild = new ImageView(Effect.EXPLOSION.getImage());
    private ImageView explossion_user = new ImageView(Effect.EXPLOSION.getImage());
    


    public void setting(User User, Pokemon user_Pokemon){
        this.user = User;
        this.user_pokemon = user_Pokemon;

        //이미지를 이미지뷰로 바꾸는 것이 불가능해서 행하는 것.
        ImageView userPokemon_ImageView = new ImageView(user_pokemon.getImage());
        ImageView wildPokemon_ImageView = new ImageView(wild.getImage());
        userPokemonImageView = userPokemon_ImageView;
        wildPokemonImageView = wildPokemon_ImageView;
    }
    public void run(Stage currentStage){
        currentStage.close();

        //pokemon에 해당하는 skill 찾아오기
        sk = find(user_pokemon);
        Skill_name = sk.getSkills();

        // 본격적으로 시작한다.        
        GridPane battle_stage = new GridPane();
        battle_stage.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
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

        ImageView monsterball = new ImageView(Pokemon.BALL.getImage());
        StackPane root = new StackPane();
        root.getChildren().addAll(battle_stage, monsterball);
        monsterball.setFitWidth(80);
        monsterball.setFitHeight(80);
        StackPane.setAlignment(monsterball, Pos.BOTTOM_RIGHT);

        explossion_wild.setFitWidth(100);
        explossion_wild.setFitHeight(100);
        explossion_wild.setOpacity(0);
        explossion_wild.setTranslateX(220);
        explossion_wild.setTranslateY(-110);
        root.getChildren().add(explossion_wild);

        explossion_user.setFitWidth(100);
        explossion_user.setFitHeight(100);
        explossion_user.setOpacity(0);
        explossion_user.setTranslateX(-205);
        explossion_user.setTranslateY(105);
        root.getChildren().add(explossion_user);

        Button skillButton_1 = new Button(Skill_name[0]);
        skillButton_1.setPrefWidth(110);
        skillButton_1.setPrefHeight(90);
        Button skillButton_2 = new Button(Skill_name[1]);
        skillButton_2.setPrefWidth(110);
        skillButton_2.setPrefHeight(90);
        Button skillButton_3 = new Button(Skill_name[2]);
        skillButton_3.setPrefWidth(110);
        skillButton_3.setPrefHeight(90);
        Button skillButton_4 = new Button(Skill_name[3]);
        skillButton_4.setPrefWidth(110);
        skillButton_4.setPrefHeight(90);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10); 
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.add(skillButton_1, 0, 0);
        grid.add(skillButton_2, 1, 0); 
        grid.add(skillButton_3, 0, 1); 
        grid.add(skillButton_4, 1, 1); 
        skillButton_1.setStyle("-fx-background-color: #000000; -fx-text-fill: #FFFFFF;");
        skillButton_2.setStyle("-fx-background-color: #000000; -fx-text-fill: #FFFFFF;");
        skillButton_3.setStyle("-fx-background-color: #000000; -fx-text-fill: #FFFFFF;");
        skillButton_4.setStyle("-fx-background-color: #000000; -fx-text-fill: #FFFFFF;");
        battle_stage.add(grid, 1, 1);

        Label userPokemonHpLabel = new Label("체력: " + Integer.toString(user_hp));
        Label wildPokemonHpLabel = new Label("체력: " + Integer.toString(wild_hp));
        // Label skill_explain = new Label("공격격");


        GridPane.setRowIndex(userPokemonHpLabel, 2); 
        GridPane.setColumnIndex(userPokemonHpLabel, 0); 
        battle_stage.getChildren().add(userPokemonHpLabel);

        GridPane.setRowIndex(wildPokemonHpLabel, 0); 
        GridPane.setColumnIndex(wildPokemonHpLabel, 2); 
        battle_stage.getChildren().add(wildPokemonHpLabel);
        wildPokemonHpLabel.setTranslateY(55);
        wildPokemonHpLabel.setTranslateX(10);

        // skill_explain.setOpacity(1);
        // GridPane.setRowIndex(skill_explain, 0);
        // GridPane.setColumnIndex(skill_explain, 0);
        // battle_stage.getChildren().add(skill_explain);


        Scene battleScene = new Scene(root, 600, 400);
        Stage battleStage = new Stage();
        battleStage.setScene(battleScene);
        battleStage.setTitle("Battle");
        battleStage.show();

        
        skillButton_1.setOnAction(event -> {
            wild_hp = sk.first(wild_hp);
            user_hp = attack(user_hp);
            Twinkle_wild();
            wildPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event2 -> {
                Twinkle_user();
                
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
            });
            pause.play();
            });
        skillButton_2.setOnAction(event -> {
            wild_hp = sk.second(wild_hp);
            user_hp = attack(user_hp);
            Twinkle_wild();
            wildPokemonHpLabel.setText("체력: " + Integer.toString(wild_hp));
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event2 -> {
                Twinkle_user();
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                
            });
            pause.play();
            });
        skillButton_3.setOnAction(event -> {
            wild_hp = sk.third(wild_hp);
            user_hp = attack(user_hp);
            Twinkle_wild();
            wildPokemonHpLabel.setText("체력: " + Integer.toString(wild_hp));
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event2 -> {
                Twinkle_user();
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                
            });
            pause.play();
        });
        skillButton_4.setOnAction(event -> {
            wild_hp = sk.fourth(wild_hp);
            user_hp = attack(user_hp);
            Twinkle_wild();
            wildPokemonHpLabel.setText("체력: " + Integer.toString(wild_hp));
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event2 -> {
                Twinkle_user();
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                
            });
            pause.play();
        });
        monsterball.setOnMouseClicked(event ->{
            double d = Math.random();
            double percent = (600.0 - wild_hp) / 600;
            System.out.println(wild_hp);
            System.out.println(String.format("%f %f", d, percent));
            if(d < percent){
                success(battleStage);
            }
        });
    }
    
    public void success(Stage currentStage) {
        System.out.println("111");
        currentStage.close();
    
        StackPane successPane = new StackPane();
        successPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        successPane.setPadding(new Insets(20));
        ImageView pikachuImageView = new ImageView(Pokemon.PIKACHU.getImage());
    
        Label successLabel = new Label("야생 피카츄를 잡았습니다!!!!!!");
        successLabel.setTextFill(Color.BLACK);
        successLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
    
        successPane.getChildren().addAll(pikachuImageView, successLabel);
        StackPane.setAlignment(pikachuImageView, Pos.CENTER);
        StackPane.setAlignment(successLabel, Pos.BOTTOM_CENTER);
    
        // Scene successScene = new Scene(successPane, 500, 300);
        // successScene.setFill(Color.WHITE);
    
        Stage successStage = new Stage();
        successStage.setScene(new Scene(successPane, 500, 300)  );
        successStage.setTitle("FINISH");
        successStage.show();
    }
    

    public Skill find(Pokemon pk){
        if(pk == Pokemon.BULBASAUR){
            Skill bulbasaur = new Bulbasaur_skill();
            return bulbasaur;
        }
        else if(pk == Pokemon.CHARMANDER){
            Skill charm = new Charmander_skill();
            return charm;
        }
        else if(pk == Pokemon.CYNDAQUIL){
            Skill cyndaquil = new Cyndaquil_skill();
            return cyndaquil;
        }
        else if(pk == Pokemon.EEVEE){
            Skill eevee = new Eevee_skill();
            return eevee;
        }
        else if(pk == Pokemon.JIGGLYPUFF){
            Skill jigg = new Jigglypuff_skill();
            return jigg;
        }
        else{
            Skill sq = new Squirtle_skill();
            return sq;
        }
    }

    public int attack(int hp){
            int dValue = (int)((Math.random() * 10)  / 4);
            if(dValue == 0){
                return wild_skill.first(hp);
            }
            else if(dValue == 1){
                return wild_skill.second(hp);
            }
            else if(dValue == 2){
                return wild_skill.third(hp);
            }
            else{
                return wild_skill.fourth(hp);
            }
            // return hp;
    }

    private void Delay_time(int s){
        try {
                Thread.sleep(s);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    private void Twinkle_user(){
        // FadeTransition fadeTransition_user = new FadeTransition(Duration.seconds(1d), explossion_user);
        // fadeTransition_user.setFromValue(1.0);
        // fadeTransition_user.setToValue(0.0);
        // fadeTransition_user.setCycleCount(1);
        // fadeTransition_user.play();
        explossion_user.setOpacity(1); 
        FadeTransition fadeTransition_user = new FadeTransition(Duration.seconds(1d), explossion_user);
        fadeTransition_user.setFromValue(1.0);
        fadeTransition_user.setToValue(0.0);
        fadeTransition_user.setCycleCount(1);
        fadeTransition_user.play();
    }

    private void Twinkle_wild(){
        
        FadeTransition fadeTransition_wild = new FadeTransition(Duration.seconds(1d), explossion_wild);
        fadeTransition_wild.setFromValue(1.0);
        fadeTransition_wild.setToValue(0.0);
        fadeTransition_wild.setCycleCount(1);
        fadeTransition_wild.play();
    }

    public void start(Stage stage){}
    public static void main(String[] args){launch(args);}
}
