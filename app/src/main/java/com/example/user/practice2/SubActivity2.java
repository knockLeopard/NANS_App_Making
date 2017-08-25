package com.example.user.practice2;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.user.R;
import java.util.List;

/**
 * Created by user on 2017-08-24.
 */

public class SubActivity2 extends Activity {
    static SubActivity2 subActivity2;

    public static SubActivity2 getInstance(){
        return   subActivity2;
    }
    public static Context mContext;

    public static ImageView rotateImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subActivity2 = this;
        mContext = this;
        setContentView(R.layout.activity_sub2);


    }

    public void startRotatingImage(View view) {
        rotateImage = (ImageView) findViewById(R.id.rotate_image);
        Animation startRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.android_rotate_animation);
        rotateImage.startAnimation(startRotateAnimation);
    }

    public void startRotatingImageCounterClock(View view) {
        rotateImage = (ImageView) findViewById(R.id.rotate_image);
        Animation startRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.android_rotate_animation_counter_clock);
        rotateImage.startAnimation(startRotateAnimation);
    }

    public void onClick(View view){
        Intent intent = getIntent();
        String data = intent.getStringExtra("key");
        Toast.makeText(getApplicationContext(),data, Toast.LENGTH_LONG).show();

        ActivityManager am = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        int i = subActivity2.getTaskId();
        DisplayManager mDisplayManager = (DisplayManager)getSystemService(Context.DISPLAY_SERVICE);
        // enumerate the displays
        Display[] presentationDisplays = mDisplayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);
        am.setExternalDisplay(i, presentationDisplays[0], am.SET_EXTERNAL_DISPLAY_AND_STAY);
        moveTaskToBack(true);
    //    List<ActivityManager.RunningTaskInfo> Info = am.getRunningTasks(1);
    //    ComponentName topActivity = Info.get(0).topActivity;
    //    String name = topActivity.getPackageName();
      //  am.setExternalDisplay(data, ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay(), am.SET_EXTERNAL_DISPLAY_AND_GO_HOME);

        //finish();
    }


}
