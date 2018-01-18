package rogerio.com.tsp.Optimize;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;

import rogerio.com.tsp.Graph.Edge;
import rogerio.com.tsp.Graph.Location;
import rogerio.com.tsp.Graph.Route;

/**
 * Created by ROGERIO on 18/01/2018.
 */

public class NearestNeighbourSearch {



    public Route optimize(ArrayList<Location> locations){
        ArrayList<Location> generatedRoute = new ArrayList<>();
        HashSet<Integer> visitedVertices = new HashSet<>();
        int actualNode = 0;
        visitedVertices.add(actualNode);
        generatedRoute.add(locations.get(0));

        while (visitedVertices.size() < locations.size()) {
            int nextNode;
            nextNode = findNearestNeightbour(actualNode,locations,visitedVertices);
            visitedVertices.add(nextNode);
            generatedRoute.add(locations.get(nextNode));

            actualNode = nextNode;
        }

        generatedRoute.add(locations.get(actualNode));
        Route nearestNeighbourRoute = new Route(generatedRoute);

        return nearestNeighbourRoute;

    }

    private int findNearestNeightbour(int actualNode, ArrayList<Location> locations,HashSet<Integer> visitedVertices ){
        int nearestNode = 0;
        double nearestDist = Double.MAX_VALUE;

        for(int i = 1; i < locations.size(); i++){
            if(!visitedVertices.contains(i)){
                Edge tempEdge = new Edge(locations.get(actualNode),locations.get(i));
                if(tempEdge.getWeight() < nearestDist){
                    nearestNode = i;
                    nearestDist = tempEdge.getWeight();
                }
            }
        }

        return nearestNode;
    }

}
