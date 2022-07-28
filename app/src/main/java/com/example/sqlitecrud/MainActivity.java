package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.nio.charset.StandardCharsets;

/**
 * This class take data to add data in data base
 */
public class MainActivity extends AppCompatActivity
{
    TextInputLayout sys, dias, hr,cmnt;

    Button sbmt;

    /**
     * This function takes input from user and shows in another page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sys = (TextInputLayout) findViewById(R.id.sysPress);
        dias = (TextInputLayout) findViewById(R.id.diasPress);
        hr = (TextInputLayout) findViewById(R.id.hrtRate);
        cmnt= (TextInputLayout) findViewById(R.id.comment) ;
        sbmt = (Button) findViewById(R.id.sbmt_add);


            sbmt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    processinsert(sys.getEditText().getText().toString(),dias.getEditText().getText().toString(),hr.getEditText().getText().toString(),cmnt.getEditText().getText().toString());
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
       sys.getEditText().setText("");
       dias.getEditText().setText("");
       hr.getEditText().setText("");
       cmnt.getEditText().setText("");
       String s="Failed";
       if(res!=-1)s="Successfull";
       Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();


    }


 }

