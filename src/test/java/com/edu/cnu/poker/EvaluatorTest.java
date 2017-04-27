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
                new Card(7,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(6,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.FLUSH));
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
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.ONE_PAIR));
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
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.TWO_PAIR));
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
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.TRIPLE));
    }
    @Test
    public void RANK가_2개가_동일한게_하나있고_3개가_동일한게_하나있으면_풀하우스다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.CLUBS),
                new Card(2,Suit.DIAMONDS),
                new Card(7,Suit.DIAMONDS),
                new Card(7,Suit.HEARTS),
                new Card(7,Suit.SPADES)
        );
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.FULL_HOUSE));
    }
    @Test
    public void RANK가_연속되면_스트레이트다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4,Suit.CLUBS),
                new Card(5,Suit.DIAMONDS),
                new Card(6,Suit.DIAMONDS),
                new Card(7,Suit.HEARTS),
                new Card(8,Suit.SPADES)
        );
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.STRAIGHT));
    }
    @Test
    public void RANK가_연속되고_플러시면_스트레이트플러시다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4,Suit.DIAMONDS),
                new Card(5,Suit.DIAMONDS),
                new Card(6,Suit.DIAMONDS),
                new Card(7,Suit.DIAMONDS),
                new Card(8,Suit.DIAMONDS)
        );
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.STRAIGHT_FLUSH));
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
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.FOUR_CARD));
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
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.TRIPLE));
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
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.FULL_HOUSE));
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
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.TWO_PAIR));
    }
    @Test
    public void rank2개가_동일하면_원페어이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(3, Suit.DIAMONDS),
                new Card(7, Suit.SPADES),
                new Card(2, Suit.CLUBS),
                new Card(5, Suit.DIAMONDS)
        );
        Rule result = evaluator.evaluate(cardList);
        assertThat(result.getPriority(), is(EnumRule.ONE_PAIR));
    }

}