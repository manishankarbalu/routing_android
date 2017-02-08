package com.commonman.manishankar.saferout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPage extends AppCompatActivity {
    EditText user,pass;
    Button lgin,regi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pass);
        lgin=(Button)findViewById(R.id.btlogin);
        regi=(Button)findViewById(R.id.register);
        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),RegisterForm.class);
                startActivity(i);

            }
        });


        lgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nme=user.getText().toString();
                String ps=pass.getText().toString();
//                Toast.makeText(getApplicationContext(),"reached login part",2000).show();
                Response.Listener<String> listner =new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonres=new JSONObject(response);
                            //                          Toast.makeText(getApplicationContext(),"reached loginresponse part",2000).show();
                            if(jsonres.getBoolean("success")){

<<<<<<< HEAD
                                Intent i=new Intent(getApplicationContext(),IntroScrene.class);
=======
                                Intent i=new Intent(getApplicationContext(),Map.class);
>>>>>>> 49f78d47ba8264700e1ec11757c5d8ed5c3387ad
                                startActivity(i);


                            }else{
                                //                            Toast.makeText(getApplicationContext(),"login failed",2000).show();
                                // AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
                                //       builder.setMessage("Invalid login credentials").setNegativeButton("retry",null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };

                //       Toast.makeText(getApplicationContext(),"login req obj",2000).show();
                LoginRequest lg=new LoginRequest(nme,ps,listner);
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(lg);
            }
        });

    }
}
