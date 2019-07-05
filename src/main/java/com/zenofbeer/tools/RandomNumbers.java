package com.zenofbeer.tools;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    public int[] getRandomUniqueList(int size) {
        Random random = new Random();
        ArrayList<Integer> randomNumberList = new ArrayList<Integer>();
        while (randomNumberList.size() < size) {
            int nextValue = random.nextInt(size);
            if (!randomNumberList.contains(nextValue)) {
                randomNumberList.add(nextValue);
            }
        }
        return randomNumberList.stream().mapToInt(i -> i).toArray();
    }

    public int[] getRandomList(int size) {
        Random random = new Random();
        ArrayList<Integer> randomNumberList = new ArrayList<Integer>();
        while(randomNumberList.size() < size) {
            randomNumberList.add(random.nextInt());
        }
        return randomNumberList.stream().mapToInt(i -> i).toArray();
    }
}
