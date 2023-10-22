public class Card {

    
    private class A{
        private int a=10;
        private String s= "";
        public A(){}
    }
    private enum Ae{}
    private final Face f;
    private final Suit s;

    public Card(Face f, Suit s){
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
