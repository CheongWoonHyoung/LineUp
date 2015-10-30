package com.unist.am.lineup;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;



/**
 * Created by owner on 2015-10-27.
 */

public class MyPageActivity extends TabActivity {

    Button settingBtn;
    Button BackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.unist.am.lineup.R.layout.activity_mypage);
        TabHost mp_TabHost = getTabHost();
        settingBtn = (Button) findViewById(R.id.settingBtn);
        BackBtn = (Button) findViewById(R.id.backBtn);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(MyPageActivity.this, SettingActivity.class);
            }
        });
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
