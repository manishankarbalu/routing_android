package com.commonman.manishankar.saferout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class listinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listinfo);
        BackgroundTask backgroundTask=new BackgroundTask(listinfo.this);
        backgroundTask.execute();
    }
}
