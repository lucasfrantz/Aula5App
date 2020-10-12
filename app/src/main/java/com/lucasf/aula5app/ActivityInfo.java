package com.lucasf.aula5app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityInfo extends Activity {

    ListView citiesList;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Spinner ufs =   (Spinner)findViewById(R.id.spinner);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText( getIntent().getStringExtra("nome"));

        citiesList = (ListView)findViewById(R.id.listCities);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,
                R.array.estados,
                android.R.layout.simple_spinner_item );

        ufs.setAdapter( adapter );

        ufs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView)view;
                switch( textView.getText().toString() )
                {
                    case "RS":
                        ArrayAdapter<CharSequence> adapterRs = ArrayAdapter.createFromResource( ActivityInfo.this,
                                R.array.cidadesRS,
                                android.R.layout.simple_list_item_1 );
                        citiesList.setAdapter( adapterRs );
                        break;
                    case "SC":
                        ArrayAdapter<CharSequence> adapterSc = ArrayAdapter.createFromResource( ActivityInfo.this,
                                R.array.cidadesSC,
                                android.R.layout.simple_list_item_1 );
                        citiesList.setAdapter( adapterSc );
                        break;
                    case "PR":
                        ArrayAdapter<CharSequence> adapterPr = ArrayAdapter.createFromResource( ActivityInfo.this,
                                R.array.cidadesPR,
                                android.R.layout.simple_list_item_1 );
                        citiesList.setAdapter( adapterPr );
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
