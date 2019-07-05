package com.zenofbeer.tests.zenpractice.collections;

import com.zenofbeer.zenpractice.collections.SimpleLink;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleLinkTests {
    @Test
    public void validateAddingNodes() {
        SimpleLink root = new SimpleLink(0);

        for (int i = 1; i < 20; i++) {
            SimpleLink link = new SimpleLink(i);
            root.addChild(link);
        }

        boolean foundLast = false;
        int lastValue = 0;
        SimpleLink list = root.getChild();

        while(!foundLast) {
            if (list.hasChild()) {
                list = list.getChild();
            } else {
                foundLast = true;
                lastValue = list.getValue();
            }
        }

        assertEquals(19, lastValue);
    }

    private SimpleLink getChild(SimpleLink link) {
        if (link.hasChild()) {
            getChild(link.getChild());
        }
        return link;
    }
}
