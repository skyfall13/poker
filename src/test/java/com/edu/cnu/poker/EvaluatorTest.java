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
    public void RANK가_5개가_동일하면_스트레이트(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3,Suit.CLUBS),
                new Card(4,Suit.DIAMONDS),
                new Card(5,Suit.CLUBS),
                new Card(6,Suit.SPADES),
                new Card(7,Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("STRAIGHT"));
    }

    @Test
    public void RANK가_5개가_동일하면서_문양이_같은_스트레이트플러쉬(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3,Suit.SPADES),
                new Card(4,Suit.SPADES),
                new Card(5,Suit.SPADES),
                new Card(6,Suit.SPADES),
                new Card(7,Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("STRAIGHTFLUSH"));
    }

    @Test
    public void RANK가_5개가_동일하면서_모양_스페이스_로얄스트레이트플러쉬(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(10,Suit.SPADES),
                new Card(11,Suit.SPADES),
                new Card(12,Suit.SPADES),
                new Card(13,Suit.SPADES),
                new Card(1,Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("STRAIGHTFLUSH"));
    }

}