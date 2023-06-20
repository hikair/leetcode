package com.sort;

public class SortLogic {
    private SortStrategy sortStrategy;

    public SortLogic(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sortArr(int[] arr) {
        sortStrategy.sortArr(arr);
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }
}
