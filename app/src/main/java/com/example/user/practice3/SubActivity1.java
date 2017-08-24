package com.example.user.practice3;

/**
 * Created by user on 2017-08-25.
 */
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Toast;

import com.example.user.R;

import java.util.List;

/**
 * Created by user on 2017-08-24.
 */

public class SubActivity1 extends Activity {
    static SubActivity1 subActivity1;

    public static SubActivity1 getInstance(){
        return   subActivity1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subActivity1 = this;
        setContentView(R.layout.activity_sub);
        ActivityManager am = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);

        int i = subActivity1.getTaskId();
        DisplayManager mDisplayManager = (DisplayManager)getSystemService(Context.DISPLAY_SERVICE);
        // enumerate the displays
        Display[] presentationDisplays = mDisplayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);



    }

    public void onClick(View view){
        Intent intent = getIntent();
        String data = intent.getStringExtra("key");
        Toast.makeText(getApplicationContext(),data, Toast.LENGTH_LONG).show();

        ActivityManager am = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        int i = subActivity1.getTaskId();
        DisplayManager mDisplayManager = (DisplayManager)getSystemService(Context.DISPLAY_SERVICE);
        // enumerate the displays
        Display[] presentationDisplays = mDisplayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);
        am.setExternalDisplay(i, presentationDisplays[1], am.SET_EXTERNAL_DISPLAY_AND_STAY);
        moveTaskToBack(true);

    }


}
