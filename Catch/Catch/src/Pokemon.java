import javafx.scene.image.Image;

public enum Pokemon {
	BULBASAUR("./image/bulbasaur.png"), 	
	CHARMANDER("./image/charmander.png"), 	
	CYNDAQUIL("./image/cyndaquil.png"), 	 
	EEVEE("./image/eevee.png"),			 
	JIGGLYPUFF("./image/jigglypuff.png"),	
	SQUIRTLE("./image/squirtle.png"),	
	PIKACHU("./image/pikachu.png"),
	BALL("./image/pokeball.png");
	
    private Image image;
	private Pokemon(String fileName){
		this.image = new Image(fileName);
	}

	public Image getImage(){
		return image;
	}    
}