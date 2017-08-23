package com.example.user.practice1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by user on 2017-08-23.
 */

public class SubActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


    }
    public void onClick(View view){
        Intent intent = getIntent();
        String data = intent.getStringExtra("key");
        Toast.makeText(getApplicationContext(),data, Toast.LENGTH_LONG).show();
        //finish();
    }
}
