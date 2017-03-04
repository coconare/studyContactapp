package com.stang.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.stang.app.contactapp.R;
import com.stang.app.contactapp.domain.MemberBean;
import com.stang.app.contactapp.service.MemberService;
import com.stang.app.contactapp.service.impl.MemberServiceImpl;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivProfile;
    TextView tvId;
    EditText etPwd, etName, etEmail, etPhone, etAddr;
    Button btUpdate, btCancel;
    MemberService memberService;
    MemberBean memberBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        memberService = new MemberServiceImpl(this.getApplicationContext());
        memberBean = new MemberBean();
        tvId = (TextView) findViewById(R.id.tvId);
        etPwd = (EditText) findViewById(R.id.etPwd);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddr = (EditText) findViewById(R.id.etAddr);
        ivProfile = (ImageView) findViewById(R.id.ivProfile);

        // 상세화면 꾸미기
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        memberBean.setId(id);
        memberBean = memberService.readOen(memberBean);
        tvId.setText(memberBean.getId());
        etPwd.setText(memberBean.getPass());
        etName.setText(memberBean.getName());
        etEmail.setText(memberBean.getEmail());
        etPhone.setText(memberBean.getPhone());
        etAddr.setText(memberBean.getAddr());

        btUpdate = (Button) findViewById(R.id.btUpdate);
        btCancel = (Button) findViewById(R.id.btCancel);
        btUpdate.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUpdate :
                memberBean.setId("".equals(tvId.getText())?memberBean.getId():tvId.getText().toString());
                memberBean.setPass("".equals(etPwd.getText())?memberBean.getPass():etPwd.getText().toString());
                memberBean.setName("".equals(etName.getText())?memberBean.getName():etName.getText().toString());
                memberBean.setEmail("".equals(etEmail.getText())?memberBean.getEmail():etEmail.getText().toString());
                memberBean.setPhone("".equals(etPhone.getText())?memberBean.getPhone():etPhone.getText().toString());
                memberBean.setAddr("".equals(etAddr.getText())?memberBean.getAddr():                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 etAddr.getText().toString());
                memberBean.setProfile("defult_icon");
                memberService.update(memberBean);
                Toast.makeText(UpdateActivity.this, "ON UPDATE", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, ListActivity.class));
                break;
            case R.id.btCancel :
                Toast.makeText(UpdateActivity.this, "GO BACK", Toast.LENGTH_SHORT);
                break;
        }
    }
}
