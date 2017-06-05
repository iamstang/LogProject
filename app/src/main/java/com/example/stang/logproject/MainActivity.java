package com.example.stang.logproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.stang.logproject.data.Day;
import com.example.stang.logproject.data.Repository;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity {

    Repository r = new Repository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if ( savedInstanceState != null ){
            onRestoreInstanceState( savedInstanceState );
            System.out.println("res");
        } else {
            init();
           // onSaveInstanceState( savedInstanceState );
        }


    }

    public void init(){

        System.out.println("init repo");

        r = new Repository();
        final ArrayAdapter<Day> adapter = new ArrayAdapter<Day>(this,android.R.layout.simple_list_item_1 , r.getList() );

        ListView listView = (ListView) findViewById(R.id.day_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Day day = adapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(),LogActivity.class);
                intent.putExtra("ss", Parcels.wrap(day));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putSerializable("repo",r);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        r = (Repository) savedInstanceState.getSerializable("repo");
    }
}
