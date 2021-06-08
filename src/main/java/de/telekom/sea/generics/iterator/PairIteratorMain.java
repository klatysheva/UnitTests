package de.telekom.sea.generics.iterator;

public class PairIteratorMain {
    public static void main(String[] args) {
        Pair<String> pair = new Pair<String>();

        for (String s : pair) {
            System.out.println(s);
        }

    }
}
