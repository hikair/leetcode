package com.str.middle;

import org.junit.Assert;
import org.junit.Test;


public class ValidIPAddressTest {

    ValidIPAddress obj = new ValidIPAddress();

    @Test
    public void validIPAddress() {
        Assert.assertEquals("IPv4", obj.validIPAddress("172.16.254.1"));
        Assert.assertEquals("IPv6", obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        Assert.assertEquals("Neither", obj.validIPAddress("256.256.256.256"));
        Assert.assertEquals("Neither", obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}