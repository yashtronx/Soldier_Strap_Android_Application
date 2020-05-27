package com.example.recievemessage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Info extends AppCompatActivity {

    EditText a,b,c,d;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        a=findViewById(R.id.textView);
        b=findViewById(R.id.textView3);
        c=findViewById(R.id.textView5);
        d=findViewById(R.id.textView7);


        ref= FirebaseDatabase.getInstance().getReference().child("DATA").child("Name");
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

        ref= FirebaseDatabase.getInstance().getReference().child("DATA").child("Location");
        ValueEventListener results1=ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.getValue(String.class);
                b.setText(name);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref= FirebaseDatabase.getInstance().getReference().child("DATA").child("Temperature");
        ValueEventListener results2=ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.getValue(String.class);
                c.setText(name);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref= FirebaseDatabase.getInstance().getReference().child("DATA").child("Heartbeat");
        ValueEventListener results3=ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.getValue(String.class);
                d.setText(name);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }

    public void gta9(View view)
    {
        startActivity(new Intent(getApplicationContext(),Mainpage.class));
    }
}
