package com.math.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerfulIntegersTest {

    PowerfulIntegers obj = new PowerfulIntegers();

    @Test
    public void powerfulIntegers() {
        System.out.println(obj.powerfulIntegers(2, 3, 10));
        System.out.println(obj.powerfulIntegers(3, 5, 15));
    }
}