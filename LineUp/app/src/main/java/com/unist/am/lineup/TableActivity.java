/**
 * Copyright 2014 Daum Kakao Corp.
 *
 * Redistribution and modification in source or binary forms are not permitted without specific prior written permission. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.unist.am.lineup;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 유효한 세션이 있다는 검증 후
 * me를 호출하여 가입 여부에 따라 가입 페이지를 그리던지 Main 페이지로 이동 시킨다.
 */

public class TableActivity extends Activity {

    private Context mcontext;
    private TextView table1_1;
    private TextView table1_2;
    private TextView table2_1;
    private TextView table2_2;
    private TextView table3_1;
    private TextView table3_2;
    private TextView table4_1;
    private TextView table4_2;
    private TextView table5_1;
    private TextView table5_2;
    private TextView table6_1;
    private TextView table6_2;
    private TextView table7_1;
    private TextView table7_2;
    private TextView table8_1;
    private TextView table8_2;

    private FrameLayout tb1_1;
    private FrameLayout tb1_2;
    private FrameLayout tb2_1;
    private FrameLayout tb2_2;
    private FrameLayout tb3_1;
    private FrameLayout tb3_2;
    private FrameLayout tb4_1;
    private FrameLayout tb4_2;
    private FrameLayout tb5_1;
    private FrameLayout tb5_2;
    private FrameLayout tb6_1;
    private FrameLayout tb6_2;
    private FrameLayout tb7_1;
    private FrameLayout tb7_2;
    private FrameLayout tb8_1;
    private FrameLayout tb8_2;

    private RelativeLayout tb1;
    private RelativeLayout tb2;
    private RelativeLayout tb3;
    private RelativeLayout tb4;
    private RelativeLayout tb5;
    private RelativeLayout tb6;
    private RelativeLayout tb7;
    private RelativeLayout tb8;

    TextView Sit;
    TextView Out;
    TextView Go_to_List;

// 그냥 state는 가게단에서 하는 state변경값들 저장
    
    //비어있을 떄 off
    static String state1 = "off";
    static String state2 = "off";
    static String state3 = "off";
    static String state4 = "off";
    static String state5 = "off";
    static String state6 = "off";
    static String state7 = "off";
    static String state8 = "off";


// _2 state는 서버에서 가져와 맨처음 앱 실행시 사용
    static String state1_2 = null;
    static String state2_2 = null;
    static String state3_2 = null;
    static String state4_2 = null;
    static String state5_2 = null;
    static String state6_2 = null;
    static String state7_2 = null;
    static String state8_2 = null;
    static String state_check = null;


    long table1_start =0;
    long table1_end = 0;
    long table2_start =0;
    long table2_end = 0;
    long table3_start =0;
    long table3_end = 0;
    long table4_start =0;
    long table4_end = 0;
    long table5_start =0;
    long table5_end = 0;
    long table6_start =0;
    long table6_end = 0;
    long table7_start =0;
    long table7_end = 0;
    long table8_start =0;
    long table8_end = 0;
    long table9_start =0;
    long table9_end = 0;
    long table10_start =0;
    long table10_end = 0;
    long table11_start =0;
    long table11_end = 0;
    long table12_start =0;
    long table12_end = 0;
    long table13_start =0;
    long table13_end = 0;
    long table14_start =0;
    long table14_end = 0;
    long table15_start =0;
    long table15_end = 0;

// from_server 서버에서 받는 테이블이 켜졌을 때의 시간
    long table1_start_from_server = 0;
    long table2_start_from_server = 0;
    long table3_start_from_server = 0;
    long table4_start_from_server = 0;
    long table5_start_from_server = 0;
    long table6_start_from_server = 0;
    long table7_start_from_server = 0;
    long table8_start_from_server = 0;

    static Button check;

    int checkBtn_color;
    Number_Customer mdialog;

    ArrayList<String> num_people = null;
    ArrayList<String> start_time = null;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Context mcontext = this;
        try {
            DBManager_table db_manager = new DBManager_table(mcontext, "table_info", null, 1);
            num_people = db_manager.returnNum();
            start_time = db_manager.returnTime();
        }
        catch (Exception e){
            Log.e("DB",e.toString());
        }
        /*
manager = new DBManager_reserv(context, "reserv_info.db", null, 1);
        서버에서 시작시간과 stete 로드하여 각각 start_from_server 와 state_2에 저장

         */
        setContentView(R.layout.owner_table);
   //     setContentView(R.layout.table_management);

