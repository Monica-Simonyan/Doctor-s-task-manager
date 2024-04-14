package com.example.doctorstaskmanagerapplication.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doctorstaskmanagerapplication.HomeActivity;
import com.example.doctorstaskmanagerapplication.R;

/**
 * <code>PatientCard</code> class is responsible for implementing the activities
 * on the pages of the medical cards of the patients
 */
public class PatientCard extends AppCompatActivity {

    /**
     * initializes the <code>PatientCard</code> activity
     * @param savedInstanceState     <code>Bundle</code> savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_card_layout);

        String name = getIntent().getStringExtra("Name");
        String age = getIntent().getStringExtra("Age");
        String lastVisit = getIntent().getStringExtra("LastVisit");
        String history = getIntent().getStringExtra("History");
        int image = getIntent().getIntExtra("Image", 0);

        TextView nameTextView = findViewById(R.id.cardName);
        TextView ageTextView = findViewById(R.id.cardAge);
        TextView lastVisitTextView = findViewById(R.id.cardLastVisit);
        TextView historyTextView = findViewById(R.id.cardAllergies);
        ImageView imageView = findViewById(R.id.cardImage);
        Button back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            /**
             * allows the user to go from <code>PatientCard</code> to <code>HomeActivity</code>
             * by clicking on the arrow button
             * @param view
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientCard.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        nameTextView.setText(name);
        ageTextView.setText(age);
        lastVisitTextView.setText(lastVisit);
        historyTextView.setText(history);
        imageView.setImageResource(image);
    }
}
