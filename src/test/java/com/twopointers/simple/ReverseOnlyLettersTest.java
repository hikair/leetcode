package com.twopointers.simple;

import org.junit.Assert;
import org.junit.Test;


public class ReverseOnlyLettersTest {

    ReverseOnlyLetters obj = new ReverseOnlyLetters();

    @Test
    public void reverseOnlyLetters() {
        Assert.assertEquals("dc-ba", obj.reverseOnlyLetters("ab-cd"));
        Assert.assertEquals("j-Ih-gfE-dCba", obj.reverseOnlyLetters("a-bC-dEf-ghIj"));
        Assert.assertEquals("Qedo1ct-eeLg=ntse-T!", obj.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}