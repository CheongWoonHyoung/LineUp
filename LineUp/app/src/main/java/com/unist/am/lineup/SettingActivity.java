package com.unist.am.lineup;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kakao.auth.APIErrorResult;
import com.kakao.usermgmt.LogoutResponseCallback;
import com.kakao.usermgmt.UserManagement;

/**
 * Created by 정현짱월드 on 2015-10-30.
 */
public class SettingActivity extends Activity implements View.OnClickListener{

    TextView pushAlarm;
    TextView couponAlarm;
    TextView versionBtn;
    TextView clauseBtn;
    TextView inquireBtn;
    TextView logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.setting);

        pushAlarm = (TextView) findViewById(R.id.pushAlarm);
        couponAlarm =(TextView)findViewById(R.id.couponAlarm);
        versionBtn =(TextView) findViewById(R.id.version);
        clauseBtn = (TextView) findViewById(R.id.clause);
        inquireBtn= (TextView) findViewById(R.id.inquire);
        logoutBtn = (TextView) findViewById(R.id.logout);

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
                UserManagement.requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onSuccess(final long userId) {
                        redirectLoginActivity();
                    }

                    @Override
                    public void onFailure(final APIErrorResult apiErrorResult) {
                        //redirectLoginActivity();
                        Log.e("LOGOUTFAIL", "ERROR : " + apiErrorResult);
                    }
                });
                //Dialog
                break;


        }

    }
    protected void redirectLoginActivity() {

        SharedPreferences prefs = getApplicationContext().getSharedPreferences("com.unist.npc.queuing.", Context.MODE_PRIVATE);
        prefs.edit().remove("IsLogin").apply();
        prefs.edit().putBoolean("IsLogin",false).apply();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
