package com.other.middle;

import org.junit.Assert;
import org.junit.Test;

public class TinyURLTest {

    TinyURL obj = new TinyURL();

    @Test
    public void encode() {
        String a = "http://192.168.0.1/test";
        System.out.println(a.substring(0, a.lastIndexOf("/")));
        String encode = obj.encode(a);
        Assert.assertEquals(a, obj.decode(encode));
    }
}