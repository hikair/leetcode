package com.stack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeserializeTest {

    Deserialize obj = new Deserialize();

    @Test
    public void deserialize() {
        Deserialize.NestedInteger deserialize = obj.deserialize("324");
        Assert.assertEquals(324, (int)deserialize.getInteger());
        deserialize = obj.deserialize("[123,[456,[789]]]");
        System.out.println();
    }
}