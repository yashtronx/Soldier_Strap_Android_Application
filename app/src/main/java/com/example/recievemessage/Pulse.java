package com.example.recievemessage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Pulse extends AppCompatActivity {

    EditText a,b;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulse);

        a=findViewById(R.id.pulsedata);
        b=findViewById(R.id.pulsenaame);

        ref= FirebaseDatabase.getInstance().getReference().child("DATA").child("Name");
        ValueEventListener result=ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.getValue(String.class);
                b.setText(name);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref= FirebaseDatabase.getInstance().getReference().child("DATA").child("Heartbeat");
        ValueEventListener results=ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.getValue(String.class);
                a.setText(name);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void bak(View view)
    {
        startActivity(new Intent(getApplicationContext(),Mainpage.class));
    }


}
