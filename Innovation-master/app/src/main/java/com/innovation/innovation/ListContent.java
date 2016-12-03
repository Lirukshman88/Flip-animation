package com.innovation.innovation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by liruk on 2016-10-29.
 */

public class ListContent extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_project_list);

        //Gets the position
        Bundle extras = getIntent().getExtras();
        int value = extras.getInt("key");

        //Views changed by database
        TextView productBox = (TextView) findViewById(R.id.product);
        TextView descriptionBox = (TextView) findViewById(R.id.productDescription);
        TextView productSchoolsBox = (TextView) findViewById(R.id.productSchools);
        TextView productContactsBox = (TextView) findViewById(R.id.productContacts);

        //Uses database handler to find the product located at a certain id number
        DBHandler dbHandler = new DBHandler(this, null, null, 1);
        Product product =
                dbHandler.findProduct(String.valueOf(value + 1));

        //Sets the texts in the views according to the values in the row of the located id number
        productBox.setText(String.valueOf(product.getProduct()));
        descriptionBox.setText(String.valueOf(product.getDescription()));
        productSchoolsBox.setText(String.valueOf(product.getProductSchools()));
        productContactsBox.setText(String.valueOf(product.getProductContacts()));

    }

}