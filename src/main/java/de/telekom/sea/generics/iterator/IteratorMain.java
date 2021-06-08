package de.telekom.sea.generics.iterator;

import java.util.LinkedList;
import java.util.List;

public class IteratorMain {

    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        list.add("1. element");
        list.add("2. element");

        for(String element :list) {
            System.out.println(element);
        }

        Iterator iterator = new Iterator(list);

        for (iterator.init(); iterator.continueLoop();iterator.next()) {
            System.out.println(iterator.element());

        }

        IteratorImpl iterator1 = new IteratorImpl(list);
        iterator1.hasNext();
    }
}

