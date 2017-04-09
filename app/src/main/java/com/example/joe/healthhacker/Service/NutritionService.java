package com.example.joe.healthhacker.Service;
import android.os.AsyncTask;

import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
/**
 * Created by Joe on 4/8/17.
 */

public class NutritionService {

    private NutritionServiceCallBack callback;
    private String upc;
    private Exception error;

    public NutritionService(NutritionServiceCallBack callback){
        this.callback = callback;
    }

    /*
    public String getupc() {
        return upc;
    }
    */
    public void refreshNutrition(String upcIn){
        this.upc = upcIn;
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground (String... strings){

                String endPoint = "https://api.nutritionix.com/v1_1/item?upc=" + strings[0] +"&appId=e2ab68f5&appKey=7afb2a33644d31940cf0fcfdd11b24de";
                try{
                    URL url = new URL(endPoint);

                    URLConnection connection = url.openConnection();

                    InputStream inputStream = connection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader (inputStream));
                    StringBuilder result = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        result.append(line);
                    }
                    return result.toString();
                } catch (Exception e){
                    error = e;
                }
                return null;
            }
            @Override
            protected void onPostExecute(String s){
                if (s == null && error != null){
                    callback.serviceFailure(error);
                    return;
                }

                try{
                    JSONObject data = new JSONObject(s);

                    //JSONObject queryResults = data.optJSONObject();

                    String[] itemInfo = {data.getString("item_name"), data.getString("item_description"), data.getString("nf_ingredient_statement")};

                    callback.serviceSuccess(itemInfo);

                } catch (JSONException e) {
                    callback.serviceFailure(e);
                }

            }
        }.execute(upc);
    }

    class NutritionException extends Exception{
        public NutritionException(String detailMessage){
            super(detailMessage);
        }
    }
}

