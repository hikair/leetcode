package com.arr.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class HardestWorkerTest {

    HardestWorker obj = new HardestWorker();

    @Test
    public void hardestWorker() {
        assertEquals(1, obj.hardestWorker(10, new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}}));
        assertEquals(3, obj.hardestWorker(26, new int[][]{{1, 1}, {3, 7}, {2, 12}, {7, 17}}));
        assertEquals(0, obj.hardestWorker(2, new int[][]{{0, 10}, {1, 20}}));
    }
}