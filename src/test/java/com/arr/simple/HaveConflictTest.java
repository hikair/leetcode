package com.arr.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class HaveConflictTest {

    HaveConflict obj = new HaveConflict();

    @Test
    public void haveConflict() {
        assertTrue(obj.haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"}));
        assertTrue(obj.haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"}));
        assertFalse(obj.haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"}));
    }
}