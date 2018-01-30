package rogerio.com.tsp.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by ROGERIO on 17/01/2018.
 */

public class Route {

    ArrayList<Location> route;

    public Route() {
    }

    public Route(ArrayList<Location> route) {
        this.route = route;
    }

    public Route (Route route){
        this.route = new ArrayList<>();

        for(Location location : route.getRoute())
            this.route.add(location);

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

    public void setRoute(int i, Location location) {
        this.route.set(i,location);
    }

    public Location getLocation(int i){
        return route.get(i);
    }

    public void getRandomRoute(){
        Collections.shuffle(route);
    }

    @Override
    public String toString() {
        String result = "";

        for(Location location : route){
            result += " "+location.id;
        }

        return result;

    }
}
