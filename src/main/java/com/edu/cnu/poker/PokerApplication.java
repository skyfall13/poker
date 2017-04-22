package com.edu.cnu.poker;

/**
 * Created by cse on 2017-04-17.
 * CARD - rank, suit
 * DECK
 * HAND
 * EVALUATOR
 * PLAYER
 * GAME
 */
public class PokerApplication {

    public static void main(String[] args) {
        System.out.println("Hello Poker");
        Deck currentDeck = new Deck(52);
        Hand myHand = new Hand(currentDeck,PokerType.FIVE);
        Hand yourHand = new Hand(currentDeck,PokerType.FIVE);

        String myResult = new Evaluator().evaluate(myHand.getMyCardList());
        String yourResult = new Evaluator().evaluate(yourHand.getMyCardList());

        myHand.showMyCardList();
        yourHand.showMyCardList();

        System.out.println(myResult);
        System.out.println(yourResult);

    }
}
