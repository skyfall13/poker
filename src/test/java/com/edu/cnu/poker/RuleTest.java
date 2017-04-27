package com.edu.cnu.poker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
}