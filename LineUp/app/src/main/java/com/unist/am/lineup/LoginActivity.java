package com.unist.am.lineup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.tv.TvInputService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kakao.auth.APIErrorResult;
import com.kakao.auth.Session;
import com.kakao.auth.SessionCallback;
import com.kakao.kakaotalk.KakaoTalkHttpResponseHandler;
import com.kakao.kakaotalk.KakaoTalkProfile;
import com.kakao.kakaotalk.KakaoTalkService;
import com.kakao.usermgmt.LoginButton;
import com.kakao.util.exception.KakaoException;


public class LoginActivity extends AppCompatActivity {



    private LoginButton kakaoLogin;
    private final SessionCallback mySessionCallback = new MySessionStatusCallback();
    private Session session;
    private BackPressCloseHandler backPressCloseHandler;
    String nickName;
    String profileImageURL ;
    String thumbnailURL ;
    String countryISO ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        backPressCloseHandler = new BackPressCloseHandler(this);
        kakaoLogin = (LoginButton) findViewById(R.id.kakao_login);
        Session.initialize(this);
        session =Session.getCurrentSession();
        session.addCallback(mySessionCallback);
        if (session.isClosed()){
            kakaoLogin.setVisibility(View.VISIBLE);
        } else {
            kakaoLogin.setVisibility(View.GONE);
            if (session.implicitOpen()) {
                kakaoLogin.setVisibility(View.GONE);
            } else {
                finish();
            }
        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        session.removeCallback(mySessionCallback);
    }
    @Override
    public void onBackPressed() {
       backPressCloseHandler.onBackPressed();

    }





    private class MySessionStatusCallback implements SessionCallback {
        @Override
        public void onSessionOpened() {
            // 프로그레스바 종료
            Log.d("OPEND", "OPEN");
            // 세션 오픈후 보일 페이지로 이동
            //readProfile();

            Log.d("OPEND", "onHttpSuccess " + nickName);
            //final DBManager_regid manager_regid = new DBManager_regid(getApplicationContext(),"regid_info.db",null,1);
            SharedPreferences prefs = getApplicationContext().getSharedPreferences("com.unist.npc.queuing.", Context.MODE_PRIVATE);
            if(!prefs.contains("IsLogin"))
                prefs.edit().putBoolean("IsLogin",true).apply();
            else{
                prefs.edit().remove("IsLogin").apply();
                prefs.edit().putBoolean("IsLogin",true).apply();
            }
            //if(nickName != null) new HttpPostRequest2().execute(manager_regid.returnRegid(), nickName);
            KakaoTalkService.requestProfile(new MyTalkHttpResponseHandler<KakaoTalkProfile>() {
                @Override
                public void onHttpSuccess(final KakaoTalkProfile talkProfile) {
                    nickName = talkProfile.getNickName();
                    profileImageURL = talkProfile.getProfileImageURL();
                    thumbnailURL = talkProfile.getThumbnailURL();
                    countryISO = talkProfile.getCountryISO();
                    //new HttpPostRequest2().execute(manager_regid.returnRegid(), nickName);
                    // display
                    redirectMainActivity();

                }
            });
            //finish();

        }

        @Override
        public void onSessionClosed(final KakaoException exception) {
            // 프로그레스바 종료
            // 세션 오픈을 못했으니 다시 로그인 버튼 노출.
            Log.d("LOGINFAIL","FAIL " +exception);
            kakaoLogin.setVisibility(View.VISIBLE);
        }

        @Override
        public void onSessionOpening() {
            //프로그레스바 시작
        }
    }
    private abstract class MyTalkHttpResponseHandler<T> extends KakaoTalkHttpResponseHandler<T> {
        @Override
        public void onHttpSessionClosedFailure(final APIErrorResult errorResult) {
            redirectLoginActivity();
        }

        @Override
        public void onNotKakaoTalkUser(){
            Toast.makeText(getApplicationContext(), "not a KakaoTalk user", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(final APIErrorResult errorResult) {
            Toast.makeText(getApplicationContext(), "failed : " + errorResult, Toast.LENGTH_SHORT).show();
        }
    }
    private void redirectLoginActivity() {
        final Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void redirectMainActivity(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

}

