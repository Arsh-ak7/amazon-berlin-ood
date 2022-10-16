package CardGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* 
I was supposed to design a card game in which there are 10 cards of red color numbered from 1 to 10, 
10 green cards numbered from 1 to 10, 10 yellow cards numbered from 1 to 10. 
In total there are 30 cards. There are 10 players and each player draws 3 random cards from the deck. 
A player is said to win the game if any of the conditions hold true-
1st -The 3 drawn cards are of the same color or same number. Example - R1,R4,R2 or R1,B1,Y1
2nd - (2 Cards are of same color) and (2 cards are of same number) out of the 3 cards Example - R1,R2,Y2 or G9,G7,R9
*/


/*
 * Assumption:  0 - 9 Red, 10 - 19 Green, 20 - 29 Yellow 
 */

class Card {
    Integer id;
    String color;
    Boolean isTaken;

    public Card(Integer id, String color){
        this.id = id;
        this.color = color;
        this.isTaken = false;
    }

    public void setCardTaken() {
        this.isTaken = true;
    }

    public Boolean checkIfTaken(){
        return this.isTaken;
    }
}

class Player {
    private Integer id;
    private List<Card> cardsDrawn;

    public Player(Integer id){
        this.id = id;
        this.cardsDrawn = new ArrayList<>();
    }

    public List<Card> getCardsDrawn(){
        return cardsDrawn;
    }

    public Integer getPlayerId() {
        return id;
    }

    public void setCardsDrawn(List<Card> cards){
        this.cardsDrawn = cards;
    }
}

public class CardGame {
    private List<Card> totalCards;
    private List<Player> totalPlayers;
    
    public CardGame() {
        this.totalCards = new ArrayList<>();
        this.totalPlayers = new ArrayList<>();
    }

    public void initialiseCards(Integer count, Integer numberOfEachType, List<String> colors){
        Integer currCount = 1, currIndex = 0;
        String currColor = colors.get(0);
        for(Integer i=1;i<=count;++i){
            if(currCount > numberOfEachType){
                currColor = colors.get(currIndex + 1);
                currIndex += 1;
                currCount  = 1;
            }
            totalCards.add(new Card(currCount, currColor));
            currCount += 1;
        }
    }

    public void initialisePlayers(Integer playerCount){
        for(Integer i=1;i<=playerCount; i++){
            totalPlayers.add(new Player(i));
        }
    }

    public Card getRandomCard(){
        Random random = new Random();
        Integer getRandomIndex = random.nextInt(30);
        return totalCards.get(getRandomIndex);
    }

    public void drawCardsForEachPlayer() {
        for(Player player: totalPlayers){
            int currCardCount = 0;
            List<Card> cardListForAPlayer = new ArrayList<>();
            while(currCardCount < 3){
                Card card = getRandomCard();
                if(!card.isTaken){
                    cardListForAPlayer.add(card);
                    currCardCount += 1;
                    card.setCardTaken();
                }
            }
            player.setCardsDrawn(cardListForAPlayer);
        }
    }

    public Boolean isCurrPlayerWinner(List<Card> playerCards){
        Card firstCard = playerCards.get(0);
        Card secondCard = playerCards.get(1);
        Card thirdCard = playerCards.get(2);

        // Condition 1: Color based
        if((firstCard.color == secondCard.color) || (firstCard.color == thirdCard.color) || (secondCard.color == thirdCard.color))
            return true;

        // Condition 2: Number based
        if((firstCard.id == secondCard.id) || (firstCard.id == thirdCard.id) || (secondCard.id == thirdCard.id))
            return true;        

        return false;
    }

    public Integer checkForAWinner(){
        for(Player player : totalPlayers){
            List<Card> playerCards = player.getCardsDrawn();
            if(isCurrPlayerWinner(playerCards))
                return player.getPlayerId();
        }

        return null;
    }

    public static void main(String[] args){
        CardGame newGame = new CardGame();
        List<String> colors = Arrays.asList("red", "blue", "yellow");
        newGame.initialiseCards(30, 10, colors);
        newGame.initialisePlayers(10);
        newGame.drawCardsForEachPlayer();

        System.out.println(newGame.checkForAWinner());
    }
}
