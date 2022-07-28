package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * This fetch data activity fetches data from dbmanager
 */
public class fetchdata extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fb;
    ArrayList<model> dataholder;
    dbmanager mgr;

    /**
     * This function shows data in recyclerview
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);

        recyclerView=(RecyclerView)findViewById(R.id.recview);
        fb = (FloatingActionButton) findViewById(R.id.fbtn);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


        Cursor cursor=new dbmanager(this).readalldata();
        dataholder=new ArrayList<>();
        mgr=new dbmanager(this);
        while(cursor.moveToNext())
        {
            model obj=new model(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
            dataholder.add(obj);
        }
        SQLiteDatabase sqLiteDatabase=mgr.getReadableDatabase();
        myadapter adapter=new myadapter(getApplicationContext(),sqLiteDatabase,dataholder);
        recyclerView.setAdapter(adapter);

    }
}