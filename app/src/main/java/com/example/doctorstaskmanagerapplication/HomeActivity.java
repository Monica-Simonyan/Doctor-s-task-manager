package com.example.doctorstaskmanagerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorstaskmanagerapplication.patient.Patient;
import com.example.doctorstaskmanagerapplication.patient.PatientCard;
import com.example.doctorstaskmanagerapplication.patient.PatientsAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>HomeActivity</code> is the class responsible for the actions going on in the
 * home page of the app
 */
public class HomeActivity extends AppCompatActivity implements PatientCardViewable {
    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Categories> categories = new ArrayList<>();
    ListView patientListView;
    PatientsAdapter patientsAdapter;

    int[] patientImages = {R.drawable.patient_default_image, R.drawable.patient_default_image,
            R.drawable.patient_default_image, R.drawable.patient_default_image,
            R.drawable.patient_default_image, R.drawable.sponge_bob,
            R.drawable.patient_default_image, R.drawable.patient_default_image};


    /**
     * initializes the <code>HomeActivity</code> activity
     * @param savedInstanceState     <code>Bundle</code> savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        RecyclerView recyclerViewCategories = findViewById(R.id.horizontalRecyclerView);
        RecyclerView recyclerView = findViewById(R.id.VerticalRecyclerView);

        FloatingActionButton addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            /**
             * makes it possible to go from <code>HomeActivity</code> to <code>AddPatientActivity</code>
             * by clicking at the add button
             * @param view     the <code>View</code> view
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AddPatientActivity.class);
                startActivity(intent);
            }
        });
        setCategories();
        setPatients();


        CategoriesAdapter adapterCat = new CategoriesAdapter(this, categories);
        recyclerViewCategories.setAdapter(adapterCat);
        recyclerViewCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



        patientsAdapter = new PatientsAdapter(this, patients, this);
        recyclerView.setAdapter(patientsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SearchView searchView = findViewById(R.id.searchView);
        //searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            /**
             * implements the process of searching and finding a patient
             * @param newText the new content of the query text field.
             *
             * @return     <code>boolean</code> true
             */
            @Override
            public boolean onQueryTextChange(String newText) {
                filterPatients(newText);
                return true;
            }
        });
    }

    /**
     * Sets the list of patients to be displayed on the home page
     */
    private void setPatients(){
        String[] patientNames = getResources().getStringArray(R.array.patientName);
        String[] patientAges = getResources().getStringArray(R.array.patientAge);
        String[] patientLastVisit = getResources().getStringArray(R.array.patientLastVisitDate);
        String[] patientHistory = getResources().getStringArray(R.array.patientHistory);

        for(int i = 0; i < patientNames.length; i++){
            patients.add(new Patient(patientNames[i], patientAges[i],
                    patientLastVisit[i], patientHistory[i], patientImages[i]));
        }
    }


    /**
     * Sets the list of categories of patients
     */
    private void setCategories(){
        String[] patientCategories = getResources().getStringArray(R.array.patientCategories);
        for(int i = 0; i < patientCategories.length; i++){
            categories.add(new Categories(patientCategories[i]));
        }
    }


    /**
     * Makes it possible to click on a patient and get to see his/her medical card
     */
    @Override
    public void onPatientClick(int position) {
        Intent intent = new Intent(HomeActivity.this, PatientCard.class);
        intent.putExtra("Name", patients.get(position).getName());
        intent.putExtra("Age", patients.get(position).getAge());
        intent.putExtra("LastVisit", patients.get(position).getLastDate());
        intent.putExtra("History", patients.get(position).getHistory());
        intent.putExtra("Image", patients.get(position).getImage());

        startActivity(intent);
    }


    /**
     * Filters the patients and finds the one the user searches for
     */
    private void filterPatients(String text){
        List<Patient> filtered = new ArrayList<>();
        for(Patient p: patients){
            if(p.getName().toLowerCase().contains(text.toLowerCase())){
                filtered.add(p);
            }
        }
        patientsAdapter.filterPatients(filtered);
    }
}