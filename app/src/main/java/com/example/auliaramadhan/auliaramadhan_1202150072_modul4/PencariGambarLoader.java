package com.example.auliaramadhan.auliaramadhan_1202150072_modul4;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.AsyncTaskLoader;

/**
 * Created by Aulia Ramadhan on 17/03/2018.
 */

public class PencariGambarLoader extends AsyncTaskLoader<Bitmap> {

    private String mQueryString;
    public PencariGambarLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    public Bitmap loadInBackground() {
        return NetworkUtils.getImage(mQueryString);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
