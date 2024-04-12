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

public class PatientCard extends AppCompatActivity {
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
        TextView historyTextView = findViewById(R.id.cardHistory);
        ImageView imageView = findViewById(R.id.cardImage);
        Button back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
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
