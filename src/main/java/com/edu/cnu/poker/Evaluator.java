package com.edu.cnu.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public String evaluate(List<Card> cardList) {

        Map<Suit, Integer> tempMap1 = new HashMap<Suit, Integer>();
        Map<Integer, Integer> tempMap2 = new HashMap<Integer, Integer>();
        for (Card card : cardList) {
            //Key가 있는지 확인
            if (tempMap1.containsKey(card.getSuit())) {
                Integer count = tempMap1.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap1.put(card.getSuit(), count);
            } else {
                tempMap1.put(card.getSuit(), new Integer(1));
            }
        }
        for (Card card : cardList) {
            //Key가 있는지 확인
            if (tempMap2.containsKey(card.getRank())) {
                Integer count = tempMap2.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap2.put(card.getRank(), count);
            } else {
                tempMap2.put(card.getRank(), new Integer(1));
            }
        }
        //keySet 모든 key값 가져옴
        for (Suit key : tempMap1.keySet()) {
            if (tempMap1.get(key) == 5) {
                return "FLUSH";
            }
        }
        boolean triple = false;
        for (int key : tempMap2.keySet()) {
            if (tempMap2.get(key) == 3) {
                triple = true;
            }
        }
        int pairCount = 0;
        for (int key : tempMap2.keySet()) {
            if (tempMap2.get(key) == 4)
                return "FOUR_CARD";
            if (tempMap2.get(key) == 2) {
                if (triple)
                    return "FULL_HOUSE";
                pairCount++;
            }
        if (triple)
            return "TRIPLE";
        }
        switch (pairCount) {
            case 0:
                break;
            case 1:
                return "ONE_PAIR";
            case 2:
                return "TWO_PAIR";
        }
        return "NOTHING";
    }
}
