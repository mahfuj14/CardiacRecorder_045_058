package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

/**
 * This class updates data of a single row
 */
public class update extends AppCompatActivity {

    TextInputLayout sys, dias, hr,cmnt;

    Button sbmt;

    /**
     * This class is for updating data activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        sys = (TextInputLayout) findViewById(R.id.upSYs);
        dias = (TextInputLayout) findViewById(R.id.updias);
        hr = (TextInputLayout) findViewById(R.id.uphrtRate);
        cmnt= (TextInputLayout) findViewById(R.id.upcomment) ;
        sbmt = (Button) findViewById(R.id.sbmt_up);

        Bundle bundle = getIntent().getBundleExtra("userdata");
        final int id = bundle.getInt("id");
        String s1 = bundle.getString("systolic");
        String s2 = bundle.getString("diastolic");
        String s3 = bundle.getString("pulse");
        String s4 = bundle.getString("comment");

        sys.getEditText().setText(s1);
        dias.getEditText().setText(s2);
        hr.getEditText().setText(s3);
        cmnt.getEditText().setText(s4);
        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editAction(id,sys.getEditText().getText().toString(),dias.getEditText().getText().toString(),hr.getEditText().getText().toString(),cmnt.getEditText().getText().toString());
            }
        });
    }

    /**
     * This function is update button for updating data
     * @param id
     * @param s1
     * @param s2
     * @param s3
     * @param s4
     */
    private void editAction(Integer id,String s1, String s2, String s3, String s4) {
        long recedit=new dbmanager(this).updateRecod(id,s1,s2,s3,s4);
        if(recedit!=-1)
        {
            Toast.makeText(getApplicationContext(),"Update Successfully",Toast.LENGTH_SHORT).show();
            sys.getEditText().setText("");
            dias.getEditText().setText("");
            cmnt.getEditText().setText("");
            hr.getEditText().setText("");
            Intent intent=new Intent(getApplicationContext(),fetchdata.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
        }
    }


}