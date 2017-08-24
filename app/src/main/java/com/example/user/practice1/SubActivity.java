package com.example.user.practice1;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Toast;
import com.example.user.R;

import java.util.List;

/**
 * Created by user on 2017-08-23.
 */




public class SubActivity extends Activity{
    static SubActivity subActivity;

    public static SubActivity getInstance(){
        return   subActivity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subActivity = this;
        moveTaskToBack(true);
        setContentView(R.layout.activity_sub);

        ActivityManager am = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> Info = am.getRunningTasks(1);
        ComponentName topActivity = Info.get(0).topActivity;
        String name = topActivity.getPackageName();

        DisplayManager mDisplayManager = (DisplayManager)getSystemService(Context.DISPLAY_SERVICE);
        // enumerate the displays
        Display[] presentationDisplays = mDisplayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);
        //    ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        am.setExternalDisplay(name, presentationDisplays[1], am.SET_EXTERNAL_DISPLAY_AND_STAY);





    }
    public void onClick(View view){
        Intent intent = getIntent();
        String data = intent.getStringExtra("key");
        Toast.makeText(getApplicationContext(),data, Toast.LENGTH_LONG).show();
        //finish();
    }
}
