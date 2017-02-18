package com.stang.app.contactapp.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    MemberService memberService;
    MemberBean memberBean;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        memberService = new MemberServiceImpl(this.getApplicationContext());
        memberBean = new MemberBean();
        tvId = (TextView) findViewById(R.id.tvId);
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvAddr = (TextView) findViewById(R.id.tvAddr);
        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        // 버튼
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
        // 상세화면 꾸미기
        Intent intent = this.getIntent();
        id = intent.getExtras().getString("id");
        memberBean.setId(id);
        memberBean = memberService.readOen(memberBean);
        tvId.setText(memberBean.getId());
        tvName.setText(memberBean.getName());
        tvEmail.setText(memberBean.getEmail());
        tvPhone.setText(memberBean.getPhone());
        tvAddr.setText(memberBean.getAddr());
        ivProfile.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(this.getPackageName()+":drawable/"+"defult_icon", null, null)));
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
                new AlertDialog.Builder(DetailActivity.this)
                        .setTitle("삭제?")
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("Long Click : ", "true");
                                memberService.delete(member);
                                Intent intent = new Intent(DetailActivity.this, ListActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;
            case R.id.btEdit :
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", id);
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
