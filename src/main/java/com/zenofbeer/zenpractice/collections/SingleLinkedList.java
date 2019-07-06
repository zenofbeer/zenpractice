package com.zenofbeer.zenpractice.collections;

public class SingleLinkedList<T> {
    private ListNode<T> _head;

    public SingleLinkedList(T value) {
        _head = new ListNode<>(value);
    }

    public void addNode(T value) {
        _head.addNextNode(new ListNode<>(value));
    }

    public T getHead() {
        return _head.getValue();
    }

    public T getTail() {
        ListNode<T> node = _head;

        while (node.hasChild()) {
            node = node.getNextNode();
        }
        return node.getValue();
    }

    public void reverseList() {
        reverseList(null, _head);
    }

    private void reverseList(ListNode<T> previous, ListNode<T> current) {
        if (!current.hasChild()) {
            current.setNextNode(previous);
            _head = current;
        } else {
            ListNode<T> nextCurrent = current.getNextNode();
            current.setNextNode(previous);
            reverseList(current, nextCurrent);
        }
    }

    private class ListNode<T> {
        private T _value;
        private ListNode<T> _nextNode;

        private ListNode(T value) {
            _value = value;
        }

        private void addNextNode(ListNode<T> node) {
            if (!hasChild()) {
                _nextNode = node;
            } else {
                _nextNode.addNextNode(node);
            }
        }

        private void setNextNode(ListNode<T> node) {
            _nextNode = node;
        }

        private boolean hasChild() {
            return null != _nextNode;
        }

        private ListNode<T> getNextNode() {
            return _nextNode;
        }

        private T getValue() {
            return _value;
        }
    }
}
