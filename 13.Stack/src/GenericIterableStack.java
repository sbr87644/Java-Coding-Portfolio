//� A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import static java.lang.System.*;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class GenericIterableStack<E> implements Iterable<E>// you must use generics and implement Iterable
{

    private int size;
    public E[] ary;

    public GenericIterableStack() {
        ary = (E[]) new Object[10];
        size = 0;
    }

    // add push, pop, peek, isEmpty and listIterator(ide will write all method signatures for you)
    public E[] getArray() {
        return ary;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E push(E item) {
        if (item == null) {
            throw new java.util.NoSuchElementException();
        }
        if (size == ary.length) {
            doubleLength();
        }
        ary[size++] = item;
        return item;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E item = ary[--size];
        if (size <= ary.length / 4) {
            halfLength();
        }
        E[] temp = (E[]) new Object[ary.length];
        System.arraycopy(ary, 0, temp, 0, size);
        ary = temp;
        return item;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return ary[size - 1];
    }

    public String toString() {
        String out = "[";
        if (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                out += ary[i] + ", ";
            }
            out += ary[size - 1];
        }
        out += "]";
        return out;
    }

    private void doubleLength() {
        E[] temp = (E[]) new Object[ary.length * 2];
        arraycopy(ary, 0, temp, 0, ary.length);
        ary = temp;
    }

    private void halfLength() {
        E[] temp = (E[]) new Object[ary.length / 2];
        arraycopy(ary, 0, temp, 0, temp.length);
        ary = temp;
    }

    public Iterator<E> iterator() {
        return new it();
    }

    public ListIterator<E> listIterator() {
        return new it();
    }

    private class it implements ListIterator {

        private int spot = -1, mod = size;

        public boolean hasNext() {
            return spot + 1 < size;
        }

        public void remove() {
            if(spot < 0)
                throw new IllegalStateException();
            E[] temp = (E[]) new Object[ary.length - 1];
            int index = 0;
            for (int i = 0; i < size; i++) {
                if (i != spot) {
                    temp[index] = ary[index];
                    index++;
                }
            }
            size--;
            spot--;
            arraycopy(temp, 0, ary, 0, ary.length - 1);
        }

        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            if( mod != size)
                throw new ConcurrentModificationException();
            return ary[++spot];
        }

        public E previous() {
            if (spot < 0) {
                throw new java.util.NoSuchElementException();
            }
            return ary[spot--];
        }

        public void set(Object item) {
            if (spot < 0) {
                throw new IllegalStateException();
            }
            ary[spot] = (E) item;
            // TODO
        }

        public void add(Object item) {
            push((E) item);
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int nextIndex() {
            return spot + 1;
        }

        @Override
        public int previousIndex() {
            return spot;
        }

        @Override
        public void forEachRemaining(Consumer cnsmr) {
            ListIterator.super.forEachRemaining(cnsmr); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
