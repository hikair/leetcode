package com.arr.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceBetweenBusStopsTest {

    DistanceBetweenBusStops obj = new DistanceBetweenBusStops();

    @Test
    public void distanceBetweenBusStops() {
        assertEquals(1, obj.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
        assertEquals(3, obj.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2));
        assertEquals(4, obj.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
    }
}