package com.commonman.manishankar.saferout;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by MANISHANKAR on 8/31/2016.
 */
public class BackgroundTask extends AsyncTask<Void,Dbinfo,Void> {
    final String MovieURL="http://bmanik.bugs3.com/dbmovlist.php";
    Context ctx;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Dbinfo> arrayList=new ArrayList<>();
    public BackgroundTask(Context ctx){
        this.ctx=ctx;
        this.activity=(Activity)ctx;
    }

    @Override
    protected void onPreExecute() {

        recyclerView=(RecyclerView)activity.findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(ctx);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        adapter=new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Dbinfo... values) {
        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url=new URL(MovieURL);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();
            String line="";
            while((line=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line+"\n");
            }
            httpURLConnection.disconnect();
            String jsonstring=stringBuilder.toString().trim();
            JSONObject jsonObject=new JSONObject(jsonstring);
            JSONArray jsonArray=jsonObject.getJSONArray("server_response");
            int count=0;
            while(count<jsonArray.length()){

                JSONObject jo=jsonArray.getJSONObject(count);
                count++;

                Dbinfo m=new Dbinfo(jo.getString("name"),jo.getDouble("lat"),jo.getDouble("lon"),jo.getInt("c"),jo.getInt("l"),jo.getInt("r"));
                publishProgress(m);
            }



            Log.d("url",stringBuilder.toString().trim());
        } catch (MalformedURLException m){
            m.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
