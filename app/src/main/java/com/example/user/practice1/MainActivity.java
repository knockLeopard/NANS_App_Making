package com.example.user.practice1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by user on 2017-08-23.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button=(Button)findViewById(R.id.button);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hellow Android!!", Toast.LENGTH_LONG).show();
            }
        });*/



    }
    public void onClick(View view)
    {
        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra("key", "information");
        startActivity(intent);
    }
}
