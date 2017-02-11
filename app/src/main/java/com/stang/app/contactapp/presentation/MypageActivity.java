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

public class MypageActivity extends AppCompatActivity implements View.OnClickListener {
        ImageView ivProfile;
        TextView tvId, tvName, tvPhone, tvAddr;
        Button btAlbum, btSchedule, btEdit, btDel, btGoogle, btNaver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        btAlbum = (Button) findViewById(R.id.btAlbum);
        btSchedule = (Button) findViewById(R.id.btSchedule);
        btEdit = (Button) findViewById(R.id.btUpdate);
        btDel = (Button) findViewById(R.id.btDelete);
        btGoogle = (Button) findViewById(R.id.btGoogle);
        btNaver = (Button) findViewById(R.id.btNaver);
        btAlbum.setOnClickListener(this);
        btSchedule.setOnClickListener(this);
        btEdit.setOnClickListener(this);
        btDel.setOnClickListener(this);
        btGoogle.setOnClickListener(this);
        btNaver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btAlbum :
                break;
            case R.id.btSchedule :
                break;
            case R.id.btEdit :
                Toast.makeText(MypageActivity.this, "Go EDIT", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MypageActivity.this, UpdateActivity.class));
                break;
            case R.id.btDel :
                break;
            case R.id.btGoogle :
                break;
            case R.id.btNaver :
                break;
        }
    }
}
