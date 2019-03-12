import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DeckArrayList {

        // Start with your fields
        ArrayList<Card> cards;
        int size;
        int topCard;

        // Define your constructor
        public DeckArrayList(){
            String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
            String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

            size = suits.length * values.length;
            cards = new ArrayList<>(size);
//            int count = suits.length * values.length;
            for (int i = 0; i < suits.length; i++) {
                for (int j = 0; j < values.length; j++) {

                    cards.add(new Card(suits[i], values[j])) ;
//                    count++;
                }
            }
            topCard = 0;
        }


        // Create all the methods from the instructions.

        public void display(int n){
            int printingLimit = n;
            // We want to print n cards, but what if n is bigger than the size of the deck?
            // In that case, I decided to just print what's left in the deck.

            // This is an in-line if statement, which works if there is only 1 thing you want to do
            // if the condition is true.
            if (n > this.size) printingLimit = this.size;


            for (int i = 0; i < printingLimit; i++){
                System.out.println(cards.get(i));
            }
        }

        public void shuffle(){
            int randomIndex;
            Card temp; // Used in swapping
            for (int i = 0; i < size; i++){
                // Get a random index to send the current card to
                randomIndex = ThreadLocalRandom.current().nextInt(0, size);

                // Swap the card at position i, with the one at position randomIndex
                temp = cards.get(i);
                cards.set(i, cards.get(randomIndex));
                cards.set(randomIndex, temp);
            }
        }

        public Card[] deal(int n_cards){

            int nCards = n_cards;

            if (n_cards > this.size) nCards = this.size;

            // creating array of dealt cards
            Card[] dealtCards = new Card[nCards];
            for(int index = 0; index < nCards; index ++) {
                dealtCards[index] = cards.get(this.topCard);
                cards.remove(topCard);
                this.topCard++;
//            System.out.println(dealtCards[index]);
            }
            this.size -= topCard;

//            // creating array of remaining cards
//            Card[] remainingCards = new Card[size];
//            for(int index = 0; index < nCards; index ++) {
//                dealtCards[index] = cards.get(this.topCard);
//                this.topCard++;
////            System.out.println(dealtCards[index]);
//            }
            return dealtCards;
        }


        // You should comment out each few lines in main as you make progress, this will help
        // you test that your work is correct.

        public static void main(String[] args) {

            DeckArrayList testDeck = new DeckArrayList();
            // By default, your deck should create all 52 cards in the following order:
            // You should start from Ace, 2, 3, 4, 5 ... All the way to King
            // This should happen for Hearts, Spades, Diamonds, and clubs

            // This should print 52, as there are 52 cards in a given deck
            System.out.println(testDeck.size);

            // This should print the first 5 cards of the deck, based on the instructions above,
            // This should print Ace of hearts, 2 of hearts, 3 of hearts, 4 of hearts, then 5 of hearts.
            testDeck.display(5);

            // This method should swap the location of cards randomly.
            // We've used random behavior before in our code, for this time around, I'll refer you to
            // a great Stack overflow answer for a few ways of doing that in Java
            // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java

            testDeck.shuffle();

            //This time, displaying the first few cards will be random
            testDeck.display(5);

            //testing how the deal method works
            testDeck.deal(9);
//            System.out.println(testDeck.size);
            

        }

    }
