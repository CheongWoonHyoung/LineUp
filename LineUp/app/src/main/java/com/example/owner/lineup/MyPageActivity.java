package com.example.owner.lineup;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by owner on 2015-10-27.
 */
public class MyPageActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        TabHost mp_TabHost = getTabHost();
    }
}
