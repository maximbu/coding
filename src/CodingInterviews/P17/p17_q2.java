package CodingInterviews.P17;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by max on 1/3/2017.
 */
public class p17_q2 {

    public static class Card {
        CardValue val;
        CardSuit suit;

        public Card(CardValue val,CardSuit s){
            this.val = val;
            this.suit = s;
        }

        public CardValue getVal() {
            return val;
        }

        public void setVal(CardValue val) {
            this.val = val;
        }

        public CardSuit getSuit() {
            return suit;
        }

        public void setSuit(CardSuit suit) {
            this.suit = suit;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "val=" + val +
                    ", suit=" + suit +
                    '}';
        }
    }

    public static class Desk {
        Card[] cards;

        public Desk(){
            cards = new Card[54];
            init();
        }

        private void init() {
            int i =0;
            for (CardSuit s : CardSuit.values()) {
                for (CardValue v : CardValue.values()) {
                    if(v != CardValue.JOKER) {
                        cards[i++] = new Card(v, s);
                    }
                }
            }
            cards[i++] = new Card(CardValue.JOKER,CardSuit.HEARTS);
            cards[i] = new Card(CardValue.JOKER,CardSuit.SPADES);
        }

        public void shuffle(){
            init();
            Random r = new Random();
            int ind = 53;
            while (ind > 0){
                int tmp = r.nextInt(ind+1);
                Card tmpCard = cards[ind];
                cards[ind] = cards[tmp];
                cards[tmp] = tmpCard;
                ind--;
            }

        }

        @Override
        public String toString() {
            return "Desk{" +
                    "cards=" + Arrays.toString(cards) +
                    '}';
        }
    }


    public enum CardSuit{
        HEARTS,
        SPADES,
        DIAMONDS,
        CLUBS
    }

    public enum CardValue{
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE,
        JOKER
    }

    public static void main(String[] st){
        Desk d = new Desk();
        System.out.println(d);
        d.shuffle();
        System.out.println(d);
    }
}
