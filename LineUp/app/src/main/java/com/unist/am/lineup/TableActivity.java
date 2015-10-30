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
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 유효한 세션이 있다는 검증 후
 * me를 호출하여 가입 여부에 따라 가입 페이지를 그리던지 Main 페이지로 이동 시킨다.
 */

public class TableActivity extends Activity {

    private Context mcontext;
    private TextView table1;
    private TextView table2;
    private TextView table3;
    private TextView table4;
    private TextView table5;
    private TextView table6;
    private TextView table7;
    private TextView table8;
    private TextView table9;
    private TextView table10;
    private TextView table11;
    private TextView table12;
    private TextView table13;
    private TextView table14;
    private TextView table15;

// 그냥 state는 가게단에서 하는 state변경값들 저장
    static Boolean state1 = false;
    static Boolean state2 = false;
    static Boolean state3 = false;
    static Boolean state4 = false;
    static Boolean state5 = false;
    static Boolean state6 = false;
    static Boolean state7 = false;
    static Boolean state8 = false;
    static Boolean state9 = false;
    static Boolean state10 = false;
    static Boolean state11 = false;
    static Boolean state12 = false;
    static Boolean state13 = false;
    static Boolean state14 = false;
    static Boolean state15 = false;


// _2 state는 서버에서 가져와 맨처음 앱 실행시 사용
    static Boolean state1_2 = false;
    static Boolean state2_2 = false;
    static Boolean state3_2 = false;
    static Boolean state4_2 = false;
    static Boolean state5_2 = false;
    static Boolean state6_2 = false;
    static Boolean state7_2 = false;
    static Boolean state8_2 = false;
    static Boolean state9_2 = false;
    static Boolean state10_2 = false;
    static Boolean state11_2 = false;
    static Boolean state12_2 = false;
    static Boolean state13_2 = false;
    static Boolean state14_2 = false;
    static Boolean state15_2 = false;
    static Boolean state_check = false;


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
    long table9_start_from_server = 0;
    long table10_start_from_server = 0;
    long table11_start_from_server = 0;
    long table12_start_from_server = 0;
    long table13_start_from_server = 0;
    long table14_start_from_server = 0;
    long table15_start_from_server = 0;

    static Button check;

    int checkBtn_color;
    Number_Customer mdialog;
    Check_system mSystem;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        /*

        서버에서 시작시간과 stete 로드하여 각각 start_from_server 와 state_2에 저장

         */






        setContentView(R.layout.table_grandmother);

   //     setContentView(R.layout.table_management);

        table1 = (TextView) findViewById(R.id.tb1);
        table2 = (TextView) findViewById(R.id.tb2);
        table3 = (TextView) findViewById(R.id.tb3);
        table4 = (TextView) findViewById(R.id.tb4);
        table5 = (TextView) findViewById(R.id.tb5);
        table6 = (TextView) findViewById(R.id.tb6);
        table7 = (TextView) findViewById(R.id.tb7);
        table8 = (TextView) findViewById(R.id.tb8);
        table9 = (TextView) findViewById(R.id.tb9);
        table10 = (TextView) findViewById(R.id.tb10);
        table11 = (TextView) findViewById(R.id.tb11);
        table12 = (TextView) findViewById(R.id.tb12);
        table13 = (TextView) findViewById(R.id.tb13);
        table14 = (TextView) findViewById(R.id.tb14);
        table15 = (TextView) findViewById(R.id.tb15);

        table1.setBackgroundResource(android.R.color.white);
        table2.setBackgroundResource(android.R.color.white);
        table3.setBackgroundResource(android.R.color.white);
        table4.setBackgroundResource(android.R.color.white);
        table5.setBackgroundResource(android.R.color.white);
        table6.setBackgroundResource(android.R.color.white);
        table7.setBackgroundResource(android.R.color.white);
        table8.setBackgroundResource(android.R.color.white);
        table9.setBackgroundResource(android.R.color.white);
        table10.setBackgroundResource(android.R.color.white);
        table11.setBackgroundResource(android.R.color.white);
        table12.setBackgroundResource(android.R.color.white);
        table13.setBackgroundResource(android.R.color.white);
        table14.setBackgroundResource(android.R.color.white);
        table15.setBackgroundResource(android.R.color.white);

        if(state1_2)
            table1.setBackgroundResource(android.R.color.black);
        if(state2_2)
            table2.setBackgroundResource(android.R.color.black);
        if(state3_2)
            table3.setBackgroundResource(android.R.color.black);
        if(state4_2)
            table4.setBackgroundResource(android.R.color.black);
        if(state5_2)
            table5.setBackgroundResource(android.R.color.black);
        if(state6_2)
            table6.setBackgroundResource(android.R.color.black);
        if(state7_2)
            table7.setBackgroundResource(android.R.color.black);
        if(state8_2)
            table8.setBackgroundResource(android.R.color.black);
        if(state9_2)
            table9.setBackgroundResource(android.R.color.black);
        if(state10_2)
            table10.setBackgroundResource(android.R.color.black);
        if(state11_2)
            table11.setBackgroundResource(android.R.color.black);
        if(state12_2)
            table12.setBackgroundResource(android.R.color.black);
        if(state13_2)
            table13.setBackgroundResource(android.R.color.black);
        if(state14_2)
            table14.setBackgroundResource(android.R.color.black);
        if(state15_2)
            table15.setBackgroundResource(android.R.color.black);

        state1 = state1_2;
        state2 = state2_2;
        state3 = state3_2;
        state4 = state4_2;
        state5 = state5_2;
        state6 = state6_2;
        state7 = state7_2;
        state8 = state8_2;
        state9 = state9_2;
        state10 = state10_2;
        state11 = state11_2;
        state12 = state12_2;
        state13 = state13_2;
        state14 = state14_2;
        state15 = state15_2;

