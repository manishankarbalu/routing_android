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
public class LoginRequest extends StringRequest{    public final static String LoginURL="http://bmanik.bugs3.com/login.php";
    private Map<String,String> params;
    public LoginRequest(String name,String pass,Response.Listener<String> listener){
        super(Method.POST,LoginURL,listener,null);
        params=new HashMap<>();
        params.put("name",name);
        params.put("pas", pass);
        Log.d("lr","reached login request");

    }

    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}

