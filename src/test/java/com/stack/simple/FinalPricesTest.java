package com.stack.simple;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FinalPricesTest {

    FinalPrices obj = new FinalPrices();

    @Test
    public void finalPrices() {
        System.out.println(Arrays.toString(obj.finalPrices(new int[]{8, 4, 6, 2, 3})));
    }
}