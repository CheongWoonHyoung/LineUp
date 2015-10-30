package com.unist.am.lineup;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 정현짱월드 on 2015-10-30.
 */
public class SettingActivity extends Activity implements View.OnClickListener{

    Button pushAlarm;
    Button couponAlarm;
    Button versionBtn;
    Button clauseBtn;
    Button inquireBtn;
    Button logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.setting);

        pushAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        pushAlarm.setOnClickListener(this);
        couponAlarm.setOnClickListener(this);
        versionBtn.setOnClickListener(this);
        clauseBtn.setOnClickListener(this);
        inquireBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent mintent = null;
        switch(v.getId()){
            case R.id.pushAlarm:
                mintent = new Intent(this, PushalarmActivity.class);
                startActivity(mintent);
                break;
            case R.id.couponAlarm:
                mintent = new Intent(this, CouponalarmActivity.class);
                startActivity(mintent);
                break;
            case R.id.version:
                mintent = new Intent(this, VersionActivity.class);
                startActivity(mintent);
                break;
            case R.id.clause:
                mintent = new Intent(this, ClauseActivity.class);
                startActivity(mintent);
                break;
            case R.id.inquire:
                mintent = new Intent(this, InquireActivity.class);
                startActivity(mintent);
                break;
            case R.id.logout:
                //Dialog
                break;


        }

    }
}
