package com.example.sasalog.orderstoreui;

import android.net.Uri;

/**
 * Created by sasalog on 11/21/17.
 */

public class ContentProviderContract {
    public static String CUSTOMER_BASE_PATH= "com.example.orderstore.orderprovider/Customers";
    public static final Uri CUSTOMER_CONTENT_URI= Uri.parse("content://" + CUSTOMER_BASE_PATH);
}
