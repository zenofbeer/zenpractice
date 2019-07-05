package com.zenofbeer.tests.zenpractice.reverse;

import com.zenofbeer.zenpractice.reverse.Reverser;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReverserTests {
    @Test
    public void validateReverseString() {
        Reverser reverser = new Reverser();
        String input = "This is my string.";
        String expected = ".gnirts ym si sihT";
        String actual = reverser.reverseString(input);

        assertEquals(expected, actual);
    }

    @Test
    public void validateReverseWords() {
        Reverser reverse = new Reverser();
        String input = ".gnirts ym si sihT";
        String expected = "string. my is This";
        String actual = reverse.reverseWords(input);

        assertEquals(expected, actual);
    }
}
