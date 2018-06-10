package com.example.shubhampatel.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Rack extends AppCompatActivity {

    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference databaseRack;
    EditText rid, rcoodinate;
    Button enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rack);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        databaseRack = FirebaseDatabase.getInstance().getReference("rack");
        rid = findViewById(R.id.rackid);
        rcoodinate = findViewById(R.id.coordinate);
        enter = findViewById(R.id.enterdb);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    addRack();
            }
        });
    }

        private void addRack () {
            String rackid = rid.getText().toString().trim();
            String coordinate = rcoodinate.getText().toString().trim();

            if(!TextUtils.isEmpty(coordinate) && !TextUtils.isEmpty(rackid))
            {
                String id = databaseRack.push().getKey();
                Rackinfo rinfo = new Rackinfo(rackid,coordinate);
                databaseRack.child(rackid).setValue(rinfo);
                Toast.makeText(this, "Rack Added", Toast.LENGTH_LONG).show();
            }
                else
            {
                Toast.makeText(this,"fields are empty",Toast.LENGTH_LONG).show();
            }
        }

}