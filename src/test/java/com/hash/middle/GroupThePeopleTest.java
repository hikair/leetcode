package com.hash.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupThePeopleTest {

    GroupThePeople obj = new GroupThePeople();

    @Test
    public void groupThePeople() {
        System.out.println(obj.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        System.out.println(obj.groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
    }
}