        table1_1 = (TextView) findViewById(R.id.tb1_txt1);
        table1_2 = (TextView) findViewById(R.id.tb1_txt2);
        table2_1 = (TextView) findViewById(R.id.tb2_txt1);
        table2_2 = (TextView) findViewById(R.id.tb2_txt2);
        table3_1 = (TextView) findViewById(R.id.tb3_txt1);
        table3_2 = (TextView) findViewById(R.id.tb3_txt2);
        table4_1 = (TextView) findViewById(R.id.tb4_txt1);
        table4_2 = (TextView) findViewById(R.id.tb4_txt2);
        table5_1 = (TextView) findViewById(R.id.tb5_txt1);
        table5_2 = (TextView) findViewById(R.id.tb5_txt2);
        table6_1 = (TextView) findViewById(R.id.tb6_txt1);
        table6_2 = (TextView) findViewById(R.id.tb6_txt2);
        table7_1 = (TextView) findViewById(R.id.tb7_txt1);
        table7_2 = (TextView) findViewById(R.id.tb7_txt2);
        table8_1 = (TextView) findViewById(R.id.tb8_txt1);
        table8_2 = (TextView) findViewById(R.id.tb8_txt2);

        tb1_1 = (FrameLayout) findViewById(R.id.tb1_box1);
        tb1_2 = (FrameLayout) findViewById(R.id.tb1_box2);
        tb2_1 = (FrameLayout) findViewById(R.id.tb2_box1);
        tb2_2 = (FrameLayout) findViewById(R.id.tb2_box2);
        tb3_1 = (FrameLayout) findViewById(R.id.tb5_box1);
        tb3_2 = (FrameLayout) findViewById(R.id.tb5_box2);
        tb4_1 = (FrameLayout) findViewById(R.id.tb6_box1);
        tb4_2 = (FrameLayout) findViewById(R.id.tb6_box2);
        tb5_1 = (FrameLayout) findViewById(R.id.tb9_box1);
        tb5_2 = (FrameLayout) findViewById(R.id.tb9_box2);
        tb6_1 = (FrameLayout) findViewById(R.id.tb10_box1);
        tb6_2 = (FrameLayout) findViewById(R.id.tb10_box2);
        tb7_1 = (FrameLayout) findViewById(R.id.tb13_box1);
        tb7_2 = (FrameLayout) findViewById(R.id.tb13_box2);
        tb8_1 = (FrameLayout) findViewById(R.id.tb14_box1);
        tb8_2 = (FrameLayout) findViewById(R.id.tb14_box2);

        Sit = (TextView) findViewById(R.id.sit_table);
        Out = (TextView)findViewById(R.id.out_table);
        Go_to_List = (TextView) findViewById(R.id.list_table);

        tb1 =(RelativeLayout) findViewById(R.id.tb1);
        tb2 =(RelativeLayout) findViewById(R.id.tb2);
        tb3 =(RelativeLayout) findViewById(R.id.tb5);
        tb4 =(RelativeLayout) findViewById(R.id.tb6);
        tb5 =(RelativeLayout) findViewById(R.id.tb9);
        tb6 =(RelativeLayout) findViewById(R.id.tb10);
        tb7 =(RelativeLayout) findViewById(R.id.tb13);
        tb8 =(RelativeLayout) findViewById(R.id.tb14);


        for(int i = 0; i < num_people.size(); i++){
            if(num_people.get(i) != "0"){
                switch (i){
                    case 0:
                        tb1_1.setVisibility(View.VISIBLE);
                        tb1_2.setVisibility(View.VISIBLE);
                        table1_1.setText(num_people.get(i));
                        table1_2.setText(getDate(String.valueOf(start_time.get(i))));
                        break;
                    case 1:
                        tb2_1.setVisibility(View.VISIBLE);
                        tb2_2.setVisibility(View.VISIBLE);
                        table2_1.setText(num_people.get(i));
                        table2_2.setText(getDate(String.valueOf(start_time.get(i))));
                        break;
                    case 2:
                        tb3_1.setVisibility(View.VISIBLE);
                        tb3_2.setVisibility(View.VISIBLE);
                        table3_1.setText(num_people.get(i));
                        table3_2.setText(getDate(String.valueOf(start_time.get(i))));
                        break;
                    case 3:
                        tb4_1.setVisibility(View.VISIBLE);
                        tb4_2.setVisibility(View.VISIBLE);
                        table4_1.setText(num_people.get(i));
                        table4_2.setText(getDate(String.valueOf(start_time.get(i))));
                        break;
                    case 4:
                        tb5_1.setVisibility(View.VISIBLE);
                        tb5_2.setVisibility(View.VISIBLE);
                        table5_1.setText(num_people.get(i));
                        table5_2.setText(getDate(String.valueOf(start_time.get(i))));
                        break;
                    case 5:
                        tb6_1.setVisibility(View.VISIBLE);
                        tb6_2.setVisibility(View.VISIBLE);
                        table6_1.setText(num_people.get(i));
                        table6_2.setText(getDate(String.valueOf(start_time.get(i))));
                        break;
                    case 6:
                        tb7_1.setVisibility(View.VISIBLE);
                        tb7_2.setVisibility(View.VISIBLE);
                        table7_1.setText(num_people.get(i));
                        table7_2.setText(getDate(String.valueOf(start_time.get(i))));
                        break;
                    case 7:
                        tb8_1.setVisibility(View.VISIBLE);
                        tb8_2.setVisibility(View.VISIBLE);
                        table8_1.setText(num_people.get(i));
                        table8_2.setText(getDate(String.valueOf(start_time.get(i))));
                        break;
                }

            }
        }

