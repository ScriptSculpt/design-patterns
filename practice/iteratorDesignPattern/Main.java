package practice.iteratorDesignPattern;

import practice.iteratorDesignPattern.interfaces.CustomIterator;

public class Main {
    public static void main(String[] args) {
        IntegerLinkedList linkedList = new IntegerLinkedList(5);
        linkedList.next = new IntegerLinkedList(10);
        linkedList.next.next = new IntegerLinkedList(15);
        linkedList.next.next.next = new IntegerLinkedList(20);

        CustomIterator<Integer> iterator = linkedList.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
