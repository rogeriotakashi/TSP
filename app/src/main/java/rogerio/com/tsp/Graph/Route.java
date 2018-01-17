package rogerio.com.tsp.Graph;

import java.util.ArrayList;

/**
 * Created by ROGERIO on 17/01/2018.
 */

public class Route {

    ArrayList<Location> route;

    public Route(ArrayList<Location> route) {
        this.route = route;
    }

    public double cost(){
        double totalCost = 0.0;

        for(int i = 0; i < route.size() ; i++){
            totalCost += route.get(i).distance(route.get((i+1) % route.size()));
        }


        return totalCost;
    }

    public ArrayList<Location> getRoute(){
        return route;
    }

    public Location getLocation(int i){
        return route.get(i);
    }


}
