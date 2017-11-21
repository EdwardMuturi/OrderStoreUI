package com.example.sasalog.orderstoreui;

import android.app.LoaderManager;
import android.content.ContentProviderClient;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener{

    private static  String TAG= "ContentProviderDemo";
    private int MY_PERMISSIONS_REQUEST_READ_ORDERSTORE= 20;

    private boolean firstTimeLoaded= false;

    private TextView textViewQueryResult;
    private Button buttonLoadData;
    private static String CUSTOMER_BASE_PATH= "com.example.orderstore.orderprovider/Customers";
    public static final Uri CUSTOMER_CONTENT_URI= Uri.parse("content://" + CUSTOMER_BASE_PATH);

    private CursorAdapter cursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] mProjection={BaseColumns._ID,  "firstName"};
        String mSelectionClause= null;
        String[] mSelectionArgs= null;

        Cursor mCursor=getContentResolver().query(CUSTOMER_CONTENT_URI, mProjection, mSelectionClause, mSelectionArgs, null);

        String[] from={"firstName"};
        int[] to= {android.R.id.text1};
        cursorAdapter= new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, mCursor, from, to, 0);

        ListView list= (ListView) findViewById(android.R.id.list);
        list.setAdapter(cursorAdapter);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onClick(View view) {

    }
}
