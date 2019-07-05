package com.zenofbeer.zenpractice.reverser;

public class Reverser {
    private static final int PRINTABLE_MIN_VALUE = 33;
    private static final int PRINTABLE_MAX_VALUE = 126;

    public String reverseString(String input) {
        char[] chars = input.toCharArray();
        chars = reverseCharacters(chars, 0, chars.length - 1);
        return new StringBuilder().append(chars).toString();
    }

    public String reverseWords(String input) {
        char[] chars = input.toCharArray();
        chars = reverseWords(chars);
        return new StringBuilder().append(chars).toString();
    }

    private char[] reverseCharacters(char[] chars, int startIndex, int endIndex) {
        char temp;

        while(loopChecker(startIndex, endIndex)) {
            temp = chars[startIndex];
            chars[startIndex] = chars[endIndex];
            chars[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return chars;
    }

    /**
     * 33 - 126
     */
    private char[] reverseWords(char[] chars) {
        int startIndex = 0;
        int endIndex = 0;
        int charsLength = chars.length;
        boolean checkPrintable = true;

        while(loopChecker(startIndex, charsLength)) {
            while(loopChecker(endIndex, charsLength) && isCheckPrintable(chars[endIndex], checkPrintable)) {
                endIndex++;
            }
            chars = reverseCharacters(chars, startIndex, endIndex - 1);
            startIndex = endIndex;
            checkPrintable = !checkPrintable;
        }

        return chars;
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
