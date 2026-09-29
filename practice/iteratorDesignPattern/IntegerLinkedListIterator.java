package practice.iteratorDesignPattern;

import practice.iteratorDesignPattern.interfaces.CustomIterator;

public class IntegerLinkedListIterator implements CustomIterator<Integer> {
    IntegerLinkedList current;

    public IntegerLinkedListIterator(IntegerLinkedList current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        int value = current.value;
        current = current.next;
        return value;
    }
    
}
