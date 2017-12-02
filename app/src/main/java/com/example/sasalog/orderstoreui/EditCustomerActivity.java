package com.example.sasalog.orderstoreui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditCustomerActivity extends AppCompatActivity {
    //variable declarations
    private String Action; //describes what different user actions
    private EditText editCustomer;
    private String customerFilter;
    private String mOldText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer);
        setTitle("Edit Customer");

        editCustomer= findViewById(R.id.txt_edit_customer);

        Intent intent= getIntent();
        Uri uri= intent.getParcelableExtra(OrderStoreUIContract.CUSTOMER_CONTENT_ITEM_TYPE);

        if(uri == null){
            Action= Intent.ACTION_INSERT;
            setTitle("New Customer");
        } else {
            Action= Intent.ACTION_EDIT;
            customerFilter= BaseColumns._ID + "=" + uri.getLastPathSegment();

            Cursor cursor= getContentResolver().query(uri, OrderStoreUIContract.CUSTOMER_FIELDS, customerFilter, null,null);
            cursor.moveToFirst();
            mOldText=cursor.getString(cursor.getColumnIndex(OrderStoreUIContract.COLUMN_FIRST_NAME));
            editCustomer.setText(mOldText);
            editCustomer.requestFocus();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(Action.equals(Intent.ACTION_EDIT)){
            getMenuInflater().inflate(R.menu.menu_edit_customer, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_delete_customer:
                deleteCustomer();
                break;
        }
        return true;
    }

    private void deleteCustomer() {
        getContentResolver().delete(OrderStoreUIContract.CUSTOMER_CONTENT_URI, customerFilter, null);
        Toast.makeText(this, R.string.customer_deleted_prompt, Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();// return to main activity
    }

    private void finishEditing() {
        String newCustomer= editCustomer.getText().toString().trim();

        switch (Action){
            case Intent.ACTION_INSERT:
                if (newCustomer.length() == 0){
                    setResult(RESULT_CANCELED);
                } else{
                    insertCustomer(newCustomer);
                }
                break;
            case Intent.ACTION_EDIT:
                if(newCustomer.length()== 0){
                    deleteCustomer();
                } else if(mOldText.equals(newCustomer)){
                    setResult(RESULT_CANCELED);
                } else {
                    updateCustomer(newCustomer);
                }
                break;
        }
        finish();
    }

    private void updateCustomer(String customerFName) {
        ContentValues values= new ContentValues();
        values.put(OrderStoreUIContract.COLUMN_FIRST_NAME, customerFName);
        getContentResolver().update(OrderStoreUIContract.CUSTOMER_CONTENT_URI, values, customerFilter, null);

        Toast.makeText(this, R.string.customer_updated_prompt, Toast.LENGTH_SHORT).show();
//        Snackbar.make(View, R.string.customer_updated_prompt, Snackbar.LENGTH_LONG).setAction("Action", null).show();
        setResult(RESULT_OK);
    }

    private void insertCustomer(String customerFName) {
        ContentValues values= new ContentValues();
        values.put(OrderStoreUIContract.COLUMN_FIRST_NAME, customerFName);
        getContentResolver().insert(OrderStoreUIContract.CUSTOMER_CONTENT_URI, values);
        setResult(RESULT_OK);
        Toast.makeText(this, "Customer Added", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed(){
        finishEditing();
    }

}
