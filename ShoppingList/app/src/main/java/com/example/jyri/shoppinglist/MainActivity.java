package com.example.jyri.shoppinglist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemsSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mnKenka:
                // TULOSTETAAN LOKIIN (LOGCAT) TESTI, NÄHDÄÄN REAGOIKO OHJELMA
                Log.d("Jyri", "Options menussa valittu Kenkä");
                return true;
            case R.id.mnPuhelin:
                naytaToast("Puhelin painettu");
                return true;
            case R.id.mnKenkapuhelin:
                // TULOSTETAAN LOKIIN (LOGCAT) TESTI, NÄHDÄÄN REAGOIKO OHJELMA
                Log.d("Jyri", "Options menussa valittu Kenkäpuhelin");
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
        setContentView(R.layout.activity_main);

        // LUODAAN TOOLBAR
        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // LUODAAN BUTTON PAINIKE
        Button btSecond;

        // LUODAAN XML-TIEDOSTOSTA VIITTAUS BUTTONIIN
        btSecond = (Button)findViewById(R.id.btSecond);

        // LUODAAN TAPAHTUMANKUUNTELIJA BUTTONILLE
        btSecond.setOnClickListener(new View.OnClickListener() {

            // ONCLICK METODISSA MÄÄRITETÄÄN MITÄ TAPAHTUU, KUN PAINIKETTA PAINETAAN
            public void onClick(View v) {


                // LUODAAN INTENT OLIO

                Intent siirrySeuraavaan = new Intent(MainActivity.this, SecondActivity.class);
                // KÄYNNISTETÄÄN TOINEN ACTIVITY
                startActivity(siirrySeuraavaan);
            }
        });


    }
}