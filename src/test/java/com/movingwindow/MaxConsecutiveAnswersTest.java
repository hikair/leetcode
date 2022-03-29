package com.movingwindow;

import org.junit.Assert;
import org.junit.Test;

public class MaxConsecutiveAnswersTest {

    MaxConsecutiveAnswers obj = new MaxConsecutiveAnswers();

    @Test
    public void maxConsecutiveAnswers() {
        Assert.assertEquals(4, obj.maxConsecutiveAnswers("TTFF", 2));
        Assert.assertEquals(3, obj.maxConsecutiveAnswers("TFFT", 1));
        Assert.assertEquals(5, obj.maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}