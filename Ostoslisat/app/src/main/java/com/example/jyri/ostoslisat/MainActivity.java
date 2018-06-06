package com.example.jyri.ostoslisat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
                // LUODAAN INTENT-OLIO
                Intent siirryPaasivulle = new Intent (MainActivity.this, MainActivity.class);
                // KÄYNNISTETÄN SIIRTYMINEN
                startActivity(siirryPaasivulle);
                return true;
            case R.id.mnLisaaTuote:
                naytaToast("Tuotteen lisäystä painettu");
                // LUODAAN INTENT-OLIO
                Intent siirrySyottosivulle = new Intent (MainActivity.this, syottolomake.class);
                // KÄYNNISTETÄN SIIRTYMINEN
                startActivity(siirrySyottosivulle);
                return true;
            case R.id.mnOhjeet:
                // TULOSTETAAN LOKIIN (LOGCAT) TESTI, NÄHDÄÄN REAGOIKO OHJELMA
                Log.d("HUOM!", "Options menussa valittu Ohjeet");
                // LUODAAN INTENT-OLIO
                Intent siirryInfosivulle = new Intent (MainActivity.this, UusiOstosTuote.class);
                // KÄYNNISTETÄN SIIRTYMINEN
                startActivity(siirryInfosivulle);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

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
        setContentView(R.layout.activity_main);

        // LUODAAN VALIKKO
        Toolbar minunValikko = (Toolbar)findViewById(R.id.valikko);
        setSupportActionBar(minunValikko);
        // LUODAAN PAINIKE
            Button btn;
        // LUODAAN VIITTAUS PAINIKKEESEEN XML-TIEDOSTOSTA
            btn = (Button)findViewById(R.id.painike);
        // LUODAAN TAPAHTUMANKUUNTELIJA PAINIKKEELLE
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // LUODAAN INTENT-OLIO
                        Intent siirryLisaykseen = new Intent (MainActivity.this, syottolomake.class);
                    // KÄYNNISTETÄN SIIRTYMINEN
                        startActivity(siirryLisaykseen);
                }
            });

    }
}
