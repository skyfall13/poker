package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cse on 2017-04-17.
 */
public class EvaluatorTest {

    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FLUSH"));
    }

    @Test
    public void RANK가_2개가_동일한게_하나있으면_원페어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(7,Suit.DIAMONDS),
                new Card(2,Suit.DIAMONDS),
                new Card(7,Suit.HEARTS),
                new Card(13,Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("ONE_PAIR"));
    }
    @Test
    public void RANK가_2개가_동일한게_두개있으면_투페어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(7,Suit.DIAMONDS),
                new Card(2,Suit.DIAMONDS),
                new Card(7,Suit.HEARTS),
                new Card(13,Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TWO_PAIR"));
    }
    @Test
    public void RANK가_3개가_동일한게_하나있으면_트리플이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(7,Suit.HEARTS),
                new Card(13,Suit.DIAMONDS),
                new Card(7,Suit.DIAMONDS),
                new Card(7,Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TRIPLE"));
    }
    @Test
    public void RANK가_2개가_동일한게_하나있고_3개가_동일한게_하나있으면_풀하우스다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(7,Suit.DIAMONDS),
                new Card(2,Suit.DIAMONDS),
                new Card(7,Suit.HEARTS),
                new Card(7,Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FULL_HOUSE"));
    }
}