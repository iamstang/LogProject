package com.example.stang.logproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.stang.logproject.data.Day;
import com.example.stang.logproject.data.Log;

import org.parceler.Parcels;

public class LogActivity extends AppCompatActivity{

    Day d;
    ListView logListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);


        init();
        load();

    }

    public void load(){

        final ArrayAdapter<Log> logAdapter = new ArrayAdapter<Log>(this,android.R.layout.simple_list_item_1,d.getLogList());
        logListView.setAdapter(logAdapter);

    }

    public void init(){

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                startActivityForResult(intent , 1);
            }
        });

        Button delete = (Button) findViewById(R.id.button3);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DeleteActivity.class);
                intent.putExtra("ss", Parcels.wrap(d));
                startActivityForResult(intent,2);
            }
        });

        Intent intent = getIntent();

        d = Parcels.unwrap(intent.getParcelableExtra("ss"));
        logListView = (ListView) findViewById(R.id.log_list);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String result = "";
        int a = 0;
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                result = data.getStringExtra("result");
                d.addLog(new Log(result));
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        } else if ( requestCode == 2 ){
            a =(int) data.getIntExtra("index" , 99);
            System.out.println(a);
            try{
                d.getLogList().remove(a);
            } catch ( Exception e){

            }

        }

        load();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putSerializable("day",d);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        d = (Day) savedInstanceState.getSerializable("day");
    }
}
