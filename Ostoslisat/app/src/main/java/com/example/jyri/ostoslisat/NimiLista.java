package com.example.jyri.ostoslisat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NimiLista extends AppCompatActivity {

    public static ArrayList<String> shoppings = new ArrayList<String>();
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nimi_lista);

        // HAETAAN LISTAUS LISTVIEWHIN
        ListView nimiLista = (ListView)findViewById(R.id.nimiLista);

        if(shoppings !=null && shoppings.size()>0){
            //ADAPTERIN KÄYTTÖ KYTKETTÄESSÄ ARRAYLIST NÄYTÖN LIST LISTAAN
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shoppings.toArray(new String[1]));
            nimiLista.setAdapter(adapter);

            /*if(shoppings != null && shoppings.size() >0) {
             setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shoppings.toArray(new String[1])));
            } */

        }
    }
}
