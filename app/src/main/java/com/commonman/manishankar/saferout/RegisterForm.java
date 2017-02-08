package com.commonman.manishankar.saferout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterForm extends AppCompatActivity {
    EditText name,user,pass,age;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        name=(EditText)findViewById(R.id.Name);
        user=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);
        age=(EditText)findViewById(R.id.age);
        reg=(Button)findViewById(R.id.regis);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=name.getText().toString();
                String username=user.getText().toString();
                String pas=pass.getText().toString();
                int ag=Integer.parseInt(age.getText().toString());

                Response.Listener<String> responselistener=new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject json=new JSONObject(response);
                            //   Toast.makeText(getApplicationContext(),"reached regester response",2002).show();
                            if(json.getBoolean("success")){
                                Intent i=new Intent(getApplicationContext(),LoginPage.class);
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

                Log.d("name",Name);Log.d("user",username);Log.d("pass",pas);
                //Toast.makeText(getApplicationContext(),"start regis part",2000).show();
                RegisterRequest rr=new RegisterRequest(Name,username,pas,ag,responselistener);
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(rr);
                //Toast.makeText(getApplicationContext(),"end of regis",2000);
            }
        });

    }
}

