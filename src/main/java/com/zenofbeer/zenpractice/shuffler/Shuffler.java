package com.zenofbeer.zenpractice.shuffler;

import java.util.Random;

public class Shuffler {
    public void shuffleCards(int[] deckOfCards, int sizeOfDeck) {
        Random random = new Random();
        int randomCard;
        for (int i = sizeOfDeck - 1; i >= 0; i--) {
            randomCard = random.nextInt(sizeOfDeck - 1);
            int temp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[randomCard];
            deckOfCards[randomCard] = temp;
        }
    }
}
