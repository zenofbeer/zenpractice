package com.zenofbeer.zenpractice.reverse;

/**
 * Reverses a string with 2 steps.
 * 1 - Reverse all characters in the string
 * ex. This is my string --> .gnirts ym si sihT
 *
 * 2 - reverse all words in the string. A word is defined as a contiguous group of printable characters or a
 * contiguous group of non-printable characters. Punctuation is considered to be a part of the work to which
 * it is attached.
 */
public class Reverser {
    // characters outside of the below range are not printable characters.
    private static final int PRINTABLE_MIN_VALUE = 33;
    private static final int PRINTABLE_MAX_VALUE = 126;

    /**
     * Reverse the full set of characters in the string.
     * @param input
     * @return
     */
    public String reverseString(String input) {
        char[] chars = input.toCharArray();
        reverseCharacters(chars, 0, chars.length - 1);
        return new StringBuilder().append(chars).toString();
    }

    /**
     * Reverses the words in the string.
     * @param input
     * @return
     */
    public String reverseWords(String input) {
        char[] chars = input.toCharArray();
        reverseWords(chars);
        return new StringBuilder().append(chars).toString();
    }

    private void reverseCharacters(char[] chars, int startIndex, int endIndex) {
        char temp;

        while (loopChecker(startIndex, endIndex)) {
            temp = chars[startIndex];
            chars[startIndex] = chars[endIndex];
            chars[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    /**
     * 33 - 126
     */
    private void reverseWords(char[] chars) {
        int startIndex = 0;
        int endIndex = 0;
        int charsLength = chars.length;
        boolean checkPrintable = true;

        while(loopChecker(startIndex, charsLength)) {
            while(loopChecker(endIndex, charsLength) && isCheckPrintable(chars[endIndex], checkPrintable)) {
                endIndex++;
            }
            reverseCharacters(chars, startIndex, endIndex - 1);
            startIndex = endIndex;
            checkPrintable = !checkPrintable;
        }
    }

    private Boolean isCheckPrintable(char character, Boolean checkPrintable) {
        return checkPrintable == isPrintableChar(character);
    }

    private Boolean isPrintableChar(char character) {
        return character >= PRINTABLE_MIN_VALUE && character <= PRINTABLE_MAX_VALUE;
    }

    private Boolean loopChecker(int mustBeLower, int mustBeHigher) {
        return mustBeLower < mustBeHigher;
    }
}
