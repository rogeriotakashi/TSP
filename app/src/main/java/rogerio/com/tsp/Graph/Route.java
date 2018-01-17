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

    public long cost(){
        //TODO
        return 0;
    }

    public ArrayList<Location> getRoute(){
        return route;
    }

    public Location getLocation(int i){
        return route.get(i);
    }


}
