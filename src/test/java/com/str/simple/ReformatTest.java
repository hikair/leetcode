package com.str.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReformatTest {

    Reformat obj = new Reformat();

    @Test
    public void reformat() {
        // 1 a 1 a 1
        // a 1 a 1 1
        String a = "11111aaaa";

        System.out.println(obj.reformat(a));
    }
}