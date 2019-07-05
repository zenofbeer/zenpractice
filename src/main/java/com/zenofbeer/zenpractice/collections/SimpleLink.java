package com.zenofbeer.zenpractice.collections;

public class SimpleLink {
    private int _value;
    private SimpleLink _child;

    public SimpleLink(int value) {
        _value = value;
    }

    public int getValue() {
        return _value;
    }

    public void addChild(SimpleLink simpleLink) {
        if (null == _child) {
            _child = simpleLink;
        } else {
            _child.addChild(simpleLink);
        }
    }

    public boolean hasChild() {
        return _child != null;
    }

    public SimpleLink getChild() {
        return _child;
    }
}
