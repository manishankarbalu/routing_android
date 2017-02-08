package com.commonman.manishankar.saferout;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.*;

/**
 * Created by MANISHANKAR on 8/31/2016.
 */
public class RegisterRequestInfo extends StringRequest {
    private static final String Register_URL="http://bmanik.bugs3.com/inforegis.php";
    private java.util.Map<String,String> params;
    public RegisterRequestInfo(Double lattitude,Double longitude,int crate,int lrate,int rrate,Response.Listener<String> listener){
        super(Method.POST,Register_URL,listener,null);
        params=new HashMap<>();
        params.put("lattitude",lattitude+"");
        params.put("longitude",longitude+"");
        params.put("crate",crate+"");
        params.put("lrate",lrate+"");
        params.put("rrate",rrate+"");
       // params.put("age",age+"");
        Log.d("rr", "reached register request");
       // Log.d("reg name",);
    }

    @Override
    public java.util.Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
