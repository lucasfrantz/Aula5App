package com.lucasf.aula5app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class NamesListActivity extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_names_list);
        setListAdapter( new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listarNomes()) );
        ListView listView = getListView();
        listView.setOnItemClickListener( this );
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView)view;
        String nome = textView.getText().toString();
        Intent intent = new Intent( this, ActivityInfo.class );
        intent.putExtra("nome",nome);
        startActivity( intent );
    }
    private List<String> listarNomes()
    {
        return Arrays.asList( "Lucas","Astolfo","Ricardo","Alessandra" );
    }
}