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

    public void sort(int[] array, int bottom, int top){
        if (bottom < top) {
            int middle = (top + bottom) / 2;

            sort(array, bottom, middle);
            sort(array, middle + 1, top);
            merge(array, bottom, middle, top);
        }
    }

    private void merge(int[] array, int bottom, int middle, int top) {
        int sizeLeft = middle - bottom + 1;
        int sizeRight = top - middle;

        int[] tempLeft = new int[sizeLeft];
        int[] tempRight = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            tempLeft[i] = array[bottom + i];
        }
        for (int i = 0; i < sizeRight; i++) {
            tempRight[i] = array[middle + 1 + i];
        }

        int index = bottom;
        int indexLeft = 0;
        int indexRight = 0;

        while (indexLeft < sizeLeft && indexRight < sizeRight) {
            if (tempLeft[indexLeft] <= tempRight[indexRight]) {
                array[index] = tempLeft[indexLeft];
                indexLeft++;
            } else {
                array[index] = tempRight[indexRight];
                indexRight++;
            }
            index++;
        }
        while (indexLeft < sizeLeft) {
            array[index] = tempLeft[indexLeft];
            indexLeft++;
            index++;
        }
        while (indexRight < sizeRight) {
            array[index] = tempRight[indexRight];
            indexRight++;
            index++;
        }
    }

    /**
     * merge 2 sorted int arrays, allowing for duplicates.
     * @param left
     * @param right
     */
    public int[] merge(int[] left, int[] right) {
        int[] tempArray = new int[left.length + right.length];
        int tempIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (tempIndex < tempArray.length) {
            // test the left array first
            if (leftIndex < left.length) {
                if (rightIndex < right.length) {
                    if (left[leftIndex] <= right[rightIndex]) {
                        tempArray[tempIndex] = left[leftIndex];
                        leftIndex++;
                        tempIndex++;
                    }
                } else {
                    tempArray[tempIndex] = left[leftIndex];
                    leftIndex++;
                    tempIndex++;
                }
            }
            if (rightIndex < right.length) {
                if (leftIndex < left.length) {
                    if (right[rightIndex] <= left[leftIndex]) {
                        tempArray[tempIndex] = right[rightIndex];
                        rightIndex++;
                        tempIndex++;
                    }
                } else {
                    tempArray[tempIndex] = right[rightIndex];
                    rightIndex++;
                    tempIndex++;
                }
            }
        }

        return tempArray;
    }

    private boolean comparator(int valueA, int valueB, boolean compareAscending) {
        if (compareAscending) {
            return valueA > valueB;
        } else {
            return valueA < valueB;
        }
    }
}
