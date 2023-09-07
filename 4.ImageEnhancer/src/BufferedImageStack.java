//� A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.EmptyStackException;

public class BufferedImageStack<BufferedImage> {

    private int size;
    public BufferedImage[] ary;

    public BufferedImageStack() {
        ary = (BufferedImage[]) new Object[2];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getArraySize() {
        return ary.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public BufferedImage get(int spot) {
        if (spot < 0 || spot >= size) {
            throw new IndexOutOfBoundsException();
        }
        return ary[spot];
    }

    public void push(BufferedImage item) {
        if (item == null) {
            throw new java.util.NoSuchElementException();
        }
        if (size == ary.length) {
            doubleLength();
        }
        ary[size++] = item;
    }

    public BufferedImage pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        BufferedImage item = ary[--size];
        if (size <= ary.length / 4 && ary.length > 2) {
            halfLength();
        }
        BufferedImage[] temp = (BufferedImage[]) new Object[ary.length];
        System.arraycopy(ary, 0, temp, 0, size);
        ary = temp;
        return item;
    }

    public void clear() {
        ary = (BufferedImage[]) new Object[2];
        size = 0;
    }

    private void doubleLength() {
        BufferedImage[] temp = (BufferedImage[]) new Object[ary.length * 2];
        arraycopy(ary, 0, temp, 0, ary.length);
        ary = temp;
    }

    private void halfLength() {
        BufferedImage[] temp = (BufferedImage[]) new Object[ary.length / 2];
        arraycopy(ary, 0, temp, 0, temp.length);
        ary = temp;
    }
}
