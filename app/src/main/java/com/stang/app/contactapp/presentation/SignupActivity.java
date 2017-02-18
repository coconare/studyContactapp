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

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etId, etPwd, etName, etEmail, etPhone, etAddr;
    Button btSubmit, btCancel;
    MemberService memberService;
    MemberBean memberBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        memberService = new MemberServiceImpl(this.getApplicationContext());
        memberBean = new MemberBean();
        etId = (EditText) findViewById(R.id.etId);
        etPwd = (EditText) findViewById(R.id.etPwd);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddr = (EditText) findViewById(R.id.etAddr);
        btSubmit = (Button) findViewById(R.id.btSubmit);
        btCancel = (Button) findViewById(R.id.btCancel);
        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSubmit :
                memberBean.setId(etId.getText().toString());
                memberBean.setPass(etPwd.getText().toString());
                memberBean.setName(etName.getText().toString());
                memberBean.setEmail(etEmail.getText().toString());
                memberBean.setPhone(etPhone.getText().toString());
                memberBean.setAddr(etAddr.getText().toString());
                memberBean.setProfile("defult_icon");
                memberService.add(memberBean);
                Toast.makeText(SignupActivity.this, "ON ADD", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignupActivity.this, SigninActivity.class));
                break;
            case R.id.btCancel :
                break;
        }
    }
}
