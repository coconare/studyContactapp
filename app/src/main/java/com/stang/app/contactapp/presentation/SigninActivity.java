package com.stang.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stang.app.contactapp.R;
import com.stang.app.contactapp.domain.MemberBean;
import com.stang.app.contactapp.service.MemberService;
import com.stang.app.contactapp.service.impl.MemberServiceImpl;
import com.stang.app.contactapp.util.CommonUtll;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etId, etPwd;
    Button btLogin, btCancel;
    MemberBean memberBean;
    MemberService memberService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        memberService = new MemberServiceImpl(this.getApplicationContext());
        memberBean = new MemberBean();
        etId = (EditText) findViewById(R.id.etId);
        etPwd = (EditText) findViewById(R.id.etPwd);
        btLogin = (Button) findViewById(R.id.btLogin);
        btCancel = (Button) findViewById(R.id.btCancel);
        btLogin.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btLogin :
                String id = etId.getText().toString();
                if(!CommonUtll.nvl(id)){
                    Toast.makeText(SigninActivity.this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                    break;
                }
                String pwd = etPwd.getText().toString();
                if(!CommonUtll.nvl(pwd)){
                    Toast.makeText(SigninActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    break;
                }
                memberBean.setId(id);
                memberBean.setPass(pwd);
                MemberBean selectMember = memberService.readOen(memberBean);
                if(!"FAIL".equals(selectMember.getId()) && memberBean.getPass().equals(selectMember.getPass())){
                    Toast.makeText(SigninActivity.this, "GO DETAIL", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SigninActivity.this, DetailActivity.class));
                }else{
                    Toast.makeText(SigninActivity.this, "로그인이 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btCancel :

                break;
        }
    }
}
