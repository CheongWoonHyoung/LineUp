package com.unist.am.lineup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.noties.scrollable.CanScrollVerticallyDelegate;
import ru.noties.scrollable.OnScrollChangedListener;
import ru.noties.scrollable.ScrollableLayout;


/**
 * Created by owner on 2015-10-27.
 */

public class MyPageActivity extends BaseActivity_myPage {
    private static final String ARG_LAST_SCROLL_Y = "arg.LastScrollY";
    private ScrollableLayout mScrollableLayout;

    LinearLayout settingBtn;
    LinearLayout BackBtn;

    String nickName;
    String profileImgURL;

    TextView cus_name;
    ImageView cus_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.unist.am.lineup.R.layout.activity_mypage);
        Intent profile_data = getIntent();
        nickName = profile_data.getExtras().getString("nickName");
        profileImgURL=profile_data.getExtras().getString("profileImgURL");
        cus_name = (TextView) findViewById(R.id.profile_name);
        cus_profile = (ImageView) findViewById(R.id.profile);
        //cus_name.setText(nickName);
        //Picasso.with(this).load(profileImgURL).resize(120,120).into(cus_profile);
        final View header = findViewById(R.id.my_page_header);
        final TabsLayout_myPage tabs = findView(R.id.mypage_tabs);


        // tab 부분

        mScrollableLayout = findView(R.id.scrollable_layout);
        mScrollableLayout.setDraggableView(tabs);

        final ViewPager viewPager = findView(R.id.mypage_view_pager);
        final ViewPagerAdapter_myPage adapter = new ViewPagerAdapter_myPage(getSupportFragmentManager(), getResources(), getFragments());
        viewPager.setAdapter(adapter);

        tabs.setViewPager(viewPager);

        mScrollableLayout.setCanScrollVerticallyDelegate(new CanScrollVerticallyDelegate() {
            @Override
            public boolean canScrollVertically(int direction) {
                return adapter.canScrollVertically(viewPager.getCurrentItem(), direction);
            }
        });

        mScrollableLayout.setOnScrollChangedListener(new OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int y, int oldY, int maxY) {

                final float tabsTranslationY;
                if (y < maxY) {
                    tabsTranslationY = .0F;
                } else {
                    tabsTranslationY = y - maxY;
                }

                tabs.setTranslationY(tabsTranslationY);

                header.setTranslationY(y / 2);
            }
        });

        if (savedInstanceState != null) {
            final int y = savedInstanceState.getInt(ARG_LAST_SCROLL_Y);
            mScrollableLayout.post(new Runnable() {
                @Override
                public void run() {
                    mScrollableLayout.scrollTo(0, y);
                }
            });
        }

        // header 부분

        settingBtn = (LinearLayout) header.findViewById(R.id.settingBtn);
        BackBtn = (LinearLayout) header.findViewById(R.id.backBtn);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(MyPageActivity.this, SettingActivity.class);
                startActivity(mintent);
            }
        });
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(ARG_LAST_SCROLL_Y, mScrollableLayout.getScrollY());
        super.onSaveInstanceState(outState);
    }

    private List<BaseFragment_myPage> getFragments() {
        final FragmentManager manager = getSupportFragmentManager();
        final List<BaseFragment_myPage> list = new ArrayList<>();
        Mypage_tab1 tab01 = (Mypage_tab1) manager.findFragmentByTag(Mypage_tab1.TAG);
        Mypage_tab2 tab02 = (Mypage_tab2) manager.findFragmentByTag(Mypage_tab2.TAG);
        Mypage_tab3 tab03 = (Mypage_tab3) manager.findFragmentByTag(Mypage_tab3.TAG);
        Mypage_tab4 tab04 = (Mypage_tab4) manager.findFragmentByTag(Mypage_tab4.TAG);
        if (tab01 == null) {
            tab01 = tab01.newInstance();
        }
        if (tab02 == null) {
            tab02 = tab02.newInstance();
        }
        if (tab03 == null) {
            tab03 = tab03.newInstance();
        }
        if (tab04 == null) {
            tab04 = tab04.newInstance();
        }
        Collections.addAll(list, tab01, tab02, tab03, tab04);

        return list;
    }
}
