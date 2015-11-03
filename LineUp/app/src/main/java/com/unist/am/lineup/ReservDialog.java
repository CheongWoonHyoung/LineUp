package com.unist.am.lineup;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by mintaewon on 2015. 7. 27..
 */
public class ReservDialog extends Dialog implements View.OnTouchListener {
    public EditText name,phone,number;
    public RelativeLayout Ok,Cancel;
    public boolean focused;
    private Typeface mTypeface;
    public String _name,_phone,_number;
    public ReservDialog(Context context) {
        super(context);
    }

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_resrvation_page);
        focused = false;
        name = (EditText) findViewById(R.id.input_name);
        phone = (EditText) findViewById(R.id.input_phoneno);
        Ok = (RelativeLayout) findViewById(R.id.Ok);
        Cancel = (RelativeLayout) findViewById(R.id.Cancel);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!(hasFocus || phone.isFocused())) {
                    hideKeyboard(v);
                    Log.d("FOCUS", "FOCUS = " + getCurrentFocus());
                }
            }
        });
        phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!(hasFocus || phone.isFocused() )) {
                    hideKeyboard(v);
                    Log.d("FOCUS", "FOCUS = " + getCurrentFocus());
                }
            }
        });

        /*
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(name.getWindowToken(),0);
        imm.hideSoftInputFromWindow(phone.getWindowToken(),0);
        imm.hideSoftInputFromWindow(number.getWindowToken(),0);
        */

            Ok.setOnTouchListener(this);
            Cancel.setOnTouchListener(this);
        }
        @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(view==Ok){
            Log.e("ok", "z");
            _name=name.getText().toString();
            _phone=phone.getText().toString();
            name.setText(null);
            phone.setText(null);
            name.setHint("Input your name");
            phone.setHint("Input your Phone number");
            //name.setTypeface(mTypeface);
            //number.setTypeface(mTypeface);
            //phone.setTypeface(mTypeface);
            name.requestFocus();
            focused = true;
            cancel();
        }
        if(view == Cancel){
            Log.e("cacel", "z");
            dismiss();
        }
        return false;
    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
