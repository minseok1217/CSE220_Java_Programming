public class Lab03Test {
    public static void main(String[] args){
        useDeck();
        useRoll36();
        // TicTacTok t = new TicTacTok();

    }

    public static void useRoll36(){
        Roll36 r = new Roll36();
        r.rollDice36();

    }
     public static void useDeck() {
        Deck2 d2 = new Deck2();
        d2.printDeck();
        d2.shuffle();
        d2.printDeck();
        
    }

}
