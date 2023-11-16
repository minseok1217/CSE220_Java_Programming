import javafx.scene.image.Image;

public enum Explanation_image {
    WELCOME("./image.pokemon_choice.png");
    
    private Image image;
    private Explanation_image(String fileName){
        this.image = new Image(fileName);
    }

    public void set_image(String fileName){
        this.image = new Image(fileName);
    }

    public Image getImage(){
        return image;
    }

}
