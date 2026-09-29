package practice.iteratorDesignPattern;

import practice.iteratorDesignPattern.interfaces.CustomIterable;
import practice.iteratorDesignPattern.interfaces.CustomIterator;

public class IntegerLinkedList implements CustomIterable<Integer> {
    int value;
    IntegerLinkedList next;

    public IntegerLinkedList(int value) {
        this.value = value;
        next = null;
    }

    @Override
    public CustomIterator<Integer> getIterator() {
        return new IntegerLinkedListIterator(this);
    }

}
