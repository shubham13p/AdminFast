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

public class ProductType extends AppCompatActivity {

    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference databaseRack;
    EditText ptid, ptname;
    Button enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_type);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        databaseRack = FirebaseDatabase.getInstance().getReference("producttype");
        ptid = findViewById(R.id.productid);
        ptname = findViewById(R.id.ptype);
        enter = findViewById(R.id.enterdb);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRack();
            }
        });
    }

    private void addRack () {
        String productid = ptid.getText().toString().trim();
        String productname = ptname.getText().toString().trim();

        if(!TextUtils.isEmpty(productid) && !TextUtils.isEmpty(productname))
        {
            String id = databaseRack.push().getKey();
            ProductTypeinfo ptinfo = new ProductTypeinfo(productid,productname);
            databaseRack.child(productid).setValue(ptinfo);
            Toast.makeText(this, "Product type Added", Toast.LENGTH_LONG).show();
        }
//                else{
//                    Toast.makeText(this, "Rack Already Present", Toast.LENGTH_LONG).show();
//                }

//            }
        else
        {
            Toast.makeText(this,"fields are empty",Toast.LENGTH_LONG).show();
        }



    }


}