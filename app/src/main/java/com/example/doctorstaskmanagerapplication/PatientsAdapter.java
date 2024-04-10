package com.example.doctorstaskmanagerapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.MyViewHolder> {

    Context context;
    ArrayList<Patients> patients;
    private final PatientCardInterface patientCardInterface;

    public PatientsAdapter(Context context, ArrayList<Patients> patients, PatientCardInterface patientCardInterface){
        this.context = context;
        this.patients = patients;
        this.patientCardInterface = patientCardInterface;
    }


    @NonNull
    @Override
    public PatientsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.patient_view, parent, false);
        return new PatientsAdapter.MyViewHolder(view, patientCardInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientsAdapter.MyViewHolder holder, int position) {
        holder.name.setText(patients.get(position).getName());
        holder.age.setText(patients.get(position).getAge());
        holder.date.setText(patients.get(position).getLastDate());
        holder.image.setImageResource(patients.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView age;
        TextView date;
        ImageView image;

        public MyViewHolder(@NonNull View itemView, PatientCardInterface patientCardInterface) {
            super(itemView);

            name = itemView.findViewById(R.id.patientName);
            age = itemView.findViewById(R.id.patientAge);
            date = itemView.findViewById(R.id.patientLastVisit);
            image = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(patientCardInterface != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            patientCardInterface.onPatientClick(position);
                        }
                    }
                }
            });
        }
    }
}
