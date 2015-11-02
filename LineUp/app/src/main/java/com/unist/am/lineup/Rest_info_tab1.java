package com.unist.am.lineup;

/**
 * Created by mark_mac on 2015. 10. 30..
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class Rest_info_tab1 extends BaseFragment {

    static final String TAG = "tag.tab1";
    private ScrollView mScrollView;

    String name = null;
    String cuisine = null;
    String timing = null;
    String location = null;
    Double x_coordinate = null;
    Double y_coordinate = null;
    String phone_num = null;
    String dummyname;
    Context parent_context;
    Menu_Dialog menuDialog;

    RelativeLayout go_to_map_btn;
    Button menu;
    public static Rest_info_tab1 newInstance(Context context){
        final Rest_info_tab1 fragment = new Rest_info_tab1();
        fragment.parent_context = context;
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.res_info_tab1, parent, false);
        mScrollView = findView(view, R.id.scroll_view_tab01);

        go_to_map_btn = (RelativeLayout) view.findViewById(R.id.go_to_map);
        menu = (Button) view.findViewById(R.id.menu);

        go_to_map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map_intent = new Intent(parent_context, MapActivity.class);
                map_intent.putExtra("flag",true);
                map_intent.putExtra("lat",y_coordinate);
                map_intent.putExtra("lon",x_coordinate);
                startActivityForResult(map_intent,1);
            }
        });
        menuDialog = new Menu_Dialog(parent_context,name);
        menuDialog.setTitle("메뉴");
        menuDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });
        menuDialog.setCanceledOnTouchOutside(false);
        menuDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
            }

        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    menuDialog.show();
                }


            });



        return view;
    }

    @Override
    public CharSequence getTitle(Resources r) {
        return "매장정보";
    }

    @Override
    public String getSelfTag() {
        return TAG;
    }

    @Override
    public boolean canScrollVertically(int direction) {
        return mScrollView != null && mScrollView.canScrollVertically(direction);
    }
}

