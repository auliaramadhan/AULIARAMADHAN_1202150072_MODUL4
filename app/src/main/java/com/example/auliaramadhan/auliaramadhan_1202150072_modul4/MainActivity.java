package com.example.auliaramadhan.auliaramadhan_1202150072_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void keListNama(View view) {
        startActivity(new Intent(this, ListNamaMahasiswa.class));
    }

    public void kePencariGambar(View view) {
        startActivity(new Intent(this, PencariGambar.class));
    }
}
