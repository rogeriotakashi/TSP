package rogerio.com.tsp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import rogerio.com.tsp.Graph.Location;

/**
 * Created by ROGERIO on 15/01/2018.
 */

public class CustomView extends View {

    private Paint paint;
    private ArrayList<Location> locationList;
    private int idCounter;


    public CustomView(Context context) {
        super(context);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        locationList = new ArrayList<>();
        idCounter = 0;
    }

    @Override
    public void onDraw(Canvas canvas){
        for(Location location : locationList){
            canvas.drawCircle(location.getX(),location.getY(),10,paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                locationList.add(new Location(idCounter++,(int)event.getX(),(int)event.getY()));
                invalidate();
                break;

        }

        return false;
    }
}
