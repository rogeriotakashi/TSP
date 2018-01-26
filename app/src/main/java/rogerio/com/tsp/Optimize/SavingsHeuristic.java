package rogerio.com.tsp.Optimize;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import rogerio.com.tsp.Graph.Location;
import rogerio.com.tsp.Graph.Route;

/**
 * Created by ROGERIO on 26/01/2018.
 */

public class SavingsHeuristic {

    private ArrayList<Location> locations;
    private ArrayList<Route> savingsRoutes;

    public SavingsHeuristic(ArrayList<Location> locations) {
        this.locations = locations;
        this.savingsRoutes = new ArrayList<>();
    }


    public void createSavingRoutes(){
        Location depot = locations.get(0);


        for(int i = 1; i < locations.size();i++){
            ArrayList<Location> savingRoute = new ArrayList<>();
            savingRoute.add(depot);
            savingRoute.add(locations.get(i));
            Route route = new Route(savingRoute);
            savingsRoutes.add(route);
        }

        Log.e("Arrays ---->",Arrays.toString(savingsRoutes.toArray()));

    }


    public void optimize(){

        createSavingRoutes();

    }

    //Make n routes: v0 → vi → v0, for each i ≥ 1;

    //Compute the savings for merging delivery locations i and j, which is given by sij = di0 + d0j − dij , for all i, j ≥ 1 and i 6= j;


    //Sort the savings in descending order;

    // Starting at the top of the (remaining) list of savings, merge the two routes associated with the largest (remaining) savings, provided that:
    //(a) The two delivery locations are not already on the same route;
    //(b) Neither delivery location is interior to its route, meaning that both notes are still
    //directly connected to the depot on their respective routes;
    //(c) The demand G and distance constraints D are not violated by the merged route.




    //Repeat step (3) until no additional savings can be achieved.


}
