package rogerio.com.tsp.Optimize;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import rogerio.com.tsp.Graph.Location;
import rogerio.com.tsp.Graph.Route;

/**
 * Created by ROGERIO on 02/02/2018.
 */

public class TwoOptSwap {

    public Route optimize(Route route){
        double distance = route.cost();

        for(int i = 0; i < route.getRoute().size(); i++){
            for(int j = i+1; j < route.getRoute().size() - 1;j++){
                Route newRoute = swap(route, i , j );

                if(newRoute.cost() < route.cost()){
                    route = newRoute;
                }
            }
        }

        return route;
    }


    public Route swap (Route route, int i, int j){
        Route newRoute = new Route(route);

        //swap i with j
        Location temp = newRoute.getLocation(i);
        newRoute.setRoute(i,route.getLocation(j));
        newRoute.setRoute(j,temp);



        //reverse between i and j
        Stack<Location> locationStack = new Stack<>();
        for(int x = i+1; x < j ; x++){
            locationStack.push(route.getLocation(x));
        }

        for(int x = i+1; x < j ; x++){
            newRoute.setRoute(x,locationStack.pop());
        }


        return newRoute;
    }
}
