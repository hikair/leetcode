package com.backtrack.middle;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestoreIpAddressesTest {

    RestoreIpAddresses obj = new RestoreIpAddresses();

    @Test
    public void restoreIpAddresses() {
        assertTrue(Lists.newArrayList("255.255.11.135", "255.255.111.35").containsAll(obj.restoreIpAddresses("25525511135")));
        assertTrue(Lists.newArrayList("0.0.0.0").containsAll(obj.restoreIpAddresses("0000")));
        assertTrue(Lists.newArrayList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3").containsAll(obj.restoreIpAddresses("101023")));
    }
}