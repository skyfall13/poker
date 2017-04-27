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
        Deck currentDeck = new Deck(1);
        Hand myHand = new Hand(currentDeck,PokerType.FIVE);
        Hand yourHand = new Hand(currentDeck,PokerType.FIVE);

        Rule myResult = new Evaluator().evaluate(myHand.getMyCardList());
        Rule yourResult = new Evaluator().evaluate(yourHand.getMyCardList());

        myHand.showMyCardList();
        yourHand.showMyCardList();

        System.out.println(myResult.getPriority());
        System.out.println(yourResult.getPriority());

    }
}
