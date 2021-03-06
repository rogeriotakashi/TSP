package rogerio.com.tsp.Graph;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by ROGERIO on 17/01/2018.
 */

public class Drawer {

    private Canvas canvas;
    private Paint paint;

    public Drawer(Canvas canvas,Paint paint) {
        this.canvas = canvas;
        this.paint = paint;
    }

    public void drawLine(Location start, Location end){
        canvas.drawLine(
                (float)start.getX(),
                (float)start.getY(),
                (float)end.getX(),
                (float)end.getY(),
                paint);
    }

    public void drawLocation(Location location){
        canvas.drawCircle((float) location.getX(),(float)location.getY(),5,paint);
    }

    public void drawRoute(Route route){
        for(int i = 0; i < route.getRoute().size() ; i++){
            drawLocation(route.getLocation(i));
            drawLine(route.getLocation(i),route.getLocation((i+1) % route.getRoute().size()));
        }
    }








}
