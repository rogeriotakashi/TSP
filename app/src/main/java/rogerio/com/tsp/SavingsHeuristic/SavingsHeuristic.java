package rogerio.com.tsp.SavingsHeuristic;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import rogerio.com.tsp.Graph.Location;
import rogerio.com.tsp.Graph.Route;

/**
 * Created by ROGERIO on 26/01/2018.
 */

public class SavingsHeuristic {

    private ArrayList<Location> locations;
    private ArrayList<Route> savingsRoutes;
    private ArrayList <Saving> savingList;

    public SavingsHeuristic(ArrayList<Location> locations) {
        this.locations = locations;
        this.savingsRoutes = new ArrayList<>();
        this.savingList = new ArrayList<>();
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

    public void computeSavings(){
        Location depot = locations.get(0);

        for(int i = 1; i < locations.size();i++){
            for(int j = i+1; j < locations.size();j++){
                double saving = locations.get(i).distance(depot) + locations.get(j).distance(depot) - locations.get(i).distance(locations.get(j));
                Saving savingObj = new Saving(i,j,saving);
                savingList.add(savingObj);
            }
        }


    }

    public void printSavings(){
        for(Saving saving : savingList){
            Log.e("Saving in the list:",saving.toString());
        }
    }

    public Route mergeRoutes(Route A, Route B){
        Log.e("Route A:",A.toString());
        Log.e("Route B:",B.toString());
        ArrayList<Location> mergedLocations = new ArrayList<>();

        for(Location location : A.getRoute()){
            mergedLocations.add(location);
        }

        for(int i = 1; i < B.getRoute().size(); i++){
            mergedLocations.add(B.getLocation(i));
        }

        Route mergedRoute = new Route(mergedLocations);

        return mergedRoute;
    }


    //Not Finished!
    public void optimize(){

        Route mergedRoute;


        //Make n routes: v0 → vi → v0, for each i ≥ 1;
        createSavingRoutes();


        //Compute the savings for merging delivery locations i and j, which is given by sij = di0 + d0j − dij , for all i, j ≥ 1 and i 6= j;
        computeSavings();


        //Sort the savings in descending order;
        Collections.sort(savingList,Collections.reverseOrder());
        printSavings();


        do {
            mergedRoute = mergeRoutes(
                    savingsRoutes.get(savingList.get(0).getI() - 1),
                    savingsRoutes.get(savingList.get(0).getJ() - 1));


            savingList.remove(savingList.get(0));

            Log.e("Merged Route:", mergedRoute.toString());

        }while(!savingList.isEmpty());
        //Repeat step (3) until no additional savings can be achieved.

    }






}
