import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
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
    private int MOVEMENT_SPEED = 600;
    private ImageView throw_ball = new ImageView(Pokemon.BALL.getImage());
    private ImageView catch_ball = new ImageView(Pokemon.BALL.getImage());
    ImageView birthday_left = new ImageView(Effect.BIRTHDAY_LEFT.getImage());
    ImageView birthday_right = new ImageView(Effect.BIRTHDAY_RIGHT.getImage());
    Label userPokemonHpLabel = new Label("체력: " + Integer.toString(user_hp));
    private Label explain_label = new Label();
    private Label explain_label_wild = new Label();
    


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
        // battle_stage.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
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
        
        ImageView backgroundImage = new ImageView(Effect.BATTLE_BACKGROUND.getImage());
        backgroundImage.setFitHeight(300);
        backgroundImage.setFitWidth(500);
        StackPane.setAlignment(backgroundImage, Pos.CENTER);

        StackPane root = new StackPane();
        // root.getChildren().addAll(backgroundImage);
        root.getChildren().addAll(backgroundImage, battle_stage, monsterball, throw_ball, catch_ball, explain_label, explain_label_wild);
        monsterball.setFitWidth(80);
        monsterball.setFitHeight(80);
        throw_ball.setFitHeight(50);
        throw_ball.setFitWidth(50);
        throw_ball.setOpacity(0);

        catch_ball.setFitHeight(50);
        catch_ball.setFitWidth(50);
        catch_ball.setOpacity(0);

        //게임의 진행상황을 알려주기 위해 만든 것
        explain_label.setOpacity(0);
        explain_label_wild.setOpacity(0);
        StackPane.setAlignment(explain_label, Pos.TOP_LEFT);
        StackPane.setAlignment(explain_label_wild, Pos.TOP_LEFT);
        StackPane.setAlignment(catch_ball, Pos.TOP_RIGHT);
        StackPane.setAlignment(throw_ball, Pos.BOTTOM_LEFT);
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

        
        Label wildPokemonHpLabel = new Label("체력: " + Integer.toString(wild_hp));

        GridPane.setRowIndex(userPokemonHpLabel, 2); 
        GridPane.setColumnIndex(userPokemonHpLabel, 0); 
        battle_stage.getChildren().add(userPokemonHpLabel);

        GridPane.setRowIndex(wildPokemonHpLabel, 0); 
        GridPane.setColumnIndex(wildPokemonHpLabel, 2); 
        battle_stage.getChildren().add(wildPokemonHpLabel);
        wildPokemonHpLabel.setTranslateY(55);
        wildPokemonHpLabel.setTranslateX(10);

        Scene battleScene = new Scene(root, 500, 300);
        Stage battleStage = new Stage();
        battleStage.setScene(battleScene);
        battleStage.setTitle("Battle");
        battleStage.show();

        skillButton_1.setOnAction(event -> {
            explain_label.setText(sk.getName()+ "의\n" + sk.getSkills()[0]);
            explain_label.setOpacity(1);
            explain_label.setTextFill(Color.WHITE);
            explain_label.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            // explain_label.setOpa
            wild_hp = sk.first(wild_hp);
            user_hp = attack(user_hp);
            
            Twinkle_wild();
            wildPokemonHpLabel.setText("체력: " + Integer.toString(wild_hp));
            if(wild_hp < 1){
                down_picacu(battleStage);
                
            }
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event2 -> {
                Twinkle_user();
                explain_label.setOpacity(0);
                explain_label_wild.setOpacity(1);
                explain_label_wild.setTextFill(Color.WHITE);
                explain_label_wild.setFont(Font.font("Arial", FontWeight.BOLD, 30));
                explain_label_wild.setText(wild_skill.getName()+ "의\n" + wild_skill.getSkills()[0]);
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                if(user_hp < 1){
                    down_user(battleStage);
                }

            });
            pause.play();
            });
        skillButton_2.setOnAction(event -> {
            explain_label.setText(sk.getName()+ "의\n" + sk.getSkills()[1]);
            explain_label.setOpacity(1);
            explain_label.setTextFill(Color.WHITE);
            explain_label.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            wild_hp = sk.second(wild_hp);
            user_hp = attack(user_hp);
            Twinkle_wild();
            wildPokemonHpLabel.setText("체력: " + Integer.toString(wild_hp));
            if(wild_hp < 1){
                down_picacu(battleStage);
            }
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event2 -> {
                Twinkle_user();
                explain_label.setOpacity(0);
                explain_label_wild.setOpacity(1);
                explain_label_wild.setTextFill(Color.WHITE);
                explain_label_wild.setFont(Font.font("Arial", FontWeight.BOLD, 30));
                explain_label_wild.setText(wild_skill.getName()+ "의\n" + wild_skill.getSkills()[1]);
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                if(user_hp < 1){
                    down_user(battleStage);
                }
                
            });
            pause.play();
            });
        skillButton_3.setOnAction(event -> {
            wild_hp = sk.third(wild_hp);
            user_hp = attack(user_hp);
            Twinkle_wild();
            explain_label.setText(sk.getName()+ "의\n" + sk.getSkills()[2]);
            explain_label.setOpacity(1);
            explain_label.setTextFill(Color.WHITE);
            explain_label.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            wildPokemonHpLabel.setText("체력: " + Integer.toString(wild_hp));
            if(wild_hp < 1){
                down_picacu(battleStage);
            }
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event2 -> {
                Twinkle_user();
                explain_label.setOpacity(0);
                explain_label_wild.setOpacity(1);
                explain_label_wild.setTextFill(Color.WHITE);
                explain_label_wild.setFont(Font.font("Arial", FontWeight.BOLD, 30));
                explain_label_wild.setText(wild_skill.getName()+ "의\n" + wild_skill.getSkills()[2]);
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                if(user_hp < 1){
                    down_user(battleStage);
                }
            });
            pause.play();
        });
        skillButton_4.setOnAction(event -> {
            wild_hp = sk.fourth(wild_hp);
            user_hp = attack(user_hp);
            Twinkle_wild();
            explain_label.setText(sk.getName()+ "의\n" + sk.getSkills()[3]);
            explain_label.setOpacity(1);
            explain_label.setTextFill(Color.WHITE);
            explain_label.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            wildPokemonHpLabel.setText("체력: " + Integer.toString(wild_hp));
            if(wild_hp < 1){
                down_picacu(battleStage);
            }
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event2 -> {
                Twinkle_user();
                explain_label.setOpacity(0);
                explain_label_wild.setOpacity(1);
                explain_label_wild.setTextFill(Color.WHITE);
                explain_label_wild.setFont(Font.font("Arial", FontWeight.BOLD, 30));
                explain_label_wild.setText(wild_skill.getName()+ "의\n" + wild_skill.getSkills()[3]);
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                if(user_hp < 1){
                    down_user(battleStage);
                }
            });
            pause.play();
        });
        monsterball.setOnMouseClicked(event ->{
            
            move(450.0, -300.0, battleStage);

            
        });
    }
    
    public void success(Stage currentStage) {
        System.out.println("111");
        currentStage.close();
    
        StackPane successPane = new StackPane();
        successPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        successPane.setPadding(new Insets(20));
        ImageView pikachuImageView = new ImageView(Pokemon.PIKACHU.getImage());
    
        
        successPane.getChildren().addAll(birthday_left, birthday_right);
        StackPane.setAlignment(birthday_right, Pos.TOP_RIGHT);
        StackPane.setAlignment(birthday_left, Pos.TOP_LEFT);

        Label successLabel = new Label("야생 피카츄를 잡았습니다!!!!!!");
        successLabel.setTextFill(Color.BLACK);
        successLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
    
        successPane.getChildren().addAll(pikachuImageView, successLabel);
        StackPane.setAlignment(pikachuImageView, Pos.CENTER);
        StackPane.setAlignment(successLabel, Pos.BOTTOM_CENTER);
    
        Stage successStage = new Stage();
        successStage.setScene(new Scene(successPane, 500, 300));
        successStage.setTitle("FINISH");
        successStage.show();
    }
    
    private void down_picacu(Stage curentStage){
        curentStage.close();

        Label picacu_down_label = new Label("피카츄가 기절해서 실패했습니다.");
        picacu_down_label.setTextFill(Color.BLACK);
        picacu_down_label.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        StackPane.setAlignment(picacu_down_label,Pos.BOTTOM_CENTER);

        StackPane root = new StackPane();
        ImageView run = new ImageView(Effect.DOWN.getImage());
        root.getChildren().addAll(run, picacu_down_label);
        StackPane.setAlignment(run, Pos.CENTER);
        Stage successStage = new Stage();
        successStage.setScene(new Scene(root, 500, 300)  );
        successStage.setTitle("FINISH");
        successStage.show();
    }

    private void down_user(Stage currentStage){
        currentStage.close();

        Label picacu_down_label = new Label(user.getUserName() + "피가 기절해서 실패했습니다.");
        picacu_down_label.setTextFill(Color.BLACK);
        picacu_down_label.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        StackPane.setAlignment(picacu_down_label,Pos.BOTTOM_CENTER);

        StackPane root = new StackPane();
        ImageView run = new ImageView(Effect.USER_DOWN.getImage());
        root.getChildren().addAll(run, picacu_down_label);
        StackPane.setAlignment(run, Pos.CENTER);
        Stage successStage = new Stage();
        successStage.setScene(new Scene(root, 500, 300)  );
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
            int dValue = (int)((Math.random() * 10)  % 4);
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
        fadeTransition_user.setOnFinished(event_ -> explain_label_wild.setOpacity(0));
    }

    private void Twinkle_wild(){
        
        FadeTransition fadeTransition_wild = new FadeTransition(Duration.seconds(1d), explossion_wild);
        fadeTransition_wild.setFromValue(1.0);
        fadeTransition_wild.setToValue(0.0);
        fadeTransition_wild.setCycleCount(1);
        fadeTransition_wild.play();
        
    }

    private void Twinkle_birthday(){
        FadeTransition fadeTransition_birthday_left = new FadeTransition(Duration.seconds(1d), birthday_left);
        fadeTransition_birthday_left.setFromValue(1.0);
        fadeTransition_birthday_left.setToValue(0.0);
        fadeTransition_birthday_left.setCycleCount(3);
        fadeTransition_birthday_left.play();

        FadeTransition fadeTransition_birthday_right = new FadeTransition(Duration.seconds(1d), birthday_right);
        fadeTransition_birthday_right.setFromValue(1.0);
        fadeTransition_birthday_right.setToValue(0.0);
        fadeTransition_birthday_right.setCycleCount(3);
        fadeTransition_birthday_right.play();
    }

    private void move(double deltaX , double deltaY, Stage currentStage) {
        throw_ball.setOpacity(1);
        TranslateTransition moveTransition = new TranslateTransition(Duration.millis(MOVEMENT_SPEED), throw_ball);
        moveTransition.setByX(deltaX);
        moveTransition.setByY(deltaY);
        moveTransition.setAutoReverse(false);
        moveTransition.setCycleCount(1);
        moveTransition.play();
        moveTransition.setOnFinished(e -> {
            throw_ball.setX(throw_ball.getX() + deltaX);
            throw_ball.setY(throw_ball.getY() + deltaY);
            throw_ball.setTranslateX(0);
            throw_ball.setTranslateY(0);
            throw_ball.setOpacity(0);
            catch_time(currentStage);
        });
    }

    private void catch_time(Stage currentStage){
        catch_ball.setOpacity(1);
        wildPokemonImageView.setOpacity(0);
        FadeTransition fadeTransition_catch = new FadeTransition(Duration.seconds(3d), catch_ball);
        fadeTransition_catch.setFromValue(1.0);
        fadeTransition_catch.setToValue(0.0);
        fadeTransition_catch.setCycleCount(1);
        fadeTransition_catch.play();
        FadeTransition fadeTransition_wild = new FadeTransition(Duration.seconds(3d), catch_ball);
        fadeTransition_wild.setFromValue(1.0);
        fadeTransition_wild.setToValue(0.0);
        fadeTransition_wild.setCycleCount(1);
        fadeTransition_wild.play();
        fadeTransition_wild.setOnFinished(e -> {
            
            wildPokemonImageView.setOpacity(1);
            double d = Math.random();
            double percent = (600.0 - wild_hp) / 600;
            if(d < percent){
                success(currentStage);
            }
            else{
                user_hp = attack(user_hp);
                Twinkle_user();
                userPokemonHpLabel.setText("체력: " + Integer.toString(user_hp));
                if(user_hp < 1){
                    down_user(currentStage);
                }
            }
        });

    }


    public void start(Stage stage){}
    public static void main(String[] args){launch(args);}
}
