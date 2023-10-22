package java_lab3;

public class Card {
    // private final String face; 
	// private final String suit; 
    private class A{
        private int a=10;
        private String s= "";
        public A(){}
    }
    // public Card(String face, String suit) {
	// 	this.face = face;
	// 	this.suit = suit;
	// }

    private enum Ae{}
    private final String f;
    private final String s;

    public Card(String f, String s){
        this.f = f;
        this.s = s;

    }
    public String toString(){
        return f + " of " + s;
    }


}

enum Suit{
    DIAMONDS, CLUBS, HEARTS, SPADES
}

enum Face{
    DUECE, THREEL, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
}
