import javafx.scene.image.Image;

public enum Effect {
    EXPLOSION("./image/explosion.png"),
    BEFROEWILD("./image/before_wild.png"),
    DOWN("./image/down.png"),
    POKE("./image/pokemon.png"),
    BIRTHDAY_LEFT("./image/birthday_left.png"),
    BIRTHDAY_RIGHT("./image/birthday_right.png"),
    USER_DOWN("./image/user_down.png"),
    BATTLE_BACKGROUND("./image/battle_background.png");

    private Image image;
    private Effect(String filename){
        this.image = new Image(filename);
    }
    public Image getImage(){
        return image;
    }
}
