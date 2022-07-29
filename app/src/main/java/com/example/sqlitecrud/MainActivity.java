package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.nio.charset.StandardCharsets;

/**
 * This class take data to add data in data base
 */
public class MainActivity extends AppCompatActivity
{
    EditText sys, dias, hr,cmnt;
    Button sbmt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"This is homepage",Toast.LENGTH_SHORT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sys = findViewById(R.id.sysPress);
        dias =  findViewById(R.id.diasPress);
        hr =  findViewById(R.id.hrtRate);
        cmnt= findViewById(R.id.cmnt) ;
        sbmt = findViewById(R.id.sbmt_add);


        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                processinsert(sys.getText().toString(),dias.getText().toString(),hr.getText().toString(),cmnt.getText().toString());
            }
        });


    }

    /**
     * This function send data to the dbmanganer addrecord class
     * @param systolic
     * @param diastolic
     * @param heart_rate
     * @param comment
     */
    private void processinsert(String systolic, String diastolic, String heart_rate,String comment)
    {
        //Toast.makeText(getApplicationContext(),diastolic,Toast.LENGTH_SHORT).show();
       long res=new dbmanager(this).addrecord(systolic,diastolic,heart_rate,comment);
       sys.setText("");
       dias.setText("");
       hr.setText("");
       cmnt.setText("");
       String s="Failed";
       if(res!=-1)s="Successfull";
       Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
       Intent intent=new Intent(MainActivity.this,fetchdata.class);
       startActivity(intent);
       finish();


    }


 }

