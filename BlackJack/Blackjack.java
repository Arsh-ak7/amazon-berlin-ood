package BlackJack;

import java.util.*;

enum Suit {
    CLUB(0),
    SPADES(1),
    DIAMONDS(2),
    HEARTS(3);

    private int value;

    private Suit(int v) {
        value = v;
    }

    public Suit getSuitfromValue(int value) {
        return Suit.values()[value];
    }
}

class Card {
    protected Suit suit;
    protected Integer faceValue;
    protected Boolean available;

    public Card(Suit suit, Integer faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
        this.available = true;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Integer getFaceValue() {
        return this.faceValue;
    }

    public Boolean getIsAvailable() {
        return this.available;
    }

    public void setCardTaken() {
        this.available = false;
    }

    public void setCardAvailable() {
        this.available = true;
    }
}

class BlackJackCard extends Card {
    public BlackJackCard(Suit suit, Integer faceValue) {
        super(suit, faceValue);
    }

    public int value() {
        if (isAce())
            return 1;
        if (faceValue >= 11 || faceValue <= 13)
            return 10;
        else
            return faceValue;
    }

    public Boolean isAce() {
        return faceValue == 1;
    }

}

class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public void setDeckOfCards(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }
}

class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        this.hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public Integer getHandScore() {
        Integer score = 0;
        for (Card card : this.hand) {
            score += card.getFaceValue();
        }
        return score;
    }
}

class BlackjackHand {
    private ArrayList<BlackJackCard> hand;

    public BlackjackHand() {
        this.hand = new ArrayList<>();
    }

    public void addCardToHand(BlackJackCard card) {
        this.hand.add(card);
    }

    public ArrayList<BlackJackCard> getHand() {
        return this.hand;
    }

    public Integer getHandScore() {
        Integer score = 0;
        for (BlackJackCard card : this.hand) {
            score += card.value();
        }
        return score;
    }

    public Boolean is21() {
        return getHandScore() == 21;
    }

    public Boolean isBusted() {
        return getHandScore() > 21;
    }
}

public class Blackjack {
    Deck deck = new Deck();

    public void initialiseDeck() {
        ArrayList<Card> deck = new ArrayList<>();

        for (int i = 0; i < 4; i += 1) {
            for (int j = 1; j <= 13; j += 1) {
                deck.add(new Card(Suit.values()[i], j));
            }
        }
    }
}
