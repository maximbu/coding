package ProjectAuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by max on 3/18/2017.
 */
public class p54 {
/*
In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

High Card: Highest value card.
One Pair: Two cards of the same value.
Two Pairs: Two different pairs.
Three of a Kind: Three cards of the same value.
Straight: All cards are consecutive values.
Flush: All cards of the same suit.
Full House: Three of a kind and a pair.
Four of a Kind: Four cards of the same value.
Straight Flush: All cards are consecutive values of same suit.
Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest value wins; for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, both players have a pair of queens, then highest cards in each hand are compared (see example 4 below); if the highest cards tie then the next highest cards are compared, and so on.

Consider the following five hands dealt to two players:

Hand	 	Player 1	 	Player 2	 	Winner
1	 	5H 5C 6S 7S KD
Pair of Fives
 	2C 3S 8S 8D TD
Pair of Eights
 	Player 2
2	 	5D 8C 9S JS AC
Highest card Ace
 	2C 5C 7D 8S QH
Highest card Queen
 	Player 1
3	 	2D 9C AS AH AC
Three Aces
 	3D 6D 7D TD QD
Flush with Diamonds
 	Player 2
4	 	4D 6S 9H QH QC
Pair of Queens
Highest card Nine
 	3D 6D 7H QD QS
Pair of Queens
Highest card Seven
 	Player 1
5	 	2H 2D 4C 4D 4S
Full House
With Three Fours
 	3C 3D 3S 9S 9D
Full House
with Three Threes
 	Player 1

The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.

How many hands does Player 1 win?
 */

