package com.example.auliaramadhan.auliaramadhan_1202150072_modul4;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PencariGambar extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Bitmap>{

    private EditText urigambar;
    private ImageView gambar;
    private TextView alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencari_gambar);
        urigambar = (EditText) findViewById(R.id.uri);
        gambar = (ImageView) findViewById(R.id.gambar);
        alert = (TextView) findViewById(R.id.networkalert);

        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
    }

    public void PencariGambarAsync(View view) {

        // Get the search string from the input field.

        String queryString = urigambar.getText().toString();

        // Hide the keyboard when the button is pushed.
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        // Check the status of the network connection.
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If the network is active and the search field is not empty,
        // add the search term to the arguments Bundle and start the loader.

        if (networkInfo != null && networkInfo.isConnected() && queryString.length()!=0) {
            alert.setText(R.string.loading);
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);
        }

        // Otherwise update the TextView to tell the user there is no connection or no search term.
        else {

            if (queryString.length() == 0) {
                alert.setText(R.string.no_search_term);
            } else {
                alert.setText(R.string.no_network);
            }
        }
    }

    @Override
    public Loader<Bitmap> onCreateLoader(int id, Bundle args) {
        return new PencariGambarLoader(this, args.getString("queryString"));
    }

    @Override
    public void onLoadFinished(Loader<Bitmap> loader, Bitmap data) {
        alert.setText("");
        gambar.setImageBitmap(data);
    }

    @Override
    public void onLoaderReset(Loader<Bitmap> loader) {

    }

}
