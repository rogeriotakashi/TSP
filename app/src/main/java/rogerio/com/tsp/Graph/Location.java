package rogerio.com.tsp.Graph;

/**
 * Created by ROGERIO on 15/01/2018.
 */

public class Location extends Vertex {

    private double x;
    private double y;

    public Location(int id,double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public float distance(Location other){
        double x = this.x - other.getX();
        double y = this.y - other.getY();
        x = x * x;
        y = y * y;

        return Math.round(Math.sqrt(x+y));
    }
}
