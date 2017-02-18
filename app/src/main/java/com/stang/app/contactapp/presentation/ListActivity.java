package com.stang.app.contactapp.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                Log.d("Long Click : ", "true");
                Object o = lvList.getItemAtPosition(i);
                final MemberBean member = (MemberBean) o;
                new AlertDialog.Builder(ListActivity.this)
                        .setTitle("삭제?")
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("Long Click : ", "true");
                                memberService.delete(member);
                                Intent intent = new Intent(ListActivity.this, ListActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
                return true;
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
