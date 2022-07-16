package com.movingwindow.simple;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {

    int size;
    Deque<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
        queue = new ArrayDeque<>();
    }

    public double next(int val) {
        queue.add(val);
        if (queue.size() > size) {
            queue.pollFirst();
        }
        return queue.stream().mapToDouble(e -> e * 1.0).average().orElse(0);
    }
}
