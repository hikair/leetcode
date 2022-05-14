package com.hard;

import org.junit.Assert;
import org.junit.Test;


public class MinStickersTest {

    MinStickers obj = new MinStickers();

    @Test
    public void minStickers() {
        Assert.assertEquals(3, obj.minStickers(new String[]{"with","example","science"}, "thehat"));
        Assert.assertEquals(3, obj.minStickers(new String[]{"these","guess","about","garden","him"}, "atomher"));
    }
}