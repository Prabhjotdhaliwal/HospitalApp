package com.example.hospitalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderapt> {
    private ArrayList<String> DoctorName =new ArrayList<>();
    private ArrayList<String> DoctorFee =new ArrayList<>();
    private ArrayList<String> datelist =new ArrayList<>();
    private ArrayList<String> timingslist =new ArrayList<>();

    private Context mcontext;
    public RecyclerAdapter(Context context, ArrayList<String> DoctorNames,ArrayList<String> DoctorSpeciality,ArrayList<String> Docfeess,ArrayList<String> DOctimingss) {
        this.DoctorName = DoctorNames;
        this.DoctorFee=DoctorSpeciality;
        this.datelist=Docfeess;
        this.timingslist=DOctimingss;
        this.mcontext = context;
    }
    @NonNull
    @Override

    public ViewHolderapt onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.appointmentlist,parent,false);
        ViewHolderapt viewHolderapt=new ViewHolderapt (view);
        return viewHolderapt;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderapt holder, int position) {
        holder.DoctorName.setText(DoctorName.get(position));
        holder.Docfee.setText(DoctorFee.get(position));
        holder.aptdate.setText(datelist.get(position));
        holder.apttime.setText(timingslist.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderapt extends RecyclerView.ViewHolder {
        TextView DoctorName;
        TextView Docfee;
        TextView aptdate;
        TextView apttime;

        LinearLayout l1;

        public ViewHolderapt(@NonNull View itemView) {
            super (itemView);
            DoctorName = itemView.findViewById (R.id.Doctorname1);
            Docfee = itemView.findViewById (R.id.aptFee);
            aptdate = itemView.findViewById (R.id.aptdate);
            apttime = itemView.findViewById (R.id.aptiming);
            l1 = itemView.findViewById (R.id.l1);

        }

    }}
