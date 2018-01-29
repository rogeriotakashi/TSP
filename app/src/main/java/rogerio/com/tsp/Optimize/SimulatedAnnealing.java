package rogerio.com.tsp.Optimize;

import android.util.Log;

import java.util.Arrays;
import java.util.Random;

import rogerio.com.tsp.Graph.Route;

/**
 * Created by ROGERIO on 29/01/2018.
 */

public class SimulatedAnnealing {

    double temperature;
    double coolingRate;

    public SimulatedAnnealing() {
        this.temperature = 1000.0;
        this.coolingRate = 0.5;
    }

    public void optimize(Route randomRoute){

        //Actual Best Solution
        double bestSolution = randomRoute.cost();


        swap(randomRoute);

    }

    public void swap(Route route){
        int[] points = pick2RandomPoints(route);
        Log.e("Points:", Arrays.toString(points));



    }

    public int[] pick2RandomPoints(Route route){
        Random random = new Random();
        int[] points = new int[2];
        //Pick 2 random points to swap
        points[0] = random.nextInt(route.getRoute().size());
        do {
            points[1] = random.nextInt(route.getRoute().size());
        }while(points[0] == points[1]);


        return points;
    }





}
