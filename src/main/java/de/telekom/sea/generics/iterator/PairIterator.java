package de.telekom.sea.generics.iterator;



public class PairIterator <V> implements java.util.Iterator <V> {
    boolean t = true;
    Pair<V> pair;
    boolean hasNext = true;

    public PairIterator(Pair<V> pair) {
        this.pair = pair;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public V next() {
        if (t) {
            t=false;
            return pair.getT();
        } else {
            hasNext = false;
            return pair.getU();
        }
    }
}
