import javafx.scene.image.Image;

public enum Effect {
    EXPLOSION("./image/explosion.png");
    // EXPLOSION_2("./image/explosion.png");

    private Image image;
    private Effect(String filename){
        this.image = new Image(filename);
    }
    public Image getImage(){
        return image;
    }
}
