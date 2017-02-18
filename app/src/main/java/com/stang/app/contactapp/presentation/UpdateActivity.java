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

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivProfile;
    TextView tvId;
    EditText etName, etEmail, etPhone, etAddr;
    Button btUpdate, btCancel;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent intent = this.getIntent();
        id = intent.getExtras().getString("id");
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddr = (EditText) findViewById(R.id.etAddr);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btCancel = (Button) findViewById(R.id.btCancel);
        btUpdate.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUpdate :
                break;
            case R.id.btCancel :
                Toast.makeText(UpdateActivity.this, "GO BACK", Toast.LENGTH_SHORT);
                break;
        }
    }
}
