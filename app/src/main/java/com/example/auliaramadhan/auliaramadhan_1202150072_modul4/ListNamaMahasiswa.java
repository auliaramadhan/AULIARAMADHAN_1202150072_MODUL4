package com.example.auliaramadhan.auliaramadhan_1202150072_modul4;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListNamaMahasiswa extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String[]>{

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nama_mahasiswa);
        listView = (ListView) findViewById(R.id.listview);

        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
    }

    public void ListNamaAsync(View view) {
        Bundle queryBundle = new Bundle();
        getSupportLoaderManager().restartLoader(0, queryBundle, this);
    }


    @Override
    public Loader<String[]> onCreateLoader(int id, Bundle args) {
        return new ListNamaLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<String[]> loader, String[] data) {
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, data);

        listView.setAdapter(adapter);

    }

    @Override
    public void onLoaderReset(Loader<String[]> loader) {

    }
}
