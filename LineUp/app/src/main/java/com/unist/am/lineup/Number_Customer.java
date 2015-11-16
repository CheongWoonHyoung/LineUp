package com.unist.am.lineup;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by JeonghyunLee on 2015-09-25.
 */
public class Number_Customer extends Dialog {

    ImageView btn1;
    ImageView btn2;
    ImageView btn3;
    ImageView btn4;
    ImageView btn5;
    ImageView btn6;
    int Table_id;
    int No=0;
    ArrayList<Integer> table_list;
    ArrayList<String> table_time_list;
    public Number_Customer(Context context) {
        super(context);
    }
    public Number_Customer(Context context, ArrayList<Integer> list, ArrayList<String> times) {
        super(context);
        table_list = list;
        table_time_list= times;
    }


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        setContentView(R.layout.table_sit);


        btn1 = (ImageView) findViewById(R.id.selection_1_table);
        btn2 = (ImageView) findViewById(R.id.selection_2_table);
        btn3 = (ImageView) findViewById(R.id.selection_3_table);
        btn4 = (ImageView) findViewById(R.id.selection_4_table);
        btn5 = (ImageView) findViewById(R.id.selection_5_table);
        btn6 = (ImageView) findViewById(R.id.selection_6_table);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                No = 1;
                new HttpPostRequest().execute("");
                cancel();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                No = 2;
                new HttpPostRequest().execute("");
                cancel();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                No = 3;
                new HttpPostRequest().execute("");
                cancel();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                No = 4;
                new HttpPostRequest().execute("");
                cancel();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                No = 5;
                new HttpPostRequest().execute("");
                cancel();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                No = 6;
                new HttpPostRequest().execute("");
                cancel();
            }
        });



    }
    public class HttpPostRequest extends AsyncTask<String,Void,String> {
        String sResult="error99";
        @Override
        protected String doInBackground(String... info) {
            URL url = null;
            try {
                url = new URL("http://52.69.163.43/queuing/all_table_management.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                Log.e("Http connection", "완료");
                conn.setRequestMethod("POST");
                String post_value = "";
                for(int i = 0 ; i < table_list.size(); i++) {

                    String body = "resname=" + "sample&type=1&table_id=" + String.valueOf(table_list.get(i)) + "&start_time="+ String.valueOf(table_time_list.get(i));
                    Log.e("body",body);
                    OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                    osw.write(body);
                    osw.flush();
                    Log.e("Http connection2", "완료");
                }
                /*
                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuilder builder = new StringBuilder();
                Log.e("InputStreamReader","완료");

                String str;
                while ((str = reader.readLine()) != null) {
                    builder.append(str);
                }
                sResult = builder.toString();
                Log.e(sResult,"완료");
                */
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(e.toString(),sResult);
            }


            return sResult;
        }
        @Override
        protected void onPostExecute(String result){
            Log.e("RESULT", result);
            /*
            String jsonall = result;
            JSONArray jArray = null;

            try{
                jArray = new JSONArray(jsonall);
                JSONObject json_data = null;

                for (int i = 0; i < jArray.length(); i++) {
                    json_data = jArray.getJSONObject(i);
                    name = json_data.getString("food_name");
                    price = json_data.getInt("price");

                    items.add(new Res_menu_item(name,price));
                    Log.e("PROFILE",":"+i);

                }
            }catch(Exception e){
                e.printStackTrace();
            }
            mlist.setAdapter(adapter);

*/



        }
    }

}
