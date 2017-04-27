package com.edu.cnu.poker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * Created by noble on 2017-04-28.
 */
public class RuleTest {
    @Test
    public void 족보가다를때두Rule을비교(){
        Rule myRule = new Rule(EnumRule.FLUSH);
        Rule yourRule = new Rule(EnumRule.FULL_HOUSE);
        int result = myRule.compareTo(yourRule);

        assertThat(result, is(-1));
    }
    @Test
    public void 족보가같고_퍼스트랭크가다른_두Rule을비교(){
        Rule myRule = new Rule(EnumRule.FLUSH, 13);
        Rule yourRule = new Rule(EnumRule.FLUSH, 12);
        int result = myRule.compareTo(yourRule);

        assertThat(result, is(1));
    }
    @Test
    public void 족보와퍼스트랭크가같고_Suit가_다른_두Rule을비교(){
        Rule myRule = new Rule(EnumRule.FLUSH, 13);
        myRule.setSuit(Suit.CLUBS);
        Rule yourRule = new Rule(EnumRule.FLUSH, 13);
        yourRule.setSuit((Suit.SPADES));
        int result = myRule.compareTo(yourRule);
        System.out.println(result);
        assertTrue( result< 0 );
    }
}
