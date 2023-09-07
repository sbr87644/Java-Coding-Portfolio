
import java.util.*;

public class ConnectingPoints {

    public static double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        //write your code here
        Set<Point> visited = new HashSet();
        Queue<Edge> pq = new PriorityQueue();
        Point[] points = getPoints(x, y);
        visited.add(points[0]);
        addEdges(pq, points[0]);
        Edge e;
        while (visited.size() < points.length) {
            e = pq.poll();
            if (!visited.contains(e.p2)) {
                visited.add(e.p2);
                result += e.distance;
                addEdges(pq, e.p2);
            }
        }
        return Double.parseDouble(String.format("%.9f", result));
    }

    private static Point[] getPoints(int[] x, int[] y) {
        Point[] points = new Point[x.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(x[i], y[i]);
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    points[i].edges.add(new Edge(points[i], points[j]));
                }
            }
        }
        return points;
    }

    public static void addEdges(Queue<Edge> pq, Point p) {
        for (Edge e : p.edges) {
            pq.add(e);
        }
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
        System.out.println(minimumDistance(x, y));
    }

    public static class Point {

        double x, y;
        List<Edge> edges;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            edges = new ArrayList();
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