    public static void main(String[] st) {
        p54 q = new p54();
        List<PlayerHand> p1Hands = new ArrayList<>();
        List<PlayerHand> p2Hands = new ArrayList<>();
        try {
            List<String> strings = Files.readAllLines(Paths.get("C:\\Users\\max\\IdeaProjects\\CodingInterviews\\out\\production\\CodingInterviews\\ProjectAuler\\p054_poker.txt"));
            for (String s : strings) {
                String[] cards = s.split(" ");
                p1Hands.add(new PlayerHand(Arrays.copyOfRange(cards, 0, 5)));
                p2Hands.add(new PlayerHand(Arrays.copyOfRange(cards, 5, 10)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(q.questionNaive(p1Hands, p2Hands));
    }

    private int questionNaive(List<PlayerHand> p1Hands, List<PlayerHand> p2Hands) {
        return (int) IntStream.range(0, p1Hands.size()).filter(i -> p1Hands.get(i).isBetter(p2Hands.get(i))).count();
    }

    private static class PlayerHand {
        public enum HandRank {
            HIGH_CARD,
            ONE_PAIR,
            TWO_PAIRS,
            THREE_OF_A_KIND,
            STRAIGHT,
            FLUSH,
            FULL_HOUSE,
            FOUR_OF_A_KIND,
            STRAIGHT_FLUSH,
            ROYAL_FLUSH
        }

        private List<Card> cards;
        private HandRank handRank;
        private Card rankHighest;
        private Card rankSecond;

        @Override
        public String toString() {
            return "cards=" + cards +
                    ", Rank=" + handRank +
                    ", Highest=" + rankHighest.getValue() +
                    ", Second=" + rankSecond.getValue();
        }

        public PlayerHand(String[] c) {
            cards = new ArrayList<>();
            for (String s : c) {
                cards.add(new Card(s));
            }
            cards.sort(Card::compareTo);
            evaluateHand();
        }

        private void evaluateHand() {
            int[] cnt = new int[5];
            int maxCnt = 1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (cards.get(i).getValue() == cards.get(j).getValue()) {
                        cnt[i]++;
                        maxCnt = Math.max(maxCnt, cnt[i]);
                    }
                }
            }
            boolean isFlush = isFlush();
            boolean isStraight = (cards.get(4).getValue().ordinal() - cards.get(0).getValue().ordinal() == 4) && maxCnt == 1;
            if (isFlush && isStraight) {
                handleStraightFlash();
                return;
            }
            if (isStraight) {
                handRank = HandRank.STRAIGHT;
                setHighest();
                return;
            }
            if (isFlush) {
                handRank = HandRank.FLUSH;
                setHighest();
                return;
            }

            switch (maxCnt) {
                case 4:
                    handleFourOfAKind(cnt);
                    break;
                case 3:
                    handleThreeOfAKind(cnt);
                    break;
                case 2:
                    handleTwoOfAKind(cnt);
                    break;
                case 1:
                    handRank = HandRank.HIGH_CARD;
                    setHighest();
                    break;
            }


        }

        private void handleTwoOfAKind(int[] cnt) {
            int twos = 0;
            for (int i = 0; i < 5; i++) {
                if (cnt[i] == 2) twos++;
            }
            if (twos == 2) {
                handRank = HandRank.ONE_PAIR;
            }
            if (twos == 4) {
                handRank = HandRank.TWO_PAIRS;
            }
            boolean foundRankSecond = false;
            for (int i = 0; i < 5; i++) {
                if (twos == 4 && handRank == HandRank.TWO_PAIRS && !foundRankSecond) {
                    rankSecond = cards.get(i);
                    foundRankSecond = true;
                }
                if (cnt[i] == 2) {
                    rankHighest = cards.get(i);
                }

                if (handRank == HandRank.ONE_PAIR && cnt[i] == 1) {
                    rankSecond = cards.get(i);
                }
            }
        }

        private void handleThreeOfAKind(int[] cnt) {
            handRank = HandRank.THREE_OF_A_KIND;
            for (int i = 0; i < 5; i++) {
                if (cnt[i] == 3) {
                    rankHighest = cards.get(i);
                }
                if (cnt[i] == 2) {
                    handRank = HandRank.FULL_HOUSE;
                    rankSecond = cards.get(i);
                }
                if (cnt[i] == 1) {
                    rankSecond = cards.get(i);
                }
            }
        }

        private void handleFourOfAKind(int[] cnt) {
            handRank = HandRank.FOUR_OF_A_KIND;
            for (int i = 0; i < 5; i++) {
                if (cnt[i] == 4) {
                    rankHighest = cards.get(i);
                }
                if (cnt[i] == 1) {
                    rankSecond = cards.get(i);
                }
            }
        }

        private void handleStraightFlash() {
            handRank = cards.get(4).getValue() == Card.CardValue.ACE ? HandRank.ROYAL_FLUSH : HandRank.STRAIGHT_FLUSH;
            setHighest();
        }

        private void setHighest() {
            rankHighest = cards.get(4);
            rankSecond = cards.get(3);
        }

        private boolean isFlush() {
            Card.CardSuit suit = cards.get(0).getSuit();
            for (int i = 1; i < 5; i++) {
                if (suit != cards.get(i).getSuit()) return false;
            }
            return true;
        }

        public boolean isBetter(PlayerHand otherHand) {
            if (handRank.ordinal() > otherHand.handRank.ordinal()) return true;
            if (handRank.ordinal() < otherHand.handRank.ordinal()) return false;
            int highest = rankHighest.compareTo(otherHand.rankHighest);
            if (highest > 0) return true;
            if (highest < 0) return false;
            int secHighest = rankSecond.compareTo(otherHand.rankSecond);
            if (secHighest > 0) return true;
            if (secHighest < 0) return false;
            for (int i = 4; i >= 0; i--) {
                int cmp = cards.get(i).compareTo(otherHand.cards.get(i));
                if (cmp > 0) return true;
                if (cmp < 0) return false;
            }
            return false;
        }
    }

    private static class Card implements Comparable<Card> {
        public enum CardSuit {
            HEARTS,
            SPADES,
            DIAMONDS,
            CLUBS
        }

        public enum CardValue {
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
            ACE
        }

        public CardSuit getSuit() {
            return suit;
        }

        public CardValue getValue() {
            return value;
        }

        public int compareTo(Card otherCard) {
            return value.ordinal() - otherCard.value.ordinal();
        }

        private CardSuit suit;
        private CardValue value;

        public Card(String card) {
            switch (card.charAt(0)) {
                case '2':
                    value = CardValue.TWO;
                    break;
                case '3':
                    value = CardValue.THREE;
                    break;
                case '4':
                    value = CardValue.FOUR;
                    break;
                case '5':
                    value = CardValue.FIVE;
                    break;
                case '6':
                    value = CardValue.SIX;
                    break;
                case '7':
                    value = CardValue.SEVEN;
                    break;
                case '8':
                    value = CardValue.EIGHT;
                    break;
                case '9':
                    value = CardValue.NINE;
                    break;
                case 'T':
                    value = CardValue.TEN;
                    break;
                case 'J':
                    value = CardValue.JACK;
                    break;
                case 'Q':
                    value = CardValue.QUEEN;
                    break;
                case 'K':
                    value = CardValue.KING;
                    break;
                case 'A':
                    value = CardValue.ACE;
                    break;
                default:
                    throw new RuntimeException("Unknown value:" + card.charAt(0));
            }

            switch (card.charAt(1)) {
                case 'D':
                    suit = CardSuit.DIAMONDS;
                    break;
                case 'S':
                    suit = CardSuit.SPADES;
                    break;
                case 'H':
                    suit = CardSuit.HEARTS;
                    break;
                case 'C':
                    suit = CardSuit.CLUBS;
                    break;
                default:
                    throw new RuntimeException("Unknown suit:" + card.charAt(1));
            }
        }

        @Override
        public String toString() {
            return suit + "," + value;
        }
    }
}
