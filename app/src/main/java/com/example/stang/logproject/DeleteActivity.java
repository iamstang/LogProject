package com.example.stang.logproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.stang.logproject.data.Day;
import com.example.stang.logproject.data.Log;

import org.parceler.Parcels;

public class DeleteActivity extends AppCompatActivity {
    Day d;
    ListView logListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Intent intent = getIntent();
        d = Parcels.unwrap(intent.getParcelableExtra("ss"));
        logListView = (ListView) findViewById(R.id.deletelog_list);
        final ArrayAdapter<Log> logAdapter = new ArrayAdapter<Log>(this,android.R.layout.simple_list_item_1,d.getLogList());
        logListView.setAdapter(logAdapter);
        logListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("index", position);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
