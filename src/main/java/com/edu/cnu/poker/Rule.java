package com.edu.cnu.poker;

/**
 * Created by 백승진 on 2017-04-23.
 */
public class Rule {

    private EnumRule priority;
    private Suit suit;
    private int first;
    private int second;

    public Rule(EnumRule priority) {
        this.priority = priority;
    }

    public Rule(EnumRule priority, int first) {
        this.priority = priority;
        this.first = first;
    }

    public Rule(EnumRule priority, Suit suit) {
        this.priority = priority;
        this.suit = suit;
    }

    public EnumRule getPriority() {
        return this.priority;
    }


    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }


    public void setSecond(Suit suit) {
        this.suit = suit;
    }


    public void setSecond(int second) {
        this.second = second;
    }

    public int compareTo(Rule otherRule) {
        if (this.getPriority().compareTo(otherRule.getPriority()) > 0) {
            return 1;
        } else if (this.getPriority().compareTo(otherRule.getPriority()) < 0) {
            return -1;
        }else return 0;
    }
}