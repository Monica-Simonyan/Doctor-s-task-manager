package com.example.doctorstaskmanagerapplication.patient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorstaskmanagerapplication.PatientCardViewable;
import com.example.doctorstaskmanagerapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>PatientsAdapter</code> sets the recyclerview that displays the list of the patients
 * the doctor has
 */
public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.MyViewHolder> {

    Context context;
    ArrayList<Patient> patients;
    private final PatientCardViewable patientCardInterface;

    /**
     * initializes the fields of a <code>PatientsAdapter</code> object
     * @param context               the <code>Context</code> context
     * @param patients              the <code>ArrayList<Patient></code> patients
     * @param patientCardInterface  the <code>PatientCardViewable</code> patientCardInterface
     */
    public PatientsAdapter(Context context, ArrayList<Patient> patients, PatientCardViewable patientCardInterface){
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

    /**
     * returns the size of the <code>ArrayList<Patient></code>
     * @return the size of the <code>ArrayList<Patient></code>
     */
    @Override
    public int getItemCount() {
        return patients.size();
    }

    /**
     * filters the <code>List<Patient></code> to display the patient
     * the user was searching for
     * @param filtered
     */
    public void filterPatients(List<Patient> filtered){
        patients = (ArrayList<Patient>) filtered;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView age;
        TextView date;
        ImageView image;

        public MyViewHolder(@NonNull View itemView, PatientCardViewable patientCardInterface) {
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
