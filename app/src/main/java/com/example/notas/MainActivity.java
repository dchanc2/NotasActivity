package com.example.notas;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {

    ListView mlistView;
    Button mbtnagregar;
    EditText medittext;
    List<String> mLista = new ArrayList<>();
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnagregar.findViewById(R.id.btnagregar);
        mbtnagregar.setOnClickListener(this);
        mlistView.findViewById(R.id.list_data);
        mlistView.setOnClickListener(this);
        medittext = findViewById(R.id.edit_list);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnagregar: String texto = medittext.getText().toString().trim();
            mLista.add(texto);
            medittext.getText().clear();
            mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mLista);
            mlistView.setAdapter(mAdapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "Item Clicked"+ position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected ( MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_done){
            String itemSelected = "Selected items: \n";
            for (int i=0;i <mlistView.getCount();i++){
                if (mlistView.isItemChecked(i));{
                    itemSelected += mlistView.getItemAtPosition(i) + "\n";
                }
            }
            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}