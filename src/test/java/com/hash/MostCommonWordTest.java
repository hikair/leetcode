package com.hash;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MostCommonWordTest {

    MostCommonWord obj = new MostCommonWord();

    @Test
    public void mostCommonWord() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        Assert.assertEquals("ball", obj.mostCommonWord(paragraph, banned));
        paragraph = "Bob hit!' a ball, the hit BALL flew far after it was hit.";
        Assert.assertEquals("hit", obj.mostCommonWord(paragraph, new String[]{}));
        Assert.assertEquals("b", obj.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
        String test = "bob. ";
        Assert.assertEquals("bob", obj.mostCommonWord(test, new String[]{"hit"}));

    }

    @Test
    public void testLetter() {
        System.out.println(Character.isLetter(' '));
    }
}