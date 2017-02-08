package com.commonman.manishankar.saferout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroScrene extends AppCompatActivity {

    Button info;
    Button dir;
    Button db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screne);
        info=(Button)findViewById(R.id.giveinfo);
        dir=(Button)findViewById(R.id.direction);
        db=(Button)findViewById(R.id.db);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),InfoMap.class);
                startActivity(i);
            }
        });
        dir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Map.class);
                startActivity(i);
            }
        });
        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),listinfo.class);
                startActivity(i);
            }
        });
    }
}
