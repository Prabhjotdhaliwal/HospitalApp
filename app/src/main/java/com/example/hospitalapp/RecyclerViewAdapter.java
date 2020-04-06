package com.example.hospitalapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
        //implements Filterable
{

    private View.OnClickListener itemlistener;

    private static final String TAG = "RecylerViewAdapter";
    private ArrayList<String> DoctorNames =new ArrayList<>();
    private ArrayList<String> DoctorSpeciality =new ArrayList<>();
    private ArrayList<String> Docfees =new ArrayList<>();
    private ArrayList<String> Doctimings =new ArrayList<>();

String   currentUser;

    Intent i;

    private Context mcontext;
    public RecyclerViewAdapter(Context context, ArrayList<String> DoctorNames,ArrayList<String> DoctorSpeciality,ArrayList<String> Docfeess,ArrayList<String> DOctimingss) {
        this.DoctorNames = DoctorNames;
        this.DoctorSpeciality=DoctorSpeciality;
        this.Docfees=Docfeess;
        this.Doctimings=DOctimingss;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doctorlistitem,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }


    public void setClickListener(View.OnClickListener itemlistener)
    {
        this.itemlistener=itemlistener;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, final int position)
    {
        Log.d(TAG,"OnBindViewHolder:called");

        holder.DoctorName.setText(DoctorNames.get(position));
        holder.DocSpeciality1.setText("Fee "+Docfees.get(position));
        holder.Doctordate.setText( DoctorSpeciality.get(position));
        holder.Doctime1.setText("Timing "+Doctimings.get(position));
        holder.R1.setOnClickListener(new View.OnClickListener()
        {
    @Override
    public void onClick(View v)
    {
        Log.d(TAG,"onClick:clicked On:"+DoctorNames.get(position));
        Toast.makeText(mcontext,DoctorNames.get(position),Toast.LENGTH_SHORT).show();
        Toast.makeText(mcontext,DoctorSpeciality.get(position),Toast.LENGTH_SHORT).show();
        String ddname=DoctorNames.get (position);
        String ddspec=DoctorSpeciality.get  (position);
        String docfee=Docfees.get (position);
        String doctiming=Doctimings.get (position);
        //Send doc info
      i=new Intent (mcontext,DoctorProfile.class);

        i.putExtra("dname1", ddname);
        i.putExtra("dspec1", ddspec);
        i.putExtra("dfee", docfee);
        i.putExtra("dtime", doctiming);
        i.putExtra("currentuserk", currentUser);

        // System.out.println (ddname);
       // System.out.println (ddspec);

        // i.putExtra ("DocName11",DoctorNames.get (position));
       // i.putExtra ("DocSpec11",DoctorSpeciality.get (position));
        mcontext.startActivity (i);
    }
   });

    }

    @Override
    public int getItemCount() {
        return DoctorNames.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView DoctorName;
        TextView DocSpeciality1;
        TextView Doctordate;
        TextView Doctime1;
        LinearLayout R1;

        public ViewHolder(@NonNull View itemView) {
            super (itemView);
            DoctorName = itemView.findViewById (R.id.text11);
            DocSpeciality1 = itemView.findViewById (R.id.text111);
            Doctordate=itemView.findViewById (R.id.text112);
            Doctime1=itemView.findViewById (R.id.text113);
            R1 = itemView.findViewById (R.id.r1);

        }

    }}

   /* @Override
    public Filter getFilter() {
        return searchFilter;
    }

    private Filter searchFilter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint)
        {
            List<Exa>
            List<> FilterDoctorNames =new ArrayList<>();

            if (constraint ==null || constraint.length()==0)
            {
                FilterDoctorNames.addAll(DoctorNames);
            }
            else
            {
                String filerPattern =constraint.toString().toLowerCase().trim();

                for (String item:DoctorNames)
                {
                    if (item.getText.)
                }
            }

            return null;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

        }
    }*/
