package com.example.sqlitecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * This dbmanager helps to insert data to sqlite dbmanager
 */
public class dbmanager extends SQLiteOpenHelper
{
    private  static  final  String dbname="dbcontact";
    public dbmanager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String qry="create table tbl_contact (id integer primary key autoincrement, systolic text, diastolic text,pulse text, comment text, ms_date text,ms_time text)";
        sqLiteDatabase.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String qry="DROP TABLE IF EXISTS tbl_contact";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    public  long addrecord(String systolic, String diastolic ,String pulse, String comment)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("systolic",systolic);
        cv.put("diastolic",diastolic);
        cv.put("pulse",pulse);
        cv.put("comment",comment);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String ms_date = sdf.format(System.currentTimeMillis());

        SimpleDateFormat sd = new SimpleDateFormat("hh:mm");
        String ms_time = sd.format(System.currentTimeMillis());
        cv.put("ms_date",ms_date);
        cv.put("ms_time",ms_time);
        long res=db.insert("tbl_contact",null,cv);

       return  res;
    }

    public  long updateRecod(int id,String systolic, String diastolic ,String pulse, String comment)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("systolic",systolic);
        cv.put("diastolic",diastolic);
        cv.put("pulse",pulse);
        cv.put("comment",comment);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String ms_date = sdf.format(System.currentTimeMillis());

        SimpleDateFormat sd = new SimpleDateFormat("hh:mm");
        String ms_time = sd.format(System.currentTimeMillis());


        cv.put("ms_date",ms_date);
        cv.put("ms_time",ms_time);
        long res=db.update("tbl_contact",cv,"id="+id,null);
        return res;
    }


    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from tbl_contact order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return cursor;
    }

    public long delete(int id)
    {
        String Table_name="Tbl_contact";
        SQLiteDatabase db=this.getWritableDatabase();
        long rec=db.delete(Table_name,"id="+id,null);
        return rec;
    }
}
