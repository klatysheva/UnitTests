package de.telekom.sea.generics.iterator;

import java.util.List;

public class Iterator {

    private List <String> list;
    private int i;

    public Iterator(List<String> list) {
        this.list = list;
    }

    void init() {
         i = 0;
    }

    boolean continueLoop () {
        return (i < list.size());
    }

    void next() {
        i++;
    }

    String element () {
        return list.get(i);
    }
}
