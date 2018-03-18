package com.example.auliaramadhan.auliaramadhan_1202150072_modul4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Aulia Ramadhan on 17/03/2018.
 */

public class NetworkUtils {

    public static Bitmap getImage(String mQueryString) {
        String urldisplay = mQueryString;
        Bitmap mIcon11 = null;
        try {
            URL url = new URL(urldisplay);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            mIcon11 = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        } finally {
            return mIcon11;
        }

    }
}
