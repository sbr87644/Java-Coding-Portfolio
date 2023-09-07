
import java.awt.Color;
import java.util.AbstractList;
import java.util.LinkedList;

public class Tour implements TourInterface {

    MyLinkedList<Point> currTour;

    public Tour() {
        currTour = new MyLinkedList();
    }

    public Tour(Point a, Point b, Point c, Point d) {
        currTour = new MyLinkedList();
        currTour.add(a);
        currTour.add(b);
        currTour.add(c);
        currTour.add(d);
    }

    public void draw(Point p) {
        for (int i = 1; i < currTour.size(); i++) {
            if (currTour.get(i - 1).equals(p) || currTour.get(i).equals(p)) {
                StdDraw.setPenColor(Color.PINK);
            }
            currTour.get(i - 1).drawTo(currTour.get(i));
            StdDraw.setPenColor(Color.black);
        }
        if (currTour.get(0).equals(p) || currTour.get(currTour.size() - 1).equals(p)) {
            StdDraw.setPenColor(Color.PINK);
        }
        currTour.get(0).drawTo(currTour.get(currTour.size() - 1));
    }

    public int size() {
        return currTour.size();
    }

    public double distance() {
        double dist = 0.0;
        for (int i = 1; i < currTour.size(); i++) {
            dist += currTour.get(i - 1).distanceTo(currTour.get(i));
        }
        return dist + currTour.get(0).distanceTo(currTour.get(currTour.size() - 1));
    }

    public void insertInOrder(Point p) {
        if (p != null) {
            currTour.add(p);
        }
    }

    public void insertNearest(Point p) {
        if (p != null && size() > 0) {
            double near = Double.MAX_VALUE, dist;
            int index = 0;
            for (int i = 0; i < currTour.size(); i++) {
                dist = p.distanceTo(currTour.get(i));
                if (dist < near) {
                    near = dist;
                    index = i;
                }
            }
            currTour.add(index, p);
        } else
            currTour.add(p);
    }

    public void insertSmallest(Point p) {
        if (p != null && size() > 0) {
            double small = Double.MAX_VALUE, dist1, dist2;
            int index = 0;
            for (int i = 1; i < currTour.size(); i++) {
                dist1 = currTour.get(i - 1).distanceTo(currTour.get(i));
                dist2 = currTour.get(i - 1).distanceTo(p) + p.distanceTo(currTour.get(i));
                if (dist2 - dist1 < small) {
                    small = dist2 - dist1;
                    index = i;
                }
            }
            dist1 = currTour.get(0).distanceTo(currTour.get(currTour.size() - 1));
            dist2 = currTour.get(0).distanceTo(p) + p.distanceTo(currTour.get(currTour.size() - 1));
            if (dist2 - dist1 < small) {
                index = 0;
            }

            currTour.add(index, p);
        } else {
            currTour.add(p);
        }
    }

    public String toString() {
        String out = "";
        for (Point p : currTour) {
            out += p.toString() + "\n";
        }
        return out;
    }

    public static void main(String[] args) {
        // define 4 points forming a square
        Point a = new Point(100.0, 100.0);
        Point b = new Point(500.0, 100.0);
        Point c = new Point(500.0, 500.0);
        Point d = new Point(100.0, 500.0);

        // Set up a Tour with those four points
        // The constructor should link a->b->c->d->a
        Tour squareTour = new Tour(a, b, c, d);

        // check the toString() and Output the Tour
        StdOut.println(squareTour);

        // check the distance -> 1600.0
        StdOut.println(squareTour.distance());

        // call draw -> should be square
        StdDraw.setXscale(0, 600);
        StdDraw.setYscale(0, 600);

        squareTour.draw(a);

    }

    private class MyLinkedList<E> extends AbstractList<E> {

        LLNode<E> head;
        LLNode<E> tail;
        int size;

        public MyLinkedList() {
            // TODO: Implement this method
            head = new LLNode<>(null, tail, null);
            tail = new LLNode<>(head, null, null);
        }

        public boolean add(E element) {
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

        public E get(int index) {
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

        public void add(int index, E element) {
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

        public int size() {
            // TODO: Implement this method
            return size;
        }

        public E remove(int index) {
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
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
            size--;
            return item;
        }

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

    private class LLNode<E> {

        LLNode<E> prev;
        LLNode<E> next;
        E data;

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

        public String toString() {
            return data + "";
            //"Prev: " + prev.data +" Data: " + data + " Next: " + next.data + " "
        }
    }

}
