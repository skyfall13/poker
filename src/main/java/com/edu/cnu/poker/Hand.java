package com.edu.cnu.poker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cse on 2017-04-17.
 */
public class Hand {

    private Deck deck;
    private PokerType pokerType;
    private List<Card> cardList;

    public Hand(Deck deck, PokerType pokerType) {
        this.deck = deck;
        this.pokerType = pokerType;
        cardList = new ArrayList<Card>();
        for (int i = 0; i < pokerType.getNumberOfCard(); i++) {
            cardList.add(deck.drawCard());
        }
    }

    public int getTotalCard() {
        return cardList.size();
    }

    public List<Card> getMyCardList(){
        return this.cardList;
    }

    public void showMyCardList(){
        Iterator<Card> tempCardList = cardList.iterator();
        while (tempCardList.hasNext()){
            Card tempCard = tempCardList.next();
            System.out.print("[모양 : " + tempCard.getSuit() +" 숫자 : " + tempCard.getRank() + ']');
        }
        System.out.println();
    }
}
