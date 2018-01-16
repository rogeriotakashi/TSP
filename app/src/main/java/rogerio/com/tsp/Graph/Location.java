package rogerio.com.tsp.Graph;

/**
 * Created by ROGERIO on 15/01/2018.
 */

public class Location extends Vertex {

    private int x;
    private int y;

    public Location(int id,int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
