package com.zenofbeer.tests.zenpractice.sort;

import com.zenofbeer.tools.RandomNumbers;
import com.zenofbeer.zenpractice.sort.Sorter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SorterTests {
    @Test
    public void ascendingBubbleSortUniqueTest() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Sorter sorter = new Sorter();
        int[] input = randomNumbers.getRandomUniqueList(100);
        int[] actual = sorter.bubbleSort(input, true);

        for(int i = 0; i < 100; i++) {
            assertEquals((int)actual[i], i);
        }
    }

    @Test
    public void decendingBubbleSortUniqueTest() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Sorter sorter = new Sorter();
        int[] input = randomNumbers.getRandomUniqueList(100);
        int[] actual = sorter.bubbleSort(input, false);

        int indexChecker = 99;
        for (int i = 0; i < 100; i++) {
            assertEquals((int)actual[i], indexChecker);
            indexChecker--;
        }
    }

    @Test
    public void ascendingBubbleSortDupesTest() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Sorter sorter = new Sorter();
        int[] input = randomNumbers.getRandomList(500);
        int[] actual = sorter.bubbleSort(input, true);

        for (int i = 0; i < 499; i++) {
            assertTrue(actual[i] <= actual[i + 1]);
        }
    }

    @Test
    public void descendingBubbleSortDupesTest() {

        RandomNumbers randomNumbers = new RandomNumbers();
        Sorter sorter = new Sorter();
        int[] input = randomNumbers.getRandomList(500);
        int[] actual = sorter.bubbleSort(input, false);

        for (int i = 0; i < 499; i++) {
            assertTrue(actual[i] >= actual[i + 1]);
        }
    }

    /**
     * Validates the merging of 2 fully sorted arrays, preserves dupes, and potentially differing sizes.
     */
    @Test
    public void validateMergeTest() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Sorter sorter = new Sorter();
        int[] left = sorter.bubbleSort(randomNumbers.getRandomList(70), true);
        int[] right = sorter.bubbleSort(randomNumbers.getRandomList(130), true);

        int[] merged = sorter.merge(left, right);

        for (int i = 0; i < merged.length; i++) {
            int valA = i;
            int valB = (i + 1 == merged.length) ? valA : valA + 1;
            assertTrue(valA <= valB);
        }
    }

    @Test
    public void validateMergeSortTest() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Sorter sorter = new Sorter();
        int[] array = randomNumbers.getRandomList(10);

        sorter.sort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            int valA = i;
            int valB = (i + 1 == array.length) ? valA : valA + 1;
            assertTrue(valA <= valB);
        }
    }
}
