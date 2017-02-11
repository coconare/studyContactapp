package com.stang.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stang.app.contactapp.MainActivity;
import com.stang.app.contactapp.R;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
    Button btMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        btMain = (Button) findViewById(R.id.btMain);
        btMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btMain :
                Toast.makeText(ListActivity.this, "GO MAIN", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ListActivity.this, MainActivity.class));
                break;
        }
    }
}
