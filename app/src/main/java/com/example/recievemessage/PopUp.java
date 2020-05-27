package com.example.recievemessage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PopUp extends AppCompatActivity {

    EditText a,b;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        a=findViewById(R.id.nme);
        b=findViewById(R.id.link);
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
    }
}
