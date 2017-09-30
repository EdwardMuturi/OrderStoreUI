package com.example.sasalog.orderstoreui;

import android.app.LoaderManager;
import android.content.ContentProviderClient;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener{

    private static  String TAG= "ContentProviderDemo";
    private int MY_PERMISSIONS_REQUEST_READ_ORDERSTORE= 20;

    private boolean firstTimeLoaded= false;

    private TextView textViewQueryResult;
    private Button buttonLoadData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri= Uri.parse("content://com.example.orderstore.orderprovider");
        ContentProviderClient contentResolver= getContentResolver().acquireContentProviderClient(uri);
        try {
            Cursor cursor;
            cursor = contentResolver.query(uri,null, null, null, null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
