package com.backtrack.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExistTest {

    Exist obj = new Exist();

    @Test
    public void exist() {
        assertTrue(obj.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'E'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}