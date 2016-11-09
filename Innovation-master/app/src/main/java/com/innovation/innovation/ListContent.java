package com.innovation.innovation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by liruk on 2016-10-29.
 */

public class ListContent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_project);

        //Gets the position
        Bundle extras = getIntent().getExtras();
        int value = extras.getInt("key");

        //Views changed by database
        TextView idView = (TextView) findViewById(R.id.productID);
        TextView productBox = (TextView) findViewById(R.id.product);
        TextView descriptionBox = (TextView) findViewById(R.id.productDescription);
        TextView productTypeBox = (TextView) findViewById(R.id.productType);
        TextView productPurposeBox = (TextView) findViewById(R.id.productPurpose);
        TextView productLocationBox = (TextView) findViewById(R.id.productLocation);
        TextView productSchoolsBox = (TextView) findViewById(R.id.productSchools);
        TextView productContactsBox = (TextView) findViewById(R.id.productContacts);

        //Uses database handler to find the product located at a certain id number
        DBHandler dbHandler = new DBHandler(this, null, null, 1);
        Product product =
                dbHandler.findProduct(String.valueOf(value + 1));

        //Sets the texts in the views according to the values in the row of the located id number
        idView.setText(String.valueOf(product.getID()));
        productBox.setText(String.valueOf(product.getProduct()));
        descriptionBox.setText(String.valueOf(product.getDescription()));
        productTypeBox.setText(String.valueOf(product.getProductType()));
        productPurposeBox.setText(String.valueOf(product.getProductPurpose()));
        productLocationBox.setText(String.valueOf(product.getProductLocation()));
        productSchoolsBox.setText(String.valueOf(product.getProductSchools()));
        productContactsBox.setText(String.valueOf(product.getProductContacts()));

    }

}