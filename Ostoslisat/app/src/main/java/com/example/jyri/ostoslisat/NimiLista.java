package com.example.jyri.ostoslisat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class NimiLista extends AppCompatActivity {
    public static int firstTime = 1;

    // Menu

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
                Intent siirryPaasivulle = new Intent (NimiLista.this, MainActivity.class);
                // KÄYNNISTETÄN SIIRTYMINEN
                startActivity(siirryPaasivulle);
                return true;
            case R.id.mnLisaaTuote:
                naytaToast("Tuotteen lisäystä painettu");
                // LUODAAN INTENT-OLIO
                Intent siirrySyottosivulle = new Intent (NimiLista.this, syottolomake.class);
                // KÄYNNISTETÄN SIIRTYMINEN
                startActivity(siirrySyottosivulle);
                return true;
            case R.id.mnLista:
                // TULOSTETAAN LOKIIN (LOGCAT) TESTI, NÄHDÄÄN REAGOIKO OHJELMA
                Log.d("HUOM!", "Options menussa valittu Lista");
                // LUODAAN INTENT-OLIO
                Intent siirryListasivulle = new Intent (NimiLista.this, NimiLista.class);
                // KÄYNNISTETÄN SIIRTYMINEN
                startActivity(siirryListasivulle);
                return true;
            case R.id.mnOhjeet:
                // TULOSTETAAN LOKIIN (LOGCAT) TESTI, NÄHDÄÄN REAGOIKO OHJELMA
                Log.d("HUOM!", "Options menussa valittu Ohjeet");
                // LUODAAN INTENT-OLIO
                Intent siirryInfosivulle = new Intent (NimiLista.this, UusiOstosTuote.class);
                // KÄYNNISTETÄN SIIRTYMINEN
                startActivity(siirryInfosivulle);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    // Menu loppuu
    // NOTIFIKAATIO TOAST, TOAST ON POPUPIKKUNA, JOKA NÄKYY NOIN SEKUNNIN AJAN

    // APUMETODI
    public void naytaToast(String teksti){
        int aika = Toast.LENGTH_LONG;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, teksti, aika);
        toast.show();

    }


    public static ArrayList<String> shoppings = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nimi_lista);
        if (firstTime == 1) {
            lataaSharedPreferences();
            firstTime = 0;
        }

        // LUODAAN VALIKKO
        Toolbar minunValikko = (Toolbar)findViewById(R.id.valikko);
        setSupportActionBar(minunValikko);

        // HAETAAN LISTAUS LISTVIEWHIN
        ListView nimiLista = (ListView)findViewById(R.id.nimiLista);


        if(shoppings !=null && shoppings.size()>0){
            //ADAPTERIN KÄYTTÖ KYTKETTÄESSÄ ARRAYLIST NÄYTÖN LIST LISTAAN
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shoppings.toArray(new String[1]));
            nimiLista.setAdapter(adapter);
            tallennaSharedPreferences();
        }

    }
    // METODI, JOKA LUKEE SHAREDPREFERENCESTÄ ELI TIEDOSTOSTA
    private void lataaSharedPreferences() {
        SharedPreferences omaSharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String ostoksetString = omaSharedPreferences.getString("ostokset", "");
        StringTokenizer tokenizer = new StringTokenizer(ostoksetString, "|");
        while(tokenizer.hasMoreTokens()) {
            shoppings.add(tokenizer.nextToken());
        }
    }

    // METODI, JOKA TALLENTAA SHAREDPREFENCEEN ELI TIEDOSTOSTA
    private void tallennaSharedPreferences() {
        SharedPreferences omaSharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String ostoksetString = "";
        for(int i = 0; i < shoppings.size(); i++) {
            ostoksetString += shoppings.get(i) + "|";
        }
        SharedPreferences.Editor editor = omaSharedPreferences.edit();
        editor.putString("ostokset", ostoksetString);
        editor.commit();
    }

    // ELINKAARIMETODI ONPAUSE TOTEUTETAAN, JOSSA TALLENNETAAN OSTOKSET
    @Override
    protected void onDestroy() {
        super.onDestroy();
        tallennaSharedPreferences();
    }

}