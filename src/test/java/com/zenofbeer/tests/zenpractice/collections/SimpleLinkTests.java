package com.zenofbeer.tests.zenpractice.collections;

import com.zenofbeer.zenpractice.collections.SingleLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleLinkTests {
    @Test
    public void validateGetFirstNodeValue() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>(0);

        for (int i = 1; i < 20; i++) {
            linkedList.addNode(i);
        }

        int expected = 0;
        int actual = linkedList.getHead();

        assertEquals(expected, actual);
    }

    @Test
    public void validateGetLastNodeValue() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>(0);

        for (int i = 1; i < 100; i++) {
            linkedList.addNode(i);
        }

        int expected = 99;
        int actual = linkedList.getTail();

        assertEquals(expected, actual);
    }

    @Test
    public void validateReverseList() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>(0);

        for (int i = 1; i < 100; i++) {
            linkedList.addNode(i);
        }

        linkedList.reverseList();

        int expectedHead = 99;
        int expectedTail = 0;
        int actualHead = linkedList.getHead();
        int actualTail = linkedList.getTail();

        assertEquals(expectedHead, actualHead);
        assertEquals(expectedTail, actualTail);
    }
}
