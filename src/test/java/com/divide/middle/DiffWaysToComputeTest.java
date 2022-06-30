package com.divide.middle;

import org.junit.Test;

public class DiffWaysToComputeTest {

    DiffWaysToCompute obj = new DiffWaysToCompute();

    @Test
    public void diffWaysToCompute() {
        System.out.println(obj.diffWaysToCompute("2-1-1")); // [0,2]
        System.out.println(obj.diffWaysToCompute("2*3-4*5")); // [-34,-14,-10,-10,10]
    }
}