        table1.setOnClickListener(new Click(1));
        table2.setOnClickListener(new Click(2));
        table3.setOnClickListener(new Click(3));
        table4.setOnClickListener(new Click(4));
        table5.setOnClickListener(new Click(5));
        table6.setOnClickListener(new Click(6));
        table7.setOnClickListener(new Click(7));
        table8.setOnClickListener(new Click(8));
        table9.setOnClickListener(new Click(9));
        table10.setOnClickListener(new Click(10));
        table11.setOnClickListener(new Click(11));
        table12.setOnClickListener(new Click(12));
        table13.setOnClickListener(new Click(13));
        table14.setOnClickListener(new Click(14));
        table15.setOnClickListener(new Click(15));

        check = (Button) findViewById(R.id.checkBtn);
        mcontext = this;
        mdialog = new Number_Customer(this);
   //     mdialog.setCancelable(false);
        mdialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });
        mdialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if(mdialog.No != 0)
                Toast.makeText(mcontext, "People on a table: " + String.valueOf(mdialog.No), Toast.LENGTH_LONG).show();
            }
        });

        check.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state_check){
                    mdialog.show();
                }
            }
        });

        mSystem = new Check_system();


    }
    public class Check_system{

        public void Checking(){
                if(state1 != state1_2
                        || state2 != state2_2
                        ||state3 != state3_2
                        ||state4 != state4_2
                        ||state5 != state5_2
                        ||state6 != state6_2
                        ||state7!= state7_2
                        ||state8 != state8_2
                        ||state9 != state9_2
                        ||state10 != state10_2
                        ||state11 != state11_2
                        ||state12 != state12_2
                        ||state13 != state13_2
                        ||state14 != state14_2
                        ||state15 != state15_2){

                        check.setBackgroundColor(Color.parseColor("#ffff2121"));
                        state_check = true;
                    }
                    else{
                        check.setBackgroundColor(Color.parseColor("#44ff2121"));
                        state_check = false;
                    }

        }
    }
    public class Click implements OnClickListener {

        int mtype;

        Click(int type){

            mtype = type;
        }

        @Override
        public void onClick(View v) {
            switch(mtype){

                case 1:
                    if(!state1) {
                        table1_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state1 = true;
                        mSystem.Checking();
                    }
                    else{
                        table1_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state1 = false;
                        mSystem.Checking();
                    }
                    break;
                case 2:
                    if(!state2) {
                        table2_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state2 = true;
                        mSystem.Checking();
                    }
                    else{
                        table2_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state2 = false;
                        mSystem.Checking();

                    }

                    break;
                case 3:
                    if(!state3) {
                        table3_start = System.currentTimeMillis();

                        v.setBackgroundResource(android.R.color.black);
                        state3 = true;
                        mSystem.Checking();
                    }
                    else{
                        table3_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state3 = false;
                        mSystem.Checking();

                    }

                    break;
                case 4:
                    if(!state4) {
                        table4_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state4 = true;
                        mSystem.Checking();
                    }
                    else{
                        table4_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state4 = false;
                        mSystem.Checking();

                    }

                    break;
                case 5:
                    if(!state5) {
                        table5_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state5 = true;
                        mSystem.Checking();
                    }
                    else{
                        table5_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state5 = false;
                        mSystem.Checking();
                    }
                    break;
                case 6:
                    if(!state6) {
                        table6_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state6 = true;
                        mSystem.Checking();
                    }
                    else{
                        table6_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state6 = false;
                        mSystem.Checking();

                    }

                    break;
                case 7:
                    if(!state7) {
                        table7_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state7 = true;
                        mSystem.Checking();
                    }
                    else{
                        table7_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state7 = false;
                        mSystem.Checking();

                    }

                    break;
                case 8:
                    if(!state8) {
                        table8_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state8 = true;
                        mSystem.Checking();
                    }
                    else{
                        table8_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state8 = false;
                        mSystem.Checking();
                    }

                    break;
                case 9:
                    if(!state9) {
                        table9_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state9 = true;
                        mSystem.Checking();
                    }
                    else{
                        table9_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state9 = false;
                        mSystem.Checking();
                    }
                    break;
                case 10:
                    if(!state10) {
                        table10_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state10 = true;
                        mSystem.Checking();
                    }
                    else{
                        table10_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state10 = false;
                        mSystem.Checking();

                    }

                    break;
                case 11:
                    if(!state11) {
                        table11_start = System.currentTimeMillis();

                        v.setBackgroundResource(android.R.color.black);
                        state11 = true;
                        mSystem.Checking();
                    }
                    else{
                        table11_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state11 = false;
                        mSystem.Checking();

                    }

                    break;
                case 12:
                    if(!state12) {
                        table12_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state12 = true;
                        mSystem.Checking();
                    }
                    else{
                        table12_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state12 = false;
                        mSystem.Checking();

                    }

                    break;
                case 13:
                    if(!state13) {
                        table1_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state13 = true;
                        mSystem.Checking();
                    }
                    else{
                        table13_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state13 = false;
                        mSystem.Checking();
                    }
                    break;
                case 14:
                    if(!state14) {
                        table14_start = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.black);
                        state14 = true;
                        mSystem.Checking();
                    }
                    else{
                        table14_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state14 = false;
                        mSystem.Checking();

                    }

                    break;
                case 15:
                    if(!state15) {
                        table15_start = System.currentTimeMillis();

                        v.setBackgroundResource(android.R.color.black);
                        state15 = true;
                        mSystem.Checking();
                    }
                    else{
                        table15_end = System.currentTimeMillis();
                        v.setBackgroundResource(android.R.color.white);
                        state15 = false;
                        mSystem.Checking();

                    }

                    break;
            }

        }


    }

}
