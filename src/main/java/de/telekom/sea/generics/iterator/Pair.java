package de.telekom.sea.generics.iterator;

import de.telekom.sea.generics.Together;

class Pair<V> extends Together<V, V> implements java.lang.Iterable<V> {

    public java.util.Iterator<V> iterator() {
        return new PairIterator<V>(this);
    }
}
