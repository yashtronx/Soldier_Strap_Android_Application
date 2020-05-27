package com.example.recievemessage;

import androidx.appcompat.app.AppCompatActivity;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Mainpage extends AppCompatActivity {

    final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;


    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);


        send =(Button)findViewById(R.id.button7);

        send.setEnabled(false);
        if(checkPermission(Manifest.permission.SEND_SMS)){
            send.setEnabled(true);
        }else{
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE);
        }
    }

    public void onSend(View v){


        if(checkPermission(Manifest.permission.SEND_SMS)){
            SmsManager smsManager = SmsManager.getDefault();
            String messageToSend = "LOCAL ";
            String number = "+917070272976";
            SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null,null);
            Toast.makeText(this, "Message Sent!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    public void bod(View view) {
        startActivity(new Intent(Mainpage.this,Temperature.class));
    }
    public void pup(View view) {
        startActivity(new Intent(Mainpage.this,Pulse.class));
    }
    public void in(View view) {
        startActivity(new Intent(Mainpage.this,Info.class));
    }


}


