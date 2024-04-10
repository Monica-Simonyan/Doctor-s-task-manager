package com.example.doctorstaskmanagerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPatientActivity extends AppCompatActivity {

    EditText name, age, visitDate;
    Button button, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_patient_layout);

        name = findViewById(R.id.addPatientName);
        age = findViewById(R.id.addPatientAge);
        visitDate = findViewById(R.id.addPatientVisitDate);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper dh = new DatabaseHelper(AddPatientActivity.this);
                dh.addPatient(name.getText().toString().trim(),
                        //Integer.valueOf(age.getText().toString().trim()),
                        age.getText().toString().trim(),
                        visitDate.getText().toString().trim());
            }
        });

        back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddPatientActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}