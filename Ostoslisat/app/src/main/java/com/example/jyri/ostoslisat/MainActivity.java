package com.example.jyri.ostoslisat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // LUODAAN PAINIKE
            Button btn;
        // LUODAAN VIITTAUS PAINIKKEESEEN XML-TIEDOSTOSTA
            btn = (Button)findViewById(R.id.painike);
        // LUODAAN TAPAHTUMANKUUNTELIJA PAINIKKEELLE
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // LUODAAN INTENT-OLIO
                        Intent siirryLisaykseen = new Intent (MainActivity.this, UusiOstosTuote.class);
                    // KÄYNNISTETÄN SIIRTYMINEN
                        startActivity(siirryLisaykseen);
                }
            });

    }
}
