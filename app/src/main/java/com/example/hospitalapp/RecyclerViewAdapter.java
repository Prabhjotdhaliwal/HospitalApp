package com.example.hospitalapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private static final String TAG = "RecylerViewAdapter";
    private ArrayList<String> DoctorNames =new ArrayList<>();
    private ArrayList<String> DoctorSpeciality =new ArrayList<>();
    private Context mcontext;
    public RecyclerViewAdapter(Context context, ArrayList<String> DoctorNames,ArrayList<String> DoctorSpeciality) {
        this.DoctorNames = DoctorNames;
        this.DoctorSpeciality=DoctorSpeciality;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorlistitem,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, final int position)
    {
        Log.d(TAG,"OnBindViewHolder:called");

        holder.DoctorName.setText(DoctorNames.get(position));
        holder.DocSpeciality1.setText(DoctorSpeciality.get(position));
        holder.R1.setOnClickListener(new View.OnClickListener()
        {
    @Override
    public void onClick(View v)
    {
        Log.d(TAG,"onClick:clicked On:"+DoctorNames.get(position));
        Toast.makeText(mcontext,DoctorNames.get(position),Toast.LENGTH_SHORT).show();

    }
   });

    }

    @Override
    public int getItemCount() {
        return DoctorNames.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView DoctorName;
        TextView DocSpeciality1;
        RelativeLayout R1;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            DoctorName=itemView.findViewById(R.id.text11);
            DocSpeciality1=itemView.findViewById(R.id.text111);
            R1=itemView.findViewById(R.id.r1);
        }
    }
}