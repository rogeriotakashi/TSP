package rogerio.com.tsp.Optimize;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import rogerio.com.tsp.Graph.Location;
import rogerio.com.tsp.Graph.Route;

/**
 * Created by ROGERIO on 29/01/2018.
 */

public class SimulatedAnnealing {

    double temperature;
    double coolingRate;
    private ArrayList<Location> locationList;

    public SimulatedAnnealing(ArrayList<Location> locationList) {
        this.temperature = 1000.0;
        this.coolingRate = 0.5;
        this.locationList = locationList;
    }

    public Route optimize(){
        Route route = new Route(locationList);
        route.getRandomRoute();

        //Actual Best Solution
        double bestSolution;
        double actualSolution;
        Random random = new Random();



        while(temperature > 1){

            //Deep copy
            Route newRoute = new Route(route);


            bestSolution = route.cost();


            //generate a neighbour solution
            swap(newRoute);
            actualSolution = newRoute.cost();


            Log.e("Best Known: ",""+bestSolution);
            Log.e("generated: ",""+actualSolution);
            Log.e("Temperature: ",""+temperature);
            //Calculate the accpetance probability based on actual temperature,generated solution and best solution
            double acceptanceProbability = acceptanceProbability(bestSolution,actualSolution,temperature);
            Log.e("acceptanceProbability: ",""+acceptanceProbability);


            double rand = random.nextDouble();
            if(acceptanceProbability > rand){
                Log.e("Aqui:","----------");
                route = newRoute;
            }

            temperature = temperature - coolingRate;

        }

        return route;
    }

    public double acceptanceProbability(double bestSolution, double actualSolution, double temperature){

        //100% chance to be accepted
        if(actualSolution < bestSolution)
            return 1.0;

        //else calculate the probability
        return Math.exp((bestSolution - actualSolution)/temperature);
    }

    public void swap(Route route){
        int[] points = pick2RandomPoints(route);
        Log.e("Points:", Arrays.toString(points));

        //swap
        Location temp = route.getLocation(points[0]);
        route.setRoute(points[0],route.getLocation(points[1]));
        route.setRoute(points[1],temp);


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
