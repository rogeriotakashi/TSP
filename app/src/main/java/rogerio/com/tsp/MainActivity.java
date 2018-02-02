package rogerio.com.tsp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rogerio.com.tsp.Graph.Drawer;
import rogerio.com.tsp.Graph.Location;
import rogerio.com.tsp.Graph.Route;
import rogerio.com.tsp.Optimize.NearestNeighbourSearch;
import rogerio.com.tsp.Optimize.NearestNeighbourSearchAsyncTask;
import rogerio.com.tsp.Optimize.SimulatedAnnealing;
import rogerio.com.tsp.SavingsHeuristic.SavingsHeuristic;


public class MainActivity extends AppCompatActivity {


    //Painting
    private Bitmap bitmap;
    private Canvas canvas;
    private ImageView imageView;
    private Paint paint;
    private Drawer drawer;
    private Spinner optOptions;

    //Structure
    private ArrayList<Location> locationList;
    private int idCounter;

    //Buttons
    private Button btnRandom;
    private Button btnOptimize;
    private Button btnNearest;

    //TextView
    private TextView txtDistance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationList = new ArrayList<>();
        idCounter = 0;

        imageView = (ImageView) findViewById(R.id.imageView);
        btnOptimize = (Button) findViewById(R.id.btnOptimize);
        txtDistance = (TextView) findViewById(R.id.txtDistance);
        optOptions = (Spinner) findViewById(R.id.optOptions);

        paint = new Paint();
        paint.setColor(Color.BLACK);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.operation_array,android.R.layout.simple_list_item_1);
        optOptions.setAdapter(adapter);


        optOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                switch (selected){
                    case "Random":
                        btnOptimize.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                                Route route = new Route(locationList);
                                route.getRandomRoute();
                                drawer.drawRoute(route);
                                txtDistance.setText(route.cost()+"");
                            }
                        });
                        break;
                    case "Nearest Neighbour":
                        btnOptimize.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                                NearestNeighbourSearchAsyncTask optimizer = new NearestNeighbourSearchAsyncTask(MainActivity.this,txtDistance,drawer);
                                optimizer.execute(locationList);
                            }
                        });

                        break;
                    case "Simulated Annealing":
                        btnOptimize.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                                SimulatedAnnealing optimizer2 = new SimulatedAnnealing(locationList);
                                Route optimizedRoute = optimizer2.optimize();
                                drawer.drawRoute(optimizedRoute);
                                txtDistance.setText(optimizedRoute.cost()+"");
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Nothing
            }
        });


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        //Run just one time when app started
        if(idCounter == 0) {
            bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap);
            paint = new Paint();
            paint.setColor(Color.BLACK);
            drawer = new Drawer(canvas, paint);
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            locationList.add(new Location(idCounter++, (double) motionEvent.getX(), (double) motionEvent.getY()));
                            canvas.drawCircle((int) motionEvent.getX(), (int) motionEvent.getY(), 5, paint);
                            imageView.setImageBitmap(bitmap);
                            break;

                    }

                    return false;
                }
            });
        }
    }



}
