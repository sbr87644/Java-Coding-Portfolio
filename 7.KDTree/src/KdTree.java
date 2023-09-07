
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import java.util.ArrayList;

public class KdTree {

    private Node root;
    private int size;
    private Point2D near;

    /**
     * returns if the size is equal to zero
     *
     * @return
     */
    public boolean isEmpty() {                      // is the set empty? 
        return size == 0;
    }

    /**
     * returns the current size of the tree
     *
     * @return
     */
    public int size() {                      // number of points in the set 
        return size;
    }

    /**
     * inserts a new node if not in the treeSet already the rectangles will
     * encompass the whole area and the point will lie inside
     *
     * @param p
     */
    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (!contains(p)) {
            root = insert(p, root, true);
        }
    }

    /**
     * helper method that inserts a node recursively and updates the Rectangle
     * with it - alternatively a Rectangle could be passed as a parameter to
     * free up space in the node class
     *
     * @param p
     * @param node
     * @param vertical vertical is current root and true being vertical line
     * @return
     */
    private Node insert(Point2D p, Node node, boolean vertical) {
        if (node == null) {
            node = new Node(p);
            node.rect = new RectHV(0, 0, 1, 1);
            size++;
        } else if (vertical) {
            if (p.x() < node.p.x()) {
                node.left = insert(p, node.left, false);
                node.left.rect = new RectHV(node.rect.xmin(), node.rect.ymin(), node.p.x(), node.rect.ymax());
            } else if (p.x() >= node.p.x()) {
                node.right = insert(p, node.right, false);
                node.right.rect = new RectHV(node.p.x(), node.rect.ymin(), node.rect.xmax(), node.rect.ymax());
            }
        } else {
            if (p.y() < node.p.y()) {
                node.left = insert(p, node.left, true);
                node.left.rect = new RectHV(node.rect.xmin(), node.rect.ymin(), node.rect.xmax(), node.p.y());
            } else if (p.y() >= node.p.y()) {
                node.right = insert(p, node.right, true);
                node.right.rect = new RectHV(node.rect.xmin(), node.p.y(), node.rect.xmax(), node.rect.ymax());
            }
        }
        return node;
    }

    /**
     * recursively ascertains if a point is in the tree
     *
     * @param p
     * @return
     */
    public boolean contains(Point2D p) {           // does the set contain point p? 
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return contains(p.x(), p.y(), root, true);
    }

    /**
     * helper method to recursively determine if a point is in the tree by
     * checking left or right based on vertical == true for x points and
     * vertical == false for y points
     *
     * @param x
     * @param y
     * @param node
     * @param vertical
     * @return
     */
    private boolean contains(double x, double y, Node node, boolean vertical) {
        if (node != null) {
            if (x == node.p.x() && y == node.p.y()) {
                return true;
            } else if (vertical) {
                if (x >= node.p.x()) {
                    return contains(x, y, node.right, false);
                } else if (x < node.p.x()) {
                    return contains(x, y, node.left, false);
                }
            } else {
                if (y >= node.p.y()) {
                    return contains(x, y, node.right, true);
                } else if (y < node.p.y()) {
                    return contains(x, y, node.left, true);
                }
            }
        }
        return false;
    }

    /**
     * draws all points to standard draw
     */
    public void draw() {
        if (!isEmpty()) {
            draw(root, true);
        }
    }

    /**
     * method recursively draws nodes and red vertical lines and blue horizontal
     * lines based on vertical
     *
     * @param node
     * @param vertical - true draws vertical red line inside node's rectangle
     * and blue horizontal line inside node's rectangle otherwise
     */
    private void draw(Node node, boolean vertical) {
        if (node != null) {
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.BLACK);
            node.p.draw();
            StdDraw.setPenRadius(0.001);
            if (vertical) {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.line(node.p.x(), node.rect.ymin(), node.p.x(), node.rect.ymax());
            } else {
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.line(node.rect.xmin(), node.p.y(), node.rect.xmax(), node.p.y());
            }
            draw(node.left, !vertical);
            draw(node.right, !vertical);
        }
    }

    /**
     * returns a data structure of all points that are inside the rectangle
     *
     * @param rect
     * @return
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<Point2D> range = new ArrayList<>();
        range(rect, root, range);
        return range;
    }

    /**
     * helper method to add points that are inside the given rectangle
     *
     * @param rect
     * @param node
     * @param list
     */
    private void range(RectHV rect, Node node, ArrayList<Point2D> list) {
        if (node != null) {
            if (rect.contains(node.p)) {
                list.add(node.p);
            }
            if (node.left != null) {
                if (node.left.rect.intersects(rect)) {
                    range(rect, node.left, list);
                }
            }
            if (node.right != null) {
                if (node.right.rect.intersects(rect)) {
                    range(rect, node.right, list);
                }
            }
        }
    }

    /**
     * a nearest neighbor in the set to point p; null if the set is empty
     *
     * @param p
     * @return
     */
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (!isEmpty()) {
            near = root.p;
            nearest(p, root, true);
        }
        return near;
    }

    /**
     * helper method to recursively calculate closest point in tree to p with
     * pruning
     *
     * @param p
     * @param node
     * @param vertical
     */
    private void nearest(Point2D p, Node node, boolean vertical) {
        if (node != null) {
            double nearDist = near.distanceSquaredTo(p);
            double dist = node.p.distanceSquaredTo(p);
            if (dist < nearDist) {
                near = node.p;
                nearDist = near.distanceSquaredTo(p);
            }
            double distLeft = node.left != null ? node.left.rect.distanceSquaredTo(p) : Integer.MAX_VALUE;
            double distRight = node.right != null ? node.right.rect.distanceSquaredTo(p) : Integer.MAX_VALUE;
            if (distLeft < distRight) {
                if (distLeft < nearDist) {
                    nearest(p, node.left, !vertical);
                    nearDist = near.distanceSquaredTo(p);
                }
                if (distRight < nearDist) {
                    nearest(p, node.right, !vertical);
                }
            } else {
                if (distRight < nearDist) {
                    nearest(p, node.right, !vertical);
                    nearDist = near.distanceSquaredTo(p);
                }
                if (distLeft < nearDist) {
                    nearest(p, node.left, !vertical);
                }
            }
        }
    }

    /**
     * throws an exception if a null reference is passed
     *
     * @param o
     */
    private void checkIfNull(Object o) {
        if (o == null) {
            throw new java.lang.NullPointerException();
        }

    }

//    public void print(Node n) {
//        if (n != null) {
//            print(n.left);
//            System.out.println("Point: " + n.p.x() + " " + n.p.y());
//            print(n.right);
//        }
//    }
//
//    public Node getRoot() {
//        return root;
//    }
    public static void main(String[] args) {                // unit testing of the methods (optional) 
        String filename = "test.txt"; // args[0];
        In in = new In(filename);

        StdDraw.enableDoubleBuffering();

        // initialize the data structures with N points from standard input
        // PointSET brute = new PointSET();
        KdTree kdtree = new KdTree();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            // kdtree.insert(p);
            kdtree.insert(p);
        }
        kdtree.draw();
        //kdtree.print(kdtree.getRoot());
        StdDraw.show();

    }

    /**
     * inner class that provides the functionality of a Node with references
     * left/right, a point and a RectHV object that is optional
     */
    private class Node {

        Node left, right;
        Point2D p;
        RectHV rect;

        public Node(Point2D p) {
            this.p = p;
        }

    }
}
