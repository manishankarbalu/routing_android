package com.commonman.manishankar.saferout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Info extends AppCompatActivity {
    CheckBox crime;
    CheckBox light;
    CheckBox road;
    Button submit;
    Spinner crs;
    Spinner ls;
    Spinner rs;
    TextView pos;
    int crate,lrate,rrate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent i=getIntent();
        final Double lattitude=i.getDoubleExtra("lat",0.0);
        final Double longitude=i.getDoubleExtra("lon",0.0);
        crime=(CheckBox)findViewById(R.id.cr);
        light=(CheckBox)findViewById(R.id.l);
        road=(CheckBox)findViewById(R.id.rc);
        submit=(Button)findViewById(R.id.submit);
        crs=(Spinner)findViewById(R.id.crs);
        rs=(Spinner)findViewById(R.id.rs);
        ls=(Spinner)findViewById(R.id.ls);
        pos=(TextView)findViewById(R.id.pos);
        String s=Double.toString(lattitude)+" , "+Double.toString(longitude);
        pos.setText(s);
        List<Integer> level=new ArrayList<Integer>();
        level.add(1);
        level.add(2);
        level.add(3);
        level.add(4);
        level.add(5);
        ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,level);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crs.setAdapter(arrayAdapter);
        rs.setAdapter(arrayAdapter);
        ls.setAdapter(arrayAdapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(crime.isChecked()) crate=Integer.parseInt(crs.getSelectedItem().toString());
                if(light.isChecked()) lrate=Integer.parseInt(ls.getSelectedItem().toString());
                if(road.isChecked()) rrate=Integer.parseInt(rs.getSelectedItem().toString());
                Log.d("criem",Integer.toString(crate));
                Log.d("lig",Integer.toString(lrate));
                Log.d("rod",Integer.toString(rrate));
                Response.Listener<String> responselistener=new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject json=new JSONObject(response);
                            //   Toast.makeText(getApplicationContext(),"reached regester response",2002).show();
                            if(json.getBoolean("success")){
                                Intent i=new Intent(getApplicationContext(),IntroScrene.class);
                                startActivity(i);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "cannot register", Toast.LENGTH_SHORT).show();
                                // Builder builder=new Builder(getApplicationContext());
                                //builder.setMessage("Registration failed").setNegativeButton("retry",null).create().show();
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

               // Log.d("name",Name);Log.d("user",username);Log.d("pass",pas);
                //Toast.makeText(getApplicationContext(),"start regis part",2000).show();
                RegisterRequestInfo rr=new RegisterRequestInfo(lattitude,longitude,crate,lrate,rrate,responselistener);
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(rr);
            }
        });

    }
}
