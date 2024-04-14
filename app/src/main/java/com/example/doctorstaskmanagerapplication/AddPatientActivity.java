package com.example.doctorstaskmanagerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * <code>AddPatientActivity</code> is the class responsible for adding patients
 * to the list of patients displayed on the home page
 */
public class AddPatientActivity extends AppCompatActivity {

    EditText name, age, visitDate;
    Button button, back;

    /**
     * initializes the <code>AddPatientActivity</code> activity
     * @param savedInstanceState     <code>Bundle</code> savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_patient_layout);

        name = findViewById(R.id.addPatientName);
        age = findViewById(R.id.addPatientAge);
        visitDate = findViewById(R.id.addPatientVisitDate);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * allows the attempt to add a patient to the list of patients
             * by clicking on the add button
             * @param view     <code>View</code> view
             */
            @Override
            public void onClick(View view) {
                try {
                    DatabaseHelper dh = new DatabaseHelper(AddPatientActivity.this);
                    dh.addPatient(name.getText().toString().trim(),
                            age.getText().toString().trim(),
                            visitDate.getText().toString().trim());
                    throw new CannotAddPatientException();
                }
                catch (CannotAddPatientException e){
                    e.printStackTrace();
                }
            }
        });

        back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {

            /**
             * makes it possible to go from <code>AddPatientActivity</code> to <code>HomeActivity</code>
             * by clicking on the arrow button
             * @param view     the <code>View</code> view
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddPatientActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}