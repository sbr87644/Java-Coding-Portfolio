
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.*;

public class Clustering {

    public static double clustering(int[] x, int[] y, int k) {
        //write your code here
        double result = 0;
        Point[] points = getPoints(x, y);
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(x.length);
        Queue<Edge> edges = new PriorityQueue();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    edges.add(new Edge(points[i], points[j]));
                }
            }
        }
        Edge e;
        while (uf.count() > k) {
            e = edges.poll();
            if (!uf.connected(e.p1.n, e.p2.n)) {
                uf.union(e.p1.n, e.p2.n);
                result += e.distance;
            }
        }
        
        if(k == 1)
            return Double.parseDouble(String.format("%.9f", result));

        e = edges.poll();
        while (uf.connected(e.p1.n, e.p2.n)) {
            e = edges.poll();
        }
        return Double.parseDouble(String.format("%.9f", e.distance));
    }

    private static Point[] getPoints(int[] x, int[] y) {
        Point[] points = new Point[x.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(x[i], y[i], i);
        }
        return points;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        System.out.println(clustering(x, y, k));
    }

    public static class Point {

        double x, y;
        int n;

        public Point(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }

        public String toString() {
            return x + " " + y;
        }
    }

    public static class Edge implements Comparable {

        Point p1, p2;
        double distance;

        public Edge(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
            distance = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
        }

        public int compareTo(Object o) {
            Edge other = (Edge) o;
            return Double.compare(distance, other.distance);
        }
    }
}
