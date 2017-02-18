package com.stang.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.stang.app.contactapp.R;
import com.stang.app.contactapp.domain.MemberBean;
import com.stang.app.contactapp.service.MemberService;
import com.stang.app.contactapp.service.impl.MemberServiceImpl;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivProfile;
    TextView tvId, tvName, tvEmail, tvPhone, tvAddr;
    Button btCall, btMessge, btMap, btDel, btEdit, btList;
    String id;
    MemberService memberService;
    MemberBean memberBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        memberService = new MemberServiceImpl(this.getApplicationContext());
        Intent intent = this.getIntent();
        id = intent.getExtras().getString("id");
        memberBean = new MemberBean();
        memberBean.setId(id);
        memberBean = memberService.readOen(memberBean);
        tvId = (TextView) findViewById(R.id.tvId);
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvAddr = (TextView) findViewById(R.id.tvAddr);
        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        tvId.setText(memberBean.getId());
        tvName.setText(memberBean.getName());
        tvEmail.setText(memberBean.getEmail());
        tvPhone.setText(memberBean.getPhone());
        tvAddr.setText(memberBean.getAddr());
        btCall = (Button) findViewById(R.id.btCall);
        btMessge = (Button) findViewById(R.id.btMessge);
        btMap = (Button) findViewById(R.id.btMap);
        btDel = (Button) findViewById(R.id.btDel);
        btEdit = (Button) findViewById(R.id.btEdit);
        btList = (Button) findViewById(R.id.btList);
        btCall.setOnClickListener(this);
        btMessge.setOnClickListener(this);
        btMap.setOnClickListener(this);
        btDel.setOnClickListener(this);
        btEdit.setOnClickListener(this);
        btList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btCall :
                break;
            case R.id.btMessge :
                break;
            case R.id.btMap :
                break;
            case R.id.btDel :
                break;
            case R.id.btEdit :
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", "hyun");
                Toast.makeText(DetailActivity.this, "Go EDIT", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.btList :
                Toast.makeText(DetailActivity.this, "GO LiST", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;
        }
    }
}
