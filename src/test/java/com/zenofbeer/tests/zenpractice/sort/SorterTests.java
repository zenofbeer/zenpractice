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
}
