
import java.util.Arrays;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s652803
 */
public class RingBuffer {

    private double[] buffer;
    private int size, first, last;

    public RingBuffer(int capacity) { // create an empty ring buffer, with given capacity
        buffer = new double[capacity];
        size = 0;
        first = 0;
        last = 0;
    }

    public int size() { // return number of items currently in the buffer
        return size;
    }

    public boolean isEmpty() { // is the buffer empty (size equals zero)?
        return size == 0;
    }

    public boolean isFull() { // is the buffer full  (size equals capacity)?
        return size == buffer.length;
    }

    public void enqueue(double x) { // add item x to the end (if not full)
        if (isFull()) {
            throw new IllegalStateException();
        }
        buffer[last++] = x;
        size++;
        if (last == buffer.length) {
            last = 0;
        }
    }

    public double dequeue() { // delete and return item from the front (if not empty)
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        double item = buffer[first];
        buffer[first] = 0.0;
        size--;
        if (++first == buffer.length) {
            first = 0;
        }
        return item;
    }

    public double peek() { // return item from the front of the buffer
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return buffer[first];
    }

    public String toString() { //form [front, next, …, next, last] 
        String out = "[";
        if (!isEmpty()) {
            int index = first;
            int length = last > first ? last : first > last ? buffer.length - first : buffer.length;
            for (int i = 0; i < length - 1; i++) {
                out += buffer[index] + ", ";
                if (++index == buffer.length) {
                    index = 0;
                }
            }
            out += buffer[index];
        }
        return out + "]";
    }
}
