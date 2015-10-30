package com.unist.am.lineup;

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
        setContentView(com.unist.am.lineup.R.layout.activity_mypage);
        TabHost mp_TabHost = getTabHost();
    }
}
