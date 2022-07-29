package com.example.sqlitecrud;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class represents the data in a recyclerview
 */
public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    Context context;
    SQLiteDatabase sqLiteDatabase;
    ArrayList<model> dataholder;

    public myadapter(Context context, SQLiteDatabase sqLiteDatabase, ArrayList<model> dataholder) {
        this.context = context;
        this.sqLiteDatabase = sqLiteDatabase;
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myviewholder holder, int position)
    {
        Calendar calendar = Calendar.getInstance();
        String CurrentDate= DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(calendar.getTime());
        SimpleDateFormat format= new SimpleDateFormat("HH:mm");
        String CurrentTime= format.format(calendar.getTime());
        final model md=dataholder.get(position);
        holder.sysPress.setText("SysPress\n"+md.getSys());
        holder.diasPress.setText("DiasPress\n"+md.getDias());
        holder.heartRate.setText("HeartRate\n"+md.getHr());
        holder.dataTime.setText("DateTime "+CurrentDate+"  "+CurrentTime);

        int  x=Integer.parseInt(md.getSys());
        int y=Integer.parseInt(md.getDias());
        int z=Integer.parseInt(md.getHr());
        if((x>=90 && x<=140) && (y>=60 && y<=90) && (z>65 && z<85))
        {

            Integer f=R.drawable.good;
            holder.img.setImageResource(f);
        }


        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putInt("id",md.getId());
                bundle.putString("systolic",md.getSys());
                bundle.putString("diastolic",md.getDias());
                bundle.putString("pulse",md.getHr());
                bundle.putString("comment",md.getComment());
                Intent intent=new Intent(context,update.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("userdata",bundle);
                context.startActivity(intent);


            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dbmanager mgr=new dbmanager(context);
                String Table_name="Tbl_contact";
                SQLiteDatabase db=mgr.getReadableDatabase();
                long rec=db.delete(Table_name,"id="+md.getId(),null);
                if(rec!=-1)
                   {
                       Toast.makeText(context,"Delete Successfully", Toast.LENGTH_SHORT).show();
                       dataholder.remove(holder.getAdapterPosition());
                       notifyDataSetChanged();
                   }
                else
                {
                    Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    /**
     * This class returns all single row of output
     */
    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView sysPress,diasPress,heartRate,dataTime;
        Button edit,delete;
        ImageView img;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            sysPress=(TextView)itemView.findViewById(R.id.systolic);
            diasPress=(TextView)itemView.findViewById(R.id.diastolic);
            heartRate=(TextView)itemView.findViewById(R.id.heartRate);
            dataTime=(TextView)itemView.findViewById(R.id.dateTime);
            edit=(Button)itemView.findViewById(R.id.edit);
            delete=(Button) itemView.findViewById(R.id.deleteList);
            img=(ImageView) itemView.findViewById(R.id.status);
        }
    }

}
