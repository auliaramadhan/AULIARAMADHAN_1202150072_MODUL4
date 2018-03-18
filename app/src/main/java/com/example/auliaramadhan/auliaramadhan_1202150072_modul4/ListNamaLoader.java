package com.example.auliaramadhan.auliaramadhan_1202150072_modul4;

import android.app.ProgressDialog;
import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by Aulia Ramadhan on 17/03/2018.
 */

public class ListNamaLoader extends AsyncTaskLoader<String[]> {

    ProgressDialog dialog;

    public ListNamaLoader(Context context) {
        super(context);
        dialog = new ProgressDialog(context);
    }

    @Override
    public String[] loadInBackground() {
        String[] NamaSiswa = {"DIna", "Arya", "Lina", "Yanti",
                "Rani", "Dian", "Andika", "Aul"};

        try {
            for (int i = 0; NamaSiswa.length > i; ++i) {
                int slep = 400;
                Thread.sleep(slep);
                int progress = (i * 100) / NamaSiswa.length;
                dialog.setMessage(String.valueOf(progress));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            dialog.dismiss();
        }
        return NamaSiswa;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        dialog.setTitle("Mencari");
        dialog.setMessage(dialog.getProgress()+"");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setIndeterminate(true);
        dialog.setProgress(0);
        dialog.show();
    }
}
