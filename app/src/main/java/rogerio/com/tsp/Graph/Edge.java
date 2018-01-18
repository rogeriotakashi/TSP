package rogerio.com.tsp.Graph;

/**
 * Created by ROGERIO on 17/01/2018.
 */

public class Edge {
    private Location start;
    private Location end;
    private double weight;

    public Edge(Location start, Location end) {
        this.start = start;
        this.end = end;
        this.weight = start.distance(end);
    }

    public double getWeight() {
        return weight;
    }
}
