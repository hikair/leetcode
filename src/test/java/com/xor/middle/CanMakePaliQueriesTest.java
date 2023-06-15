package com.xor.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class CanMakePaliQueriesTest {

    CanMakePaliQueries obj = new CanMakePaliQueries();

    @Test
    public void canMakePaliQueries() {
        System.out.println(obj.canMakePaliQueries("rkzavgdmdgt", new int[][]{{5, 8, 0}, {7, 9, 1}, {3, 6, 4}, {5, 5, 1}, {8, 10, 0}, {3, 9, 5}, {0, 10, 10}, {6, 8, 3}}));
        System.out.println(obj.canMakePaliQueries("abcda", new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}}));
    }
}