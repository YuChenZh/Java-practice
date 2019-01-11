/**
 * Created by yujingchen on 12/2/17.
 */

/*

class CardSuit {
   public static final int SPADE  = 0;
   public static final int DIAMOND = 1;
   public static final int CLUB    = 2;
   public static final int HEART  = 3;
   public final static int JOKER = 4;

//   public static final int ACE  = 1;
//   public static final int TWO  = 2;
//   public static final int THREE  = 3;
//   public static final int FOUR  = 4;
//   public static final int FIVE  = 5;
//   public static final int SIX  = 6;
//   public static final int SEVEN  = 7;
//   public static final int EIGHT  = 8;
//   public static final int NINE  = 9;
//   public static final int TEN  = 10;
//   public static final int JACK  = 11;
//   public static final int QUEEN  = 12;
//   public static final int KING  = 13;

}
class Card {
   int suit;   // CardSuit.SPADE, CardSuit.DIAMOND, CardSuit.CLUB, CardSuit.HEART
//   int value;
}


Type-safety issues:
1. Since CardSuit is int, you can assign any int value (e.g., 8, 10, 66...) into the int variable suit.
2. Must prefix the constants by the class name CardSuit to avoid collisions with other enum types(such as value);
3. New constants will break the existing codes.
4. Printed value of 0, 1, 2 and 3 are not very meaningful.
 */


// Implemented with Java Enums

import java.util.*;


// A card
class Card {
    enum Suit { SPADE, DIAMOND, CLUB, HEART}
    enum Value { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

    private Suit suit;
    private Value value;
    // constructor
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    Value getValue() { return value; }
    Suit getSuit() { return suit; }
    public String toString() { return "This card is " + value + " of " + suit; }

}

// A deck of card
class Deck {
    private ArrayList<Card> cards;

    // constructor
    Deck() {
        cards = new ArrayList<Card>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }
    // remove one card
    public Card removeRandomCard()
    {
        int i = (int)(Math.random() * getTotalCards());
        return cards.remove( i );
    }

    // get size of cards
    public int getTotalCards(){
        return cards.size();
    }

    // print all cards
    public void print() {
        for (Card card : cards) System.out.println(card);
    }
    // shuffle the List
    public void shuffle() {
        Collections.shuffle(cards);
    }
}

public class CardTest {

    public static void main(String[] args) {
        Deck cards = new Deck();

        cards.shuffle();
        cards.print();
        System.out.println("removed: " + cards.removeRandomCard());
        System.out.println("removed: " + cards.removeRandomCard());
        System.out.println("Size: " + cards.getTotalCards());

    }
}
