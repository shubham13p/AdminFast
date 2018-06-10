package com.example.shubhampatel.admin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Product extends AppCompatActivity {

    Spinner rack, protype, partition;
    EditText productid, productname, longitude, latitude;
    DatabaseReference DatabaseRoot, DatabaseProduct;
    //   FirebaseHelper helper;
    FirebaseDatabase database;
    Button enter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        database = FirebaseDatabase.getInstance();
        DatabaseRoot = database.getReference();


        DatabaseProduct = FirebaseDatabase.getInstance().getReference("product");
        partition = findViewById(R.id.partitionno);
        productid = findViewById(R.id.pid);
        productname = findViewById(R.id.pname);
        enter = findViewById(R.id.enterdb);
        longitude = findViewById(R.id.longi);
        latitude = findViewById(R.id.lati);


        DatabaseRoot.child("producttype").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<String> areas = new ArrayList<String>();
                for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
                    String areaName = areaSnapshot.child("producttypename").getValue(String.class);
                    if (areaName != null) {
                        areas.add(areaName);
                    }
                }
                protype = findViewById(R.id.producttype);
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Product.this, android.R.layout.simple_spinner_item, areas);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                protype.setAdapter(dataAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        DatabaseRoot.child("rack").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<String> areas = new ArrayList<String>();
                for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
                    String areaName = areaSnapshot.child("rackid").getValue(String.class);
                    if (areaName != null) {
                        areas.add(areaName);
                    }
                }
                rack = findViewById(R.id.rackno);
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Product.this, android.R.layout.simple_spinner_item, areas);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                rack.setAdapter(dataAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });
    }


    private void addProduct() {
        final String pid = productid.getText().toString().trim();
        final String pname = productname.getText().toString().trim();
        final String rid = rack.getSelectedItem().toString();
        final String partid = partition.getSelectedItem().toString();
        final String ptid = protype.getSelectedItem().toString();
        final String longi = longitude.getText().toString().trim();
        final String lati = latitude.getText().toString().trim();

        if (!TextUtils.isEmpty(longi) && !TextUtils.isEmpty(lati) && !TextUtils.isEmpty(pid) && !TextUtils.isEmpty(pname) && !TextUtils.isEmpty(rid) && !TextUtils.isEmpty(partid) && !TextUtils.isEmpty(ptid)) {
            final String id = DatabaseProduct.push().getKey();
            Productinfo pinfo = new Productinfo(pid, pname, rid, partid, ptid, longi, lati);

            DatabaseProduct.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        if (data.child(pid).exists()) {
                            Toast.makeText(Product.this, "fields are present", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Product.this, "fields are not present", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }

//            DatabaseProduct.child(pid).setValue(pinfo);
//            Toast.makeText(this, "Product Added", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(this, "fields are empty", Toast.LENGTH_LONG).show();
//        }

    }
}
