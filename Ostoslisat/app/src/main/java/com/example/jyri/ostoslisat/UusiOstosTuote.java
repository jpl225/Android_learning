package com.example.jyri.ostoslisat;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class UusiOstosTuote extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.valikko, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mnOstosLista:
                // TULOSTETAAN LOKIIN (LOGCAT) TESTI, NÄHDÄÄN REAGOIKO OHJELMA
                Log.d("HUOM!", "Options menussa valittu Ostoslista");
                return true;
            case R.id.mnLisaaTuote:
                naytaToast("Tuotteen lisäystä painettu");
                return true;
            case R.id.mnOhjeet:
                // TULOSTETAAN LOKIIN (LOGCAT) TESTI, NÄHDÄÄN REAGOIKO OHJELMA
                Log.d("HUOM!", "Options menussa valittu Ohjeet");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    // NOTIFIKAATIO TOAST, TOAST ON POPUPIKKUNA, JOKA NÄKYY NOIN SEKUNNIN AJAN

    // APUMETODI
    public void naytaToast(String teksti){
        int aika = Toast.LENGTH_LONG;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, teksti, aika);
        toast.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uusi_ostos_tuote);

        // LUODAAN VALIKKO
        Toolbar minunValikko = (Toolbar)findViewById(R.id.valikko);
        setSupportActionBar(minunValikko);

        // LUODAAN VERKKONÄKYMÄOLIO
            WebView verkko;

        // LUODAAN VIITTAUS OLIOON XML-TIEDOSTOSTA
            verkko = (WebView)findViewById(R.id.verkkonakyma);

        // HTML-TIEDOSTON LATAAMINEN OLIOON
            verkko.loadUrl("file:///android_asset/ohjeet.html");
    }
}
