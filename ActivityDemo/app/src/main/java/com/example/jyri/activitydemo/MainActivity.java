package com.example.jyri.activitydemo;

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

        // LUODAAN BUTTON PAINIKE
        Button btSecond;

        // LUODAAN XML-TIEDOSTOSTA VIITTAUS BUTTONIIN
        btSecond = (Button) findViewById(R.id.btSecond);

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