package com.binarysearch.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;


public class FindKthNumberTest {

    FindKthNumber obj = new FindKthNumber();

    @Test
    public void findKthNumber() {
        Assert.assertEquals(3, obj.findKthNumber(3, 3, 5));
        Assert.assertEquals(6, obj.findKthNumber(2, 3, 6));
    }

    @Test
    public void mn() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(100);
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(i * j);
                System.out.print("\t");
                queue.add(i * j);
            }
            System.out.println();
        }
        int k = 6;
        while(k-- > 0) {
            queue.remove();
            System.out.println(queue.peek());
        }
    }
}