
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PointSET {

    private SET<Point2D> set;

    public PointSET() {                     // construct an empty set of points 
        set = new SET<>();
    }

    public boolean isEmpty() {              // is the set empty? 
        return set.isEmpty();
    }

    public int size() {                      // number of points in the set 
        return set.size();
    }

    public void insert(Point2D p) {             // add the point to the set (if it is not already in the set)
        set.add(p);
    }

    public boolean contains(Point2D p) {           // does the set contain point p? 
        return set.contains(p);
    }

    public void draw() {                    // draw all points to standard draw with p.draw()
        checkIfNull(set);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        Iterator<Point2D> it = set.iterator();
        while (it.hasNext()) {
            it.next().draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) {           // all points that are inside the rectangle 
        if (rect == null) {
            throw new IllegalArgumentException();
        }
        Iterator<Point2D> it = set.iterator();
        ArrayList<Point2D> range = new ArrayList<>();
        while (it.hasNext()) {
            Point2D p = it.next();
            if (rect.contains(p)) {
                range.add(p);
            }
        }
        return range;
    }

    public Point2D nearest(Point2D p) {           // a nearest neighbor in the set to point p; null if the set is empty 
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            return null;
        }
        Iterator<Point2D> it = set.iterator();
        Point2D near = it.next();
        double nearDistance = near.distanceSquaredTo(p);
        while (it.hasNext()) {
            Point2D temp = it.next();
            double dist = temp.distanceSquaredTo(p);
            if (dist < nearDistance) {
                near = temp;
                nearDistance = dist;
            }
        }
        return near;
    }

    private void checkIfNull(Object o) {
        if (o == null) {
            throw new java.lang.NullPointerException();
        }
    }

    public static void main(String[] args) {                // unit testing of the methods (optional) 
        String filename = "circle10.txt";   // args[0];
        In in = new In(filename);

        StdDraw.enableDoubleBuffering();

        // initialize the data structures with N points from standard input
        PointSET brute = new PointSET();
        KdTree kdtree = new KdTree();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdtree.insert(p);
            brute.insert(p);
        }
        brute.draw();
        StdDraw.show();
    }
}
