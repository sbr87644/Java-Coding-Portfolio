
import static java.lang.System.out;
import java.util.AbstractList;

// A class that implements a doubly linked list
public class MyLinkedList<E> extends AbstractList<E> {

    LLNode<E> head;
    LLNode<E> tail;
    int size;

    /**
     * Create a new empty LinkedList
     */
    public MyLinkedList() {
        // TODO: Implement this method
        head = new LLNode<>(null, tail, null);
        tail = new LLNode<>(head, null, null);
    }

    /**
     * Appends an element to the end of the list
     *
     * @param element The element to add
     */
    public boolean add(E element) {
        // TODO: Implement this method
        if (size == 0) {
            head.data = element;
        } else if (size == 1) {
            tail.data = element;
            tail.prev.next = tail;
        } else {
            LLNode<E> temp = new LLNode<>(tail, null, element);
            tail.prev.next = tail;
            tail.next = temp;
            tail = temp;
        }
        size++;
        return true;
    }

    /**
     * Get the element at position index
     *
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E get(int index) {
        // TODO: Implement this method.
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int pos = 0;
        LLNode<E> temp = head;
        while (pos < index) {
            pos++;
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     * Add an element to the list at the specified index
     *
     * @param The index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element) {
        // TODO: Implement this method
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int pos = 0;
        LLNode<E> curr = head;
        while (pos < index) {
            pos++;
            curr = curr.next;
        }
        if (index == size) {
            add(element);
            size--;
        } else if (index == 0) {
            head = new LLNode<>(null, head, element);
            head.next.prev = head;
        } else {
            LLNode<E> temp = new LLNode<>(curr.prev, curr, element);
            curr.prev.next = temp;
            curr.prev = temp;
        }
        size++;
    }

    /**
     * Return the size of the list
     */
    public int size() {
        // TODO: Implement this method
        return size;
    }

    /**
     * Remove a node at the specified index and return its data element.
     *
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the
     * list
     *
     */
    public E remove(int index) {
        // TODO: Implement this method
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int pos = 0;
        LLNode<E> curr = head;
        while (pos < index) {
            pos++;
            curr = curr.next;
        }
        E item = curr.data;
        if (curr.prev == null) {
            if (size > 1) {
                head.next.prev = null;
            }
            head = head.next;
        } else if (curr.next == null) {
            // out.println("Tail Prev: " + tail.prev.next.data);
            tail.prev.next = null;
            tail = tail.prev;
            //out.println("Tail: " + tail.data);
        } else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        size--;
        return item;
    }

    /**
     * Set an index position in the list to a new element
     *
     * @param index The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element) {
        // TODO: Implement this method
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int pos = 0;
        LLNode<E> temp = head;
        while (pos < index) {
            pos++;
            temp = temp.next;
        }
        E item = temp.data;
        temp.setData(element);
        return item;
    }

    public boolean has(E item) {
        // TODO: Implement this method
        LLNode<E> temp = head;
        while (temp != null) {
            if (temp.data.equals(item)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public String toString() {
        // TODO: Implement this method
        String out = "[";
        if (head != null && size > 0) {
            LLNode<E> temp = head;
            while (temp.next != null) {
                out += temp.data + ", ";
                temp = temp.next;
            }
            out += temp.data;
        }
        return out + "]";
    }
}

class LLNode<E> {

    LLNode<E> prev;
    LLNode<E> next;
    E data;

    // TODO: Add any other methods you think are useful here
    public LLNode(E e) {
        this.data = e;
        this.prev = null;
        this.next = null;
    }

    public LLNode(LLNode<E> prev, LLNode<E> next, E data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public void setData(E e) {
        this.data = e;
    }

//    public String toString() {
//        return data + "";
//        //"Prev: " + prev.data +" Data: " + data + " Next: " + next.data + " "
//    }
}
