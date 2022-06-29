package com.num.simple;

import org.junit.Assert;
import org.junit.Test;

public class NumPrimeArrangementsTest {

    NumPrimeArrangements obj = new NumPrimeArrangements();

    @Test
    public void numPrimeArrangements() {
        Assert.assertEquals(12, obj.numPrimeArrangements(5));
        Assert.assertEquals(682289015, obj.numPrimeArrangements(100));
    }
}