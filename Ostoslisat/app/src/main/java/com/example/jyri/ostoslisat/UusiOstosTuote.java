package com.example.jyri.ostoslisat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class UusiOstosTuote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uusi_ostos_tuote);

        // LUODAAN VERKKONÄKYMÄOLIO
            WebView verkko;

        // LUODAAN VIITTAUS OLIOON XML-TIEDOSTOSTA
            verkko = (WebView)findViewById(R.id.verkkonakyma);

        // HTML-TIEDOSTON LATAAMINEN OLIOON
            verkko.loadUrl("file:///android_asset/ohjeet.html");
    }
}
