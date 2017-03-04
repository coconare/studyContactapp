package com.stang.app.contactapp.presentation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.stang.app.contactapp.R;

public class MessageActivity extends AppCompatActivity {
    TextView tvToSms;
    EditText etMessgage;
    Button btSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        tvToSms = (TextView) findViewById(R.id.tvToSms);
        //String phone = this.getIntent().getExtras().get("phone").toString();
        etMessgage.findViewById(R.id.etMessage);
        Button btSend = (Button) findViewById(R.id.btSend);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }
    protected  void sendSMS(){
        Log.i("Send SMS", "");

        String telNo = tvToSms.getText().toString();
        Uri smsUri = Uri.parse("tel:"+telNo);
        Intent smsIntent = new Intent(Intent.ACTION_VIEW, smsUri);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", telNo);
        smsIntent.putExtra("sms_body", etMessgage.getText().toString());
        try {
            startActivity(smsIntent);
            finish();
            Log.i("전송완료~", "");
        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(MessageActivity.this, "SMS 실패", Toast.LENGTH_SHORT).show();
        }
    }
}
