package com.example.user.practice1;

import android.app.Activity;
import 	android.os.Handler;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.user.R;
import com.example.user.practice2.SubActivity2;
import com.example.user.practice3.SubActivity1;

import java.util.List;

/**
 * Created by user on 2017-08-23.
 */

public class MainActivity extends Activity {
    Handler handler = new Handler(Looper.getMainLooper());

    static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView m = new MyView(MainActivity.this);
        setContentView(R.layout.main);
        LayoutInflater inflater = getLayoutInflater();
        addContentView(m, new LinearLayout.LayoutParams(1024, 600));
        // setContentView(m);


        Button button = (Button) findViewById(R.id.button);

        Button button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent1 = new Intent();
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        intent1.setComponent(new ComponentName("com.example.user.practice1", "com.example.user.practice3.SubActivity1"));
                        intent1.putExtra("key", "information");
                        startActivity(intent1);
                    }
                });

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent2 = new Intent();
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        intent2.setComponent(new ComponentName("com.example.user.practice1", "com.example.user.practice2.SubActivity2"));
                        intent2.putExtra("key", "information");
                        startActivity(intent2);
                    }
                });

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SubActivity1.getInstance().finish();
                SubActivity2.getInstance().finish();
                System.gc();

            }
        });
    }
}

class MyView extends View{
    public MyView(Context context){
        super(context);
    }
//    @Override

    // Display class의 method 사용 전체 코드
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setTextSize(20);
        p.setColor(Color.BLACK);

        Display display = ((WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
     //   Display display = presentationDisplays[0];
   //     Display display1 = presentationDisplays[1];
        int width = display.getWidth();
        int height = display.getHeight();

        canvas.drawText("getWidth() :"+String.valueOf(width), 0, 20, p);
        canvas.drawText("getHeight() :"+String.valueOf(height), 0, 40, p);

        canvas.drawText("getOrientation() :"+String.valueOf(display.getOrientation()), 0, 60, p);

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        canvas.drawText("DisplayMetrics.density :"+String.valueOf(metrics.density), 0, 80, p);
        canvas.drawText("DisplayMetrics.densityDpi :"+String.valueOf(metrics.densityDpi), 0, 100, p);
        canvas.drawText("DisplayMetrics.scaledDensity :"+String.valueOf(metrics.scaledDensity), 0, 120, p);
        canvas.drawText("DisplayMetrics.widthPixels :"+String.valueOf(metrics.widthPixels), 0, 140, p);
        canvas.drawText("DisplayMetrics.heightPixels :"+String.valueOf(metrics.heightPixels), 0, 160, p);
        canvas.drawText("DisplayMetrics.xdpi :"+String.valueOf(metrics.xdpi), 0, 180, p);
        canvas.drawText("DisplayMetrics.ydpi :"+String.valueOf(metrics.ydpi), 0, 200, p);
        canvas.drawText("DisplayMetrics.DENSITY_DEFAULT :"+String.valueOf(metrics.DENSITY_DEFAULT), 0, 220, p);
        canvas.drawText("DisplayMetrics.DENSITY_HIGH :"+String.valueOf(metrics.DENSITY_HIGH), 0, 240, p);
        canvas.drawText("DisplayMetrics.DENSITY_LOW :"+String.valueOf(metrics.DENSITY_LOW), 0, 260, p);
        canvas.drawText("DisplayMetrics.DENSITY_MEDIUM :"+String.valueOf(metrics.DENSITY_MEDIUM), 0, 280, p);

        canvas.drawText("getPixelFormat() :"+String.valueOf(display.getPixelFormat()), 0, 300, p);

        canvas.drawText("getRefreshRate() :"+String.valueOf(display.getRefreshRate()), 0, 320, p);

        canvas.drawText("getRotation() :"+String.valueOf(display.getRotation()), 0, 340, p);

        canvas.drawText("Display.DEFAULT_DISPLAY :"+String.valueOf(display.DEFAULT_DISPLAY), 0, 360, p);

        canvas.drawText("getDisplayId() :"+String.valueOf(display.getDisplayId()), 0, 380, p);

    }
}
