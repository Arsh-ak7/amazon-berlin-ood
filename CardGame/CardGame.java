package CardGame;

/* 
Then she gave me a coding question. I was supposed to design a card game in which there are 10 cards of red color numbered from 1 to 10, 10 green cards numbered from 1 to 10, 10 yellow cards numbered from 1 to 10. In total there are 30 cards. There are 10 players and each player draws 3 random cards from the deck. A player is said to win the game if any of the conditions hold true-
1st -The 3 drawn cards are of the same color or same number. Example - R1,R4,R2 or R1,B1,Y1
2nd - (2 Cards are of same color) and (2 cards are of same number) out of the 3 cards Example - R1,R2,Y2 or G9,G7,R9

I did it something like this-
1.Maintain an array of size 30 and use 0 to 9th index for red cards, 10 to 19 for yellow, 20 to 29 for green cards.
2.Assign every player a number(card or index of array) from 1 to 30 using the rand()%30 function.
3.After assigning the number(card or index of array) check for the given conditions for all players and output the player number if he/she wins.
4.Repeat the step 2 and 3 until we find the winner.
 */

public class CardGame {
    
}
