package de.telekom.sea.generics;

public class Together<T, U> {

    private T t;
    private U u;

    public Together(T t, U u) {
        this.t = t;
        this.u = u;
    }

    public Together() {
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setU(U u) {
        this.u = u;
    }

    public T getT() {
        return t;
    }

    public U getU() {
        return u;
    }

    public boolean join(T t, U u) {
        this.t = t;
        this.u = u;
        return true;
    }

    public void split() {
        this.t = null;
        this.u = null;

    }

    public int hashCode() {
        return t.hashCode() * 2 + u.hashCode() * 3;
    }

    public String toString() {
        return null;
    }

    public boolean equals(final Together<T, U> together) {
        if (together == null) {
            return false;
        } else if (this == together) {
            return true;
        }
//        else if (t.getClass() != this.t.getClass()) {
//            if (t.getClass() != this.u.getClass()) {
//                return false;
//            } else if (u.getClass() != this.t.getClass()) {
//                return false;
//            }
//        }
        else if ((this.t.equals(together.t) && this.u.equals(together.u)) ||
                (this.u.equals(together.t) && this.t.equals(together.u))) {
            return true;
        }
        return false;
    }
}