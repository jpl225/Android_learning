package com.example.jyri.shoppinglist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // LUO WEBNÄKYMÄ OLIO
        WebView ruokalistaWebView;

        // XML-LAYOUTISTA WEBNÄKYMÄN VIITTAUKSEN HAKEMINEN JA TYYPPIMUUNNOS
        ruokalistaWebView = (WebView)findViewById(R.id.WebViewRuokalista);

        // HTMLTIEDOSTON LATAAMINEN WEB-NÄKYMÄÄN
        ruokalistaWebView.loadUrl("file:///android_asset/ruokalista.html");
    }

}
