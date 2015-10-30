package com.unist.am.lineup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RestaurantInfo extends AppCompatActivity {

    Toolbar toolbar;
    FrameLayout res_confirm;
    Context mcontext;

    String name = null;
    String cuisine = null;
    String img_large = null;
    String timing = null;
    String location = null;
    Double x_coordinate = null;
    Double y_coordinate = null;
    String phone_num = null;
    String dummyname;
    Button lineup_btn;
    Button go_to_map_btn;

    ImageView resinfo_image;
    TextView resinfo_name;
    TextView resinfo_cuisine;
    TextView resinfo_cuisine2;
    TextView resinfo_timing;
    TextView resinfo_location;
    TextView resinfo_phone_num;
    TextView resinfo_webpage;
    LinearLayout frame;

    int width_image;
    int height_image;

    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res_info);
        mcontext = this;
        Intent intent = getIntent();
        img_large = intent.getExtras().getString("img_large");
        name = intent.getExtras().getString("name");
        cuisine = intent.getExtras().getString("cuisine");
        timing = intent.getExtras().getString("timing");
        location = intent.getExtras().getString("location");
        phone_num = intent.getExtras().getString("phone_num");
        x_coordinate = intent.getExtras().getDouble("x_coordinate");
        y_coordinate = intent.getExtras().getDouble("y_coordinate");
        username = intent.getExtras().getString("username");
        dummyname = intent.getExtras().getString("dummy_name");
        this.setResult(Activity.RESULT_OK);

        lineup_btn = (Button) findViewById(R.id.lineup_btn);
        lineup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ConfirmActivity.class));
            }
        });

        /*
        go_to_map_btn = (Button) findVIewById(R.id.go_to_map);

         */
        go_to_map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map_intent = new Intent(mcontext, MapActivity.class);
                map_intent.putExtra("lat",y_coordinate);
                map_intent.putExtra("lon",x_coordinate);
                startActivityForResult(map_intent,1);
            }
        });

    }
}
