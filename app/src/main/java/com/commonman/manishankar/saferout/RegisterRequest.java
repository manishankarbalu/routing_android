package com.commonman.manishankar.saferout;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MANISHANKAR on 8/10/2016.
 */
public class RegisterRequest extends StringRequest {
    private static final String Register_URL="http://bmanik.bugs3.com/register.php";
    private Map<String,String> params;
    public RegisterRequest(String name,String user,String pas,int age,Response.Listener<String> listener){
        super(Method.POST,Register_URL,listener,null);
        params=new HashMap<>();
        params.put("name",name);
        params.put("username",user);
        params.put("password",pas);
        params.put("age",age+"");
        Log.d("rr", "reached register request");
        Log.d("reg name",name);
    }

    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}

