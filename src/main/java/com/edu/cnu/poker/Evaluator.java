package com.edu.cnu.poker;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public String evaluate(List<Card> cardList) {

        boolean flush_flag=false;
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();
        Map<Integer, Integer> tempMap2 = new HashMap<Integer, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }
        }

        for (Suit key : tempMap.keySet()) {
            if (tempMap.get(key) == 5) {
                flush_flag = true;
            }
        }
        for (Card card : cardList) {
            if (tempMap2.containsKey(card.getRank())) {
                Integer count = tempMap2.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap2.put(card.getRank(), count);

            }else {
                tempMap2.put(card.getRank(), new Integer(1));
            }
        }
        for (Integer key : tempMap2.keySet()) {
            if (tempMap2.get(key) == 4) {
                return "FOUR_CARD";
            }else if (tempMap2.get(key) == 2) {
                tempMap2.remove(key);
                for (Integer key2 : tempMap2.keySet()){
                    if(tempMap2.get(key2) == 2){
                        return "TWO_PAIR";
                    }else if(tempMap2.get(key2) == 3){
                        return "FULL_HOUSE";
                    }else return "ONE_PAIR";
                }
            }else if (tempMap2.get(key) == 3) {
                return "TRIPLE";
            }
        }

        Collections.sort(cardList);

        for(int i = 0; i < cardList.size() ; i++ ) {
            if(i == cardList.size() -1 ){
                if(flush_flag){
                    return "STRAIGHT_FLUSH";
                }
                return "STRAIGHT" ;
            }
            if(cardList.get(i).compareTo(cardList.get(i+1)) != -1 ){
                break;
            }
        }
        if(flush_flag){
            return "FLUSH";
        }
        return "NOTHING";
    }
}