package com.example.listy_znowu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listaViewKategorie);
        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String kategoria = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, kategoria, Toast.LENGTH_LONG).show();
            }
        };
        listView.setOnItemClickListener(clickListener);

        ArrayList<String> slowa = new ArrayList<>();
        slowa.add("Podlać kwiaty");
        slowa.add("Wyprowadzić Psa");
        slowa.add("Wyczesać Psa");
        slowa.add("Schować Zmywarke");

        ArrayAdapter<String> slowaAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                slowa
        );
        ListView listView2 = findViewById(R.id.listViewDynamicznie);
        listView2.setAdapter(slowaAdapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText editText = findViewById(R.id.editText);
                        String wpisanyTekst = editText.getText().toString();
                        slowa.add(wpisanyTekst);
                        slowaAdapter.notifyDataSetChanged();
                    }
                }
        );
    }
}