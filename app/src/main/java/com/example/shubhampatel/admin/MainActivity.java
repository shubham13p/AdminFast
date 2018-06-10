package com.example.shubhampatel.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button rack, producttype, product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rack = (Button) findViewById(R.id.rack);
        producttype = (Button) findViewById(R.id.ptypebutton);
        product = (Button) findViewById(R.id.product);


        rack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this,Rack.class);
                startActivity(i);
            }
        });


        producttype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ProductType.class);
                startActivity(i);
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Product.class);
                startActivity(i);
            }
        });
    }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            finish();
        }



}
