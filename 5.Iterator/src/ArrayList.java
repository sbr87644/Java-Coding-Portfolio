
import java.util.Iterator;

public class ArrayList<E> implements Iterable<E> {

    private int size;
    public E[] ary;

    public ArrayList() {						  // start with an array threshold of 10
        ary = (E[]) new Object[10];
        size = 0;
    }

    public boolean isEmpty() {				  // is the list empty?
        return size == 0;
    }

    public int size() {                        // return the number of items in the list
        return size;
    }

    public void add(E item) {         	  // add the item to the end
        if (item == null) {
            throw new java.util.NoSuchElementException();
        }
        if (size == ary.length) {
            doubleLength();
        }
        ary[size++] = item;
    }

    private void doubleLength() {
        E[] temp = (E[]) new Object[ary.length * 2];
        System.arraycopy(ary, 0, temp, 0, ary.length);
        ary = temp;
    }

    public void add(E item, int spot) {         	  // add the item at the specified index       
        if (item == null) {
            throw new java.util.NoSuchElementException();
        }
        if (spot < 0 || spot > size) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (size == ary.length) {
            doubleLength();
        }
        for (int i = size; i > spot; i--) {
            ary[i] = ary[i - 1];
        }
        ary[spot] = item;
        size++;
    }

    public E remove() {                // remove and return the item at the back - this method doesn't exist in the actual API
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        E item = ary[--size];
        ary[size] = null;						// clears up loitering(garbage collection can't clean up something reachable)
        if(size <= (ary.length / 4))
            halfLength();
        return item;
    }

    public E remove(int index) {                // remove and return the item at the index
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        if (index < 0 || index >= size) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        E item = ary[index];
        for (int i = index; i < size - 1; i++) {
            ary[i] = ary[i + 1];
        }
        size--;
        if(size <= (ary.length / 4))
            halfLength();
        return item;	// just here to compile - you'll need to modify
    }
    
    private void halfLength(){
        E[] temp = (E[]) new Object[ary.length / 2];
        System.arraycopy(ary, 0, temp, 0, temp.length);
        ary = temp;
    }

    public E get(int index) {
        // TODO
        return ary[index];
    }

    public void clear() {
        size = 0;
        ary = (E[]) new Object[10];
    }

    public Iterator<E> iterator() {         // return an iterator over items in order
        return new ListIterator();
    }
    
    public Iterator<E> listIterator() {         // return an iterator over items in order
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {

        private int spot = 0;

        public boolean hasNext() {
            // TODO
            return spot < size;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            // TODO
            return ary[spot++];
        }
    }

    public static void main(String[] args) {   // unit testing

        ArrayList<String> test = new ArrayList<String>();
        test.add("Love");
        test.add("I", 0);
        test.add("Computer");
        test.add("Science");
        System.out.println(test.size());
        for (String item : test) {
            System.out.println(item);
        }
        test.remove();
        test.remove(2);
        test.remove(0);

        System.out.println("\n");
        for (String item : test) {
            System.out.println(item);
        }
        System.out.println("\n");
        test.remove();
        test.add("Iterators");
        test.add("Rock");
        for (String item : test) {
            System.out.println(item);
        }

    }
}

/*
4
I
Love
Computer
Science


Love


Iterators
Rock
 */
