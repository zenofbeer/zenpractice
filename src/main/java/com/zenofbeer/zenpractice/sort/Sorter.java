package com.zenofbeer.zenpractice.sort;

/**
 * Bubble sort - take an array of random numbers and sort them. Takes a boolean parameter indicating whether to sort
 * ascending or descending.
 */
public class Sorter {
    public int[] bubbleSort(int[] randomList, boolean sortAscending) {
        boolean keepGoing = true;
        int lastIndex = randomList.length - 1;

        while(keepGoing) {
            keepGoing = false;

            for (int i = 0; i <= lastIndex; i++) {
                if (i < lastIndex) {
                    if (comparator(randomList[i], randomList[i + 1], sortAscending)) {
                        keepGoing = true;
                        int temp = randomList[i];
                        randomList[i] = randomList[i + 1];
                        randomList[i + 1] = temp;
                    }
                }
            }
        }
        return randomList;
    }

    private boolean comparator(int valueA, int valueB, boolean compareAscending) {
        if (compareAscending) {
            return valueA > valueB;
        } else {
            return valueA < valueB;
        }
    }
}
