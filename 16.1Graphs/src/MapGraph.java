
import static java.lang.System.out;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import javafx.scene.layout.Priority;

/**
 * A class which represents a graph of geographic locations Nodes in the graph
 * are intersections
 *
 */
public class MapGraph {

    private int numVertices, numEdges;
    private Map<GeographicPoint, MapNode> vertexMap;

    /**
     * Create a new empty MapGraph
     */
    public MapGraph() {
        // TODO: Implement
        vertexMap = new HashMap<>();
    }

    /**
     * Get the number of vertices (road intersections) in the graph
     *
     * @return The number of vertices in the graph.
     */
    public int getNumVertices() {
        //TODO: Implement this method
        return numVertices;
    }

    /**
     * Return the intersections, which are the vertices in this graph.
     *
     * @return The vertices in this graph as GeographicPoints
     */
    public Set<GeographicPoint> getVertices() {
        //TODO: Implement this method
        return vertexMap.keySet();
    }

    /**
     * Get the number of road segments in the graph
     *
     * @return The number of edges in the graph.
     */
    public int getNumEdges() {
        //TODO: Implement this method
        return numEdges;
    }

    /**
     * Add a node corresponding to an intersection at a Geographic Point If the
     * location is already in the graph or null, this method does not change the
     * graph.
     *
     * @param location The location of the intersection
     * @return true if a node was added, false if it was not (the node was
     * already in the graph, or the parameter is null).
     */
    public boolean addVertex(GeographicPoint location) {
        // TODO: Implement this method
        if (vertexMap.containsKey(location) || location == null) {
            return false;
        }
        numVertices++;
        vertexMap.put(location, new MapNode(location));
        return true;
    }

    /**
     * Adds a directed edge to the graph from pt1 to pt2. Precondition: Both
     * GeographicPoints have already been added to the graph
     *
     * @param from The starting point of the edge
     * @param to The ending point of the edge
     * @param roadName The name of the road
     * @param roadType The type of the road
     * @param length The length of the road, in km
     * @throws IllegalArgumentException If the points have not already been
     * added as nodes to the graph, if any of the arguments is null, or if the
     * length is less than 0.
     */
    public void addEdge(GeographicPoint from, GeographicPoint to, String roadName,
            String roadType, double length) throws IllegalArgumentException {
        //TODO: Implement this method
        numEdges++;
        vertexMap.get(from).addEdge(from, to, roadName, roadType, length);
    }

    /**
     * Find the path from start to goal using breadth first search
     *
     * @param start The starting location
     * @param goal The goal location
     * @return The list of intersections that form the shortest (unweighted)
     * path from start to goal (including both start and goal).
     */
    public List<GeographicPoint> bfs(GeographicPoint start,
            GeographicPoint goal) {
        // TODO: Implement this method
        Queue<MapNode> list = new PriorityQueue<>();
        Set<GeographicPoint> visited = new HashSet<>();
        Map<MapNode, MapNode> parentMap = new HashMap<>();
        list.add(vertexMap.get(start));
        visited.add(start);
        MapNode curr;
        while (!list.isEmpty()) {
            curr = list.poll();
            if (curr.gp.toString().equals(goal.toString())) {
                List<GeographicPoint> path = getPath(vertexMap.get(goal), parentMap);
                return path;
            }
            for (MapEdge ed : curr.edges) {
                if (!visited.contains(ed.end)) {
                    visited.add(ed.end);
                    parentMap.put(vertexMap.get(ed.end), curr);
                    list.add(vertexMap.get(ed.end));
                }
            }
        }
        return null;
    }

    private List<GeographicPoint> getPath(MapNode curr, Map<MapNode, MapNode> parentMap) {
        List<GeographicPoint> path = new LinkedList();
        while (curr != null) {
            path.add(0, curr.gp);
            curr = parentMap.get(curr);
        }
        return path;
    }

