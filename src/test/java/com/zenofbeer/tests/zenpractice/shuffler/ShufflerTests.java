package com.zenofbeer.tests.zenpractice.shuffler;

import com.zenofbeer.zenpractice.shuffler.Shuffler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShufflerTests {
    @Test
    public void shuffleCardsTest() {
        int[] cardDeck = new int[52];
        for (int i = 0; i < cardDeck.length; i++) {
            cardDeck[i] = i;
        }

        Shuffler shuffler  = new Shuffler();
        shuffler.shuffleCards(cardDeck, cardDeck.length);
    }
}
