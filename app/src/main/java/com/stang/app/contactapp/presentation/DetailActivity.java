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

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivProfile;
    TextView tvId, tvName, tvPhone, tvAddr;
    Button btCall, btMessge, btMap, btDel, btEdit, btList;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = this.getIntent();
//        id = intent.getExtras().getString("id");

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
