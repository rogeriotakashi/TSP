package rogerio.com.tsp.Graph;

import android.graphics.Canvas;
import android.graphics.Paint;

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

    public void drawRoute(Route route){
        for(int i = 0; i < route.getRoute().size() ; i++){
            canvas.drawCircle((float) route.getLocation(i).getX(),(float)route.getLocation(i).getY(),10,paint);
            drawLine(route.getLocation(i),route.getLocation((i+1) % route.getRoute().size()));
        }
    }
}
