package rogerio.com.tsp.Graph;

import java.util.ArrayList;

/**
 * Created by ROGERIO on 17/01/2018.
 */

public class Graph {

    ArrayList<Location> locations;
    ArrayList<Edge> edges;

    public Graph(ArrayList<Location> locations, ArrayList<Edge> edges) {
        this.locations = locations;
        this.edges = edges;
    }
}
