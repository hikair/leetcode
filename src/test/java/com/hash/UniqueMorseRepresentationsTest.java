package com.hash;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UniqueMorseRepresentationsTest {

    UniqueMorseRepresentations obj = new UniqueMorseRepresentations();

    @Test
    public void uniqueMorseRepresentations() {
        String[] a = new String[]{"gin", "zen", "gig", "msg"};
        Assert.assertEquals(2, obj.uniqueMorseRepresentations(a));
        a = new String[]{"a"};
        Assert.assertEquals(1, obj.uniqueMorseRepresentations(a));
    }
}