package de.telekom.sea.generics.iterator;

import java.util.List;

public class IteratorImpl<T> implements IIterator{

    private int i = 0;
    private List<T> list;

    public IteratorImpl(List<T> list) {
        this.list = list;
    }

    @Override
    public T next() {
        return list.get(i++);
    }

    @Override
    public boolean hasNext() {
        return ( i < list.size());
    }
}
