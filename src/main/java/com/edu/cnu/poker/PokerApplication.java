package com.edu.cnu.poker;

import java.util.Scanner;

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
        Hand myHand = new Hand(currentDeck,PokerType.SEVEN);
        Hand yourHand = new Hand(currentDeck,PokerType.FIVE);

        Player player1 = new Player(myHand);
        Player player2 = new Player(yourHand);

        player1.getHand().showMyCardList();
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("버리고 싶은 카드를 입력해주세요 (앞에서 부터 1번카드)");
            int input = scan.nextInt();
            if(!player1.getHand().removeCard(input)) {
                break;
            }
            player1.getHand().showMyCardList();
        }
        player1.getHand().showMyCardList();
        player2.getHand().showMyCardList();

        Rule myResult = new Evaluator().evaluate(player1.getHand().getMyCardList());
        Rule yourResult = new Evaluator().evaluate(player2.getHand().getMyCardList());

        System.out.println(myResult.getPriority());
        System.out.println(yourResult.getPriority());

    }

}
