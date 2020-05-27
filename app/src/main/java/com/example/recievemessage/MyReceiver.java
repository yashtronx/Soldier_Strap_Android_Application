package com.example.recievemessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVED="android.provider.Telephony.SMS_RECEIVED";
    private static final String tag="SmsBroadcastReceiver";
    String msg,phoneno;
    private DatabaseReference mDatabase;


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(tag,"Intent Received: "+intent.getAction());
        if(intent.getAction()==SMS_RECEIVED)
        {
            Bundle dataBundle=intent.getExtras();
            if(dataBundle!=null)
            {
                Object[] mypdu=(Object[])dataBundle.get("pdus");
                final SmsMessage[] message=new SmsMessage[mypdu.length];
                for(int i=0;i<mypdu.length;i++)
                {
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
                    {
                        String format=dataBundle.getString("format");
                        message[i]=SmsMessage.createFromPdu((byte[])mypdu[i], format);

                    }
                    else
                    {
                        message[i]=SmsMessage.createFromPdu((byte[])mypdu[i]);
                    }
                    msg=message[i].getMessageBody();
                    phoneno=message[i].getOriginatingAddress();
                }
                Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
                mDatabase = FirebaseDatabase.getInstance().getReference();
                String arr[]=msg.split("\n");

                if(msg.charAt(0)=='A')
                {
                    Intent intentone = new Intent(context.getApplicationContext(), PopUp.class);
                    intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intentone);
                }

                else{
                if(phoneno.equals("07070272976")) {
                    mDatabase.child("DATA").child("Name").setValue(arr[0].substring(16,arr[0].length()-1));
                    mDatabase.child("DATA").child("Temperature").setValue(arr[1].substring(13,arr[1].length()-1));
                    mDatabase.child("DATA").child("Heartbeat").setValue(arr[2].substring(11,arr[2].length()-1));
                    mDatabase.child("DATA").child("Location").setValue(arr[3].substring(10,arr[3].length()-1));
                }}

            }
        }
    }
}
