package com.example.recievemessage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int My_Permissions=0;
    final Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.RECEIVE_SMS))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS},My_Permissions);
            }

        }


    }


    public void onRequestPermissionResult(int requestCode,String permissions[],int[] grantresults)
    {
        switch (requestCode)
        {
            case My_Permissions:
            {
                if(grantresults.length>0 && grantresults[0]==PackageManager.PERMISSION_GRANTED)
                {

                }
                else
                {

                }
            }
        }
    }

    public void temp(View view)
    {
        startActivity(new Intent(getApplicationContext(),Mainpage.class));
    }

    public static void newwindow()
    {

    }
}
