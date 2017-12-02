package com.example.sasalog.orderstoreui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void openCustomers(View view) {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openProducts(View view) {
        Intent intent= new Intent(this, ProductsActivity.class);
        startActivity(intent);
    }

    public void openOrders(View view) {
        Intent intent= new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }

    public void openOrderList(View view) {
        Intent intent= new Intent(this, OrderListActivity.class);
        startActivity(intent);
    }
}