        Sit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Out.setEnabled(false);
                Go_to_List.setEnabled(false);
                tb1.setOnClickListener(new Click(1,true));
                tb2.setOnClickListener(new Click(2,true));
                tb3.setOnClickListener(new Click(3,true));
                tb4.setOnClickListener(new Click(4,true));
                tb5.setOnClickListener(new Click(5,true));
                tb6.setOnClickListener(new Click(6,true));
                tb7.setOnClickListener(new Click(7,true));
                tb8.setOnClickListener(new Click(8,true));

            }
        });
        mcontext = this;

   //     mdialog.setCancelable(false);
        mdialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });
        mdialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if(mdialog.No != 0){
                    switch (mdialog.Table_id){
                        case 1:
                            table1_1.setText(String.valueOf(mdialog.No));
                            table1_2.setText(getDate(String.valueOf(table1_start)));

                            break;

                        case 2:
                            table2_1.setText(String.valueOf(mdialog.No));
                            table2_2.setText(getDate(String.valueOf(table2_start)));
                            break;

                        case 3:
                            table3_1.setText(String.valueOf(mdialog.No));
                            table3_2.setText(getDate(String.valueOf(table3_start)));
                            break;

                        case 4:
                            table4_1.setText(String.valueOf(mdialog.No));
                            table4_2.setText(getDate(String.valueOf(table4_start)));
                            break;

                        case 5:
                            table5_1.setText(String.valueOf(mdialog.No));
                            table5_2.setText(getDate(String.valueOf(table5_start)));;
                            break;
                        case  6:
                            table6_1.setText(String.valueOf(mdialog.No));
                            table6_2.setText(getDate(String.valueOf(table6_start)));
                            break;
                        case 7:
                            table7_1.setText(String.valueOf(mdialog.No));
                            table7_2.setText(getDate(String.valueOf(table7_start)));
                            break;
                        case 8:
                            table8_1.setText(String.valueOf(mdialog.No));
                            table8_2.setText(getDate(String.valueOf(table8_start)));
                            break;
                    }
                }
            }
        });

    }

    public class Click implements OnClickListener {

        int mtype;
        Boolean TF;
        Click(int type, Boolean sit_out){
            TF = sit_out;
            mtype = type;
        }

        @Override
        public void onClick(View v) {
            switch(mtype){

                case 1:
                    if(state1 == "off" && TF) {
                        table1_start = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box_selected);
                        state1 = "on";
                        mdialog = new Number_Customer(mcontext, mtype);
                    }
                    else{
                        if(!TF) {
                            table1_end = System.currentTimeMillis();
                            v.setBackgroundResource(R.drawable.round_box);
                            state1 = "off";
                            tb1_1.setVisibility(View.INVISIBLE);
                            tb1_2.setVisibility(View.INVISIBLE);
                        }
                    }
                    break;
                case 2:
                    if(state2 == "off" && TF) {
                        table2_start = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box_selected);
                        state2 = "on";
                        mdialog = new Number_Customer(mcontext, mtype);
                    }
                    else{
                        table2_end = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box);
                        state2 = "off";

                    }

                    break;
                case 3:
                    if(state3 == "off" && TF) {
                        table3_start = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box_selected);
                        state3 = "on";
                        mdialog = new Number_Customer(mcontext, mtype);
                    }
                    else{
                        table3_end = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box);
                        state3 = "off";

                    }

                    break;
                case 4:
                    if(state4 == "off" &&TF) {
                        table4_start = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box_selected);
                        state4 = "on";
                        mdialog = new Number_Customer(mcontext, mtype);
                    }
                    else{
                        table4_end = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box);
                        state4 = "off";

                    }

                    break;
                case 5:
                    if(state5 == "off" && TF) {
                        table5_start = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box_selected);
                        state5 = "on";
                        mdialog = new Number_Customer(mcontext, mtype);
                    }
                    else{
                        table5_end = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box);
                        state5 = "off";
                    }
                    break;
                case 6:
                    if(state6 == "off" &&TF) {
                        table6_start = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box_selected);
                        state6 = "on";
                        mdialog = new Number_Customer(mcontext, mtype);
                    }
                    else{
                        table6_end = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box);
                        state6 = "off";

                    }

                    break;
                case 7:
                    if(state7 == "off" &&TF) {
                        table7_start = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box_selected);
                        state7 = "on";
                        mdialog = new Number_Customer(mcontext, mtype);
                    }
                    else{
                        table7_end = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box);
                        state7 = "off";

                    }

                    break;
                case 8:
                    if(state8 == "off" &&TF) {
                        table8_start = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box_selected);
                        state8 = "on";
                        mdialog = new Number_Customer(mcontext, mtype);
                    }
                    else{
                        table8_end = System.currentTimeMillis();
                        v.setBackgroundResource(R.drawable.round_box);
                        state8 = "off";
                    }

                    break;
              
            }


        }


    }
    String getDate(String times){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.US);

        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("US/Central"));
        calendar.setTimeInMillis(Long.valueOf(times));

        return sdf.format(calendar.getTime());
    }


}
