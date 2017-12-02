package com.example.sasalog.orderstoreui;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by sasalog on 11/21/17.
 */

public class OrderStoreUIContract {
    public static String CUSTOMER_BASE_PATH= "com.example.orderstore.orderprovider/Customers";
    public static final Uri CUSTOMER_CONTENT_URI= Uri.parse("content://" + CUSTOMER_BASE_PATH);

    public static final  String CUSTOMER_CONTENT_ITEM_TYPE= "Customer";

    //Customer Table - column names
    public static final String COLUMN_FIRST_NAME="com.example.orderstore.orderprovider/Customers/firstName";
    public static final String COLUMN_LAST_NAME= "com.example.orderstore.orderprovider/Customers/lastName";
    public static final String COLUMN_TELEPHONE= "com.example.orderstore.orderprovider/Customers/telephone";
    public static final String COLUMN_PASSWORD="com.example.orderstore.orderprovider/Customers/password";
    public static final String COLUMN_PRIVILEDGE="com.example.orderstore.orderprovider/Customers/priviledge";
    public static final String[] CUSTOMER_FIELDS= {BaseColumns._ID, COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_TELEPHONE, COLUMN_PASSWORD, COLUMN_PRIVILEDGE};
}
