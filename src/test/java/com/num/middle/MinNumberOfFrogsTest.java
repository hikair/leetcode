package com.num.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinNumberOfFrogsTest {

    MinNumberOfFrogs obj = new MinNumberOfFrogs();

    @Test
    public void minNumberOfFrogs() {
        assertEquals(1, obj.minNumberOfFrogs("croakcroak"));
        assertEquals(2, obj.minNumberOfFrogs("crcoakroak"));
        assertEquals(-1, obj.minNumberOfFrogs("croakcrook"));
    }
}