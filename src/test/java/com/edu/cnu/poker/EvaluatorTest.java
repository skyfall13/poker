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
    public void rank4개가_동일하면_포카드이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(3, Suit.DIAMONDS),
                new Card(3, Suit.SPADES),
                new Card(3, Suit.HEARTS),
                new Card(5, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FOURCARD"));
    }
    @Test
    public void rank3개가_동일하면_트리플이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(3, Suit.DIAMONDS),
                new Card(3, Suit.SPADES),
                new Card(6, Suit.CLUBS),
                new Card(5, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TRIPLE"));
    }

    @Test
    public void rank3개가_동일하면서_2개가_동일하면_풀하우스이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(3, Suit.DIAMONDS),
                new Card(3, Suit.SPADES),
                new Card(2, Suit.CLUBS),
                new Card(2, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FULLHOUSE"));
    }
    @Test
    public void rank2개가_동일한_카드쌍이_두개이면_투페어이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(3, Suit.DIAMONDS),
                new Card(7, Suit.SPADES),
                new Card(2, Suit.CLUBS),
                new Card(2, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TOWPAIR"));
    }
}