    /**
     * Find the path from start to goal using Dijkstra's algorithm
     *
     * @param start The starting location
     * @param goal The goal location
     * @return The list of intersections that form the shortest path from start
     * to goal (including both start and goal).
     */
    public List<GeographicPoint> dijkstra(GeographicPoint start,
            GeographicPoint goal) {
        // TODO: Implement this method in part two
        for (GeographicPoint point : vertexMap.keySet()) {
            vertexMap.get(point).distance = Double.MAX_VALUE;
            vertexMap.get(point).heuristic = 0;
        }
        return dijkstraHelp(start, goal, "Dijkstra Count: ");
    }

    /**
     * Find the path from start to goal using A-Star search
     *
     * @param start The starting location
     * @param goal The goal location
     * @param nodeSearched A hook for visualization. See assignment instructions
     * for how to use it.
     * @return The list of intersections that form the shortest path from start
     * to goal (including both start and goal).
     */
    public List<GeographicPoint> aStarSearch(GeographicPoint start,
            GeographicPoint goal) {
        // TODO: Implement this method in part two
        for (GeographicPoint point : vertexMap.keySet()) {
            vertexMap.get(point).distance = Double.MAX_VALUE;
            vertexMap.get(point).heuristic = point.distance(goal);
        }
        return dijkstraHelp(start, goal, "A* Count: ");
    }

    private List<GeographicPoint> dijkstraHelp(GeographicPoint start, GeographicPoint goal, String alg) {
        Queue<MapNode> pq = new PriorityQueue<>();
        Set<MapNode> visited = new HashSet<>();
        Map<MapNode, MapNode> parentMap = new HashMap<>();
        int count = 0;
        vertexMap.get(start).distance = 0;
        pq.add(vertexMap.get(start));
        MapNode curr;
        while (!pq.isEmpty()) {
            curr = pq.poll();
            count++;
            if (!visited.contains(curr)) {
                visited.add(curr);
            }
            if (curr.gp.toString().equals(goal.toString())) {
                List<GeographicPoint> path = getPath(vertexMap.get(goal), parentMap);
                System.out.println(alg + count);
                return path;
            }
            for (MapEdge edge : curr.edges) {
                MapNode currNode = vertexMap.get(edge.end);
                if (curr.distance + edge.distance < currNode.distance) {
                    currNode.distance = curr.distance + edge.distance;
                    parentMap.put(currNode, curr);
                    pq.add(currNode);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.print("Making a new map...");
        MapGraph theMap = new MapGraph();
        System.out.print("DONE. \nLoading the map...");
        GraphLoader.loadRoadMap("simpletest.map", theMap);
        System.out.println("DONE.");
        System.out.println("Num nodes: " + theMap.getNumVertices());
        System.out.println("Num edges: " + theMap.getNumEdges());
        //System.out.println(theMap.bfs(new GeographicPoint(1.0, 1.0), new GeographicPoint(8, -1)));

        // uncomment for part 2
        System.out.println(theMap.dijkstra(new GeographicPoint(1.0, 1.0), new GeographicPoint(8, -1)));
        System.out.println(theMap.aStarSearch(new GeographicPoint(1.0, 1.0), new GeographicPoint(8, -1)));
    }

}

class MapNode implements Comparable<MapNode> {

    GeographicPoint gp;
    List<MapEdge> edges;
    // add other instance variables/constructors/methods as you deem necessary
    double distance, heuristic;

    public MapNode(GeographicPoint gp) {
        this.gp = gp;
        edges = new ArrayList<>();
    }

    public void addEdge(GeographicPoint start, GeographicPoint end, String streetName,
            String roadType, double distance) {
        edges.add(new MapEdge(start, end, streetName, roadType, distance));
    }

    public int compareTo(MapNode other) {
        return Double.compare(distance + heuristic, other.distance + other.heuristic);
    }

}

class MapEdge {

    GeographicPoint start;
    GeographicPoint end;
    String streetName, roadType;
    double distance;

    public MapEdge(GeographicPoint start, GeographicPoint end, String streetName, String roadType, double distance) {
        this.start = start;
        this.end = end;
        this.streetName = streetName;
        this.roadType = roadType;
        this.distance = distance;
    }

    public String toString() {
        return "" + start + " " + end;
    }
}
