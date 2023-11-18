import javafx.scene.image.Image;

public enum Pokemon {
	BULBASAUR("./image/bulbasaur.png"), 	// 이상해
	CHARMANDER("./image/charmander.png"), 	// 피아리
	CYNDAQUIL("./image/cyndaquil.png"), 	// 브케인 
	EEVEE("./image/eevee.png"),			// 이브이 
	JIGGLYPUFF("./image/jigglypuff.png"),	// 푸린 
	SQUIRTLE("./image/squirtle.png"),	// 꼬부기
	
	PIKACHU("./image/pikachu.png");		// 피카추 
	
	

    private Image image;
	private Pokemon(String fileName){
		this.image = new Image(fileName);
	}
	public Image getImage(){
		return image;
	}
    
}