package com.stang.app.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stang.app.contactapp.presentation.SigninActivity;
import com.stang.app.contactapp.presentation.SignupActivity;
import com.stang.app.contactapp.service.MemberService;
import com.stang.app.contactapp.service.impl.MemberServiceImpl;
import com.stang.app.contactapp.util.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btSignUp,btSignIn,btKakaoStory;
    MemberService memberService;
    View customBar;
    private BackPressCloseHandler backPressCloseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        customBar = LayoutInflater.from(MainActivity.this).inflate(R.layout.costom_bar, null);
        actionBar.setCustomView(customBar);
        setContentView(R.layout.activity_main);
        memberService = new MemberServiceImpl(this.getApplicationContext());
        btSignUp = (Button) findViewById(R.id.btSignUp);
        btSignIn = (Button) findViewById(R.id.btSignIn);
        btKakaoStory = (Button) findViewById(R.id.btKakaoStory);
        btSignUp.setOnClickListener(this);
        btSignIn.setOnClickListener(this);
        btKakaoStory.setOnClickListener(this);
        backPressCloseHandler = new BackPressCloseHandler(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSignUp :
                /**
                 * 화면 이동 하기 전에 메시지 노출~ Toast
                 */
                Toast t = Toast.makeText(MainActivity.this, "Go to Add", Toast.LENGTH_LONG);
                t.show();
                /*
                 * 데코레이션 패턴
                 * getApplicationContext() : 어플리케이션의 위치. 엑티비티의 위치
                 * from : getApplicationContext(), to : SignupActivity.class
                 * 아래와 같이 쓸수는 있으나,
                 * Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                 * 현재 위치에서 이동 하는 걸로 명시해주는게 직관적이고, 가이드에 명시되어 있다.
                 * Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                 */
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
                break;
            case R.id.btSignIn :
                Toast.makeText(MainActivity.this, "Go to Login", Toast.LENGTH_SHORT).show();
                /**
                 * ';' 하나에 블럭 단위로 메모리를 먹기 때문에, 합친다! 속도!+_+
                 */
                startActivity(new Intent(MainActivity.this, SigninActivity.class));
                break;
            case R.id.btKakaoStory :
                Toast.makeText(MainActivity.this, "카카오는 안간다 ㅋㅋ", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
