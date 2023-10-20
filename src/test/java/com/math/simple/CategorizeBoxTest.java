package com.math.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class CategorizeBoxTest {

    CategorizeBox obj = new CategorizeBox();

    @Test
    public void categorizeBox() {
        assertEquals("Both", obj.categorizeBox(2909, 3968, 3272, 727));
    }
}