package rogerio.com.tsp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import rogerio.com.tsp.Graph.Drawer;
import rogerio.com.tsp.Graph.Location;
import rogerio.com.tsp.Graph.Route;


public class MainActivity extends AppCompatActivity {


    //Painting
    private Bitmap bitmap;
    private Canvas canvas;
    private ImageView imageView;
    private Paint paint;


    //Structure
    private ArrayList<Location> locationList;
    private int idCounter;

    //Buttons
    private Button btnRandom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationList = new ArrayList<>();
        idCounter = 0;

        imageView = (ImageView) findViewById(R.id.imageView);
        btnRandom = (Button) findViewById(R.id.btnRandom);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Route
                Route route = new Route(locationList);

                paint = new Paint();
                paint.setColor(Color.BLACK);
                Drawer drawer = new Drawer(canvas,paint);
                drawer.drawRoute(route);

            }
        });

    }







    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        bitmap  = Bitmap.createBitmap(imageView.getWidth(),imageView.getHeight(),Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        paint.setColor(Color.BLACK);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        locationList.add(new Location(idCounter++,(double)motionEvent.getX(),(double)motionEvent.getY()));
                        canvas.drawCircle((int)motionEvent.getX(),(int)motionEvent.getY(),10,paint);
                        imageView.setImageBitmap(bitmap);
                        break;

                }

                return false;
            }
        });
    }



}