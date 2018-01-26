package rogerio.com.tsp.Optimize;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

import rogerio.com.tsp.Graph.Drawer;
import rogerio.com.tsp.Graph.Edge;
import rogerio.com.tsp.Graph.Location;
import rogerio.com.tsp.Graph.Route;



/**
 * Created by ROGERIO on 18/01/2018.
 */

public class NearestNeighbourSearchAsyncTask extends AsyncTask < ArrayList<Location>, ArrayList<Location>, Route> {

    private Context context;
    private TextView txtDistance;
    private Drawer drawer;


    public NearestNeighbourSearchAsyncTask(Context context,TextView txtDistance,Drawer drawer) {
        this.context = context;
        this.txtDistance = txtDistance;
        this.drawer = drawer;
    }

    @Override
    protected Route doInBackground(ArrayList<Location>... arrayLists) {
        ArrayList<Location> generatedRoute = new ArrayList<>();
        HashSet<Integer> visitedVertices = new HashSet<>();
        int actualNode = 0;
        visitedVertices.add(actualNode);
        generatedRoute.add(arrayLists[0].get(0));

        while (visitedVertices.size() < arrayLists[0].size()) {
            int nextNode;
            nextNode = findNearestNeightbour(actualNode,arrayLists[0],visitedVertices);
            visitedVertices.add(nextNode);
            generatedRoute.add(arrayLists[0].get(nextNode));

            actualNode = nextNode;
        }

        generatedRoute.add(arrayLists[0].get(actualNode));

        Route nearestNeighbourRoute = new Route(generatedRoute);


        return nearestNeighbourRoute;
    }



    @Override
    protected void onPostExecute(Route route){
        drawer.drawRoute(route);
        txtDistance.setText(route.cost()+"");
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
