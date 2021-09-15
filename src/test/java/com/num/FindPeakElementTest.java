package com.num;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindPeakElementTest {

    private FindPeakElement obj;

    @Before
    public void init() {
        obj = new FindPeakElement();
    }

    @Test
    public void findPeakElement() {
        assertEquals(obj.findPeakElement(new int[]{1,2,1,3,5,6,4}), 1);
    }
}