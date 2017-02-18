package com.stang.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.stang.app.contactapp.MainActivity;
import com.stang.app.contactapp.R;
import com.stang.app.contactapp.domain.MemberBean;
import com.stang.app.contactapp.service.MemberService;
import com.stang.app.contactapp.service.impl.MemberServiceImpl;
import com.stang.app.contactapp.util.MemberAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
    ListView lvList;
    Button btMain;
    MemberService memberService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        memberService = new MemberServiceImpl(this.getApplicationContext());
        lvList = (ListView) findViewById(R.id.lvList);
        ArrayList<MemberBean> list = memberService.list();
        lvList.setAdapter(new MemberAdapter(list, this));
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lvList.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
            }
        });
        lvList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });

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
