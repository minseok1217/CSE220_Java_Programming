import java.util.Random;

public class Deck2 {
    private static final Random randomNumbers = new Random(); // random number generator
	private static final int NUMBER_OF_CARDS = 52; // constant number of cards

	private Card[] deck; // array of Card objects
	private int currentCard = 0; // the index of next Card to be dealt

    public Deck2(){
        deck = new Card[NUMBER_OF_CARDS];
        int i = 0;
        for (Suit s: Suit.values()){
            for(Face f : Face.values()){
                deck[i++] = new Card(f,s);

            }
        }
        // for(i=0 ; i<Suit.values().length; i++){
        //     for(int f = 0; Face.values().length; f++){
        //         deck[i++] = new Card([].[]);
        //     }
        // }

    }

    public void shuffle(){
        currentCard = 0; // reinitialize currentCard

		// for each card, pick another random card and swap them
		for (int first = 0; first < deck.length; first++) {
			
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			Card2 temp = deck[first];
            //Card2 temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;

		}
    }

    public void printDeck(){
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
			if (i % 4 == 0)
				System.out.println();
			System.out.printf("%-20s", dealCard());
		}
		System.out.println();
    }

    public Card dealCard(){
        if (currentCard < deck.length)
			return deck[currentCard++]; // return current Card in array
		else
			return null; // return null to indicate that all cards were dealt

    }

}
