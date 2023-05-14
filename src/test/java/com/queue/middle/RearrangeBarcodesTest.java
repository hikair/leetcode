package com.queue.middle;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RearrangeBarcodesTest {

    RearrangeBarcodes obj = new RearrangeBarcodes();

    @Test
    public void rearrangeBarcodes() {
        System.out.println(Arrays.toString(obj.rearrangeBarcodes(new int[]{1})));
        System.out.println(Arrays.toString(obj.rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2})));
        System.out.println(Arrays.toString(obj.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3})));
    }
}