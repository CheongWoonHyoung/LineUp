package com.unist.am.lineup;

/**
 * Created by Jeonghyun on 2015. 10. 30..
 */

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Mypage_tab3 extends BaseFragment_myPage {

    Boolean isQueue = false;
    TextView resrv_rname;
    TextView resrv_name;
    TextView resrv_party;
    TextView resrv_time;
    TextView time_left;
    TextView people_left;
    TextView cancel_btn;
    Context mContext;

    DBManager_reserv manager;
    DBManager_update manager_update;

    String nickName;
    String profileImageURL ;
    String thumbnailURL ;
    String countryISO ;
    String name;

    LayoutInflater inflater_g;
    ViewGroup container_g;
    Bundle savedInstanceState_g;

    static final String TAG = "tag.myPage_tab3";
    private ScrollView mScrollView;



    public static Mypage_tab3 newInstance(){
        final Mypage_tab3 fragment = new Mypage_tab3();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view=null;
        mContext = parent.getContext();
        inflater_g=inflater;
        container_g=parent;
        savedInstanceState_g=savedInstanceState;

        manager = new DBManager_reserv(mContext, "reserv_info.db", null, 1);
        if(manager.returnName().equals("nothing")) isQueue = false;
        else isQueue = true;
        if(isQueue){
             view = inflater.inflate(R.layout.mypage_tab03_reserv, parent, false);
            mScrollView = findView(view, R.id.scroll_view_my_tab03);
            TextView cancel_btn = (TextView) view.findViewById(R.id.cancel_btn);
            /*v = inflater.inflate(R.layout.tab2_reservation_info,container,false);
            resrv_time = (TextView) v.findViewById(R.id.resrv_time);
            resrv_rname= (TextView) v.findViewById(R.id.resrv_rname);
            resrv_name = (TextView) v.findViewById(R.id.resrv_name);
            resrv_party = (TextView) v.findViewById(R.id.resrv_party);
            time_left = (TextView) v.findViewById(R.id.time_left);
            people_left = (TextView) v.findViewById(R.id.people_left);
            cancel_btn = (TextView) v.findViewById(R.id.cancel_btn);

            resrv_time.setText(manager.returnTime());
            resrv_rname.setText(manager.returnName());
            resrv_party.setText(manager.returnParty());*/

            cancel_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    manager = new DBManager_reserv(mContext, "reserv_info.db", null, 1);
                    DBManager_regid manager_regid = new DBManager_regid(mContext,"regid_info.db",null,1);

                    Log.e("pass", manager.returnPid());
                    new lineup_cancel().execute("out", manager.returnPid(), manager.returnDummyname(), manager_regid.returnRegid(), nickName);
                    manager.delete("delete from RESERV_INFO");
                    Intent intent = new Intent(mContext,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    //onCreate(savedInstanceState);
                }
            });

        }else{
            view = inflater.inflate(R.layout.mypage_tab03, parent, false);
            mScrollView = findView(view, R.id.scroll_view_my_tab03);
            //v = inflater.inflate(R.layout.tab2_reservation_info_blank,container,false);



        }




        return view;
    }

    @Override
    public CharSequence getTitle(Resources r) {
        return "라인업";
    }

    @Override
    public String getSelfTag() {
        return TAG;
    }

    @Override
    public boolean canScrollVertically(int direction) {
        return mScrollView != null && mScrollView.canScrollVertically(direction);
    }

    private class lineup_cancel extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... info) {
            String sResult = "Error";

            try {
                URL url = new URL("http://52.69.163.43/queuing/line_manage.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("POST");
                String body = "in_out=" + info[0] +"&"
                        +"priority=" + info[1] + "&"
                        +"resname=" + info[2] + "&"
                        +"regid=" + info[3] + "&"
                        +"method=App" + "&"
                        +"name=" + info[4] + "&"
                        +"location=phone";

                Log.e("value",info[0]+" "+info[1]+" "+info[2]);

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                osw.write(body);
                osw.flush();

                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuilder builder = new StringBuilder();
                String str;

                while ((str = reader.readLine()) != null) {
                    builder.append(str);
                }
                sResult     = builder.toString();
                Log.e("pass", sResult);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResult;
        }

        @Override
        protected void onPostExecute(String result){
            Toast.makeText(mContext, "Cancel complete!", Toast.LENGTH_SHORT).show();
            //manager.delete("delete from RESERV_INFO");
        }
    }
}

