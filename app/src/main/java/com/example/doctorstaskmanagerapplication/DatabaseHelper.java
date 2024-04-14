package com.example.doctorstaskmanagerapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Date;

/**
 * <code>DatabaseHelper</code> class sets the database necessary to add patients
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "PatientsList.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "task_manager";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "patient_names";
    private static final String COLUMN_AGE = "patient_age";
    private static final String COLUMN_VISIT_DATE = "patient_visit_date"; // next visit date

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        "( " + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_AGE + " TEXT, " +
                        COLUMN_VISIT_DATE + "TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Date nextVisit?

    /**
     * adds a patient to the existing list of patients
     * @param name       the <code>String</code> name of the patient
     * @param age        the <code>String</code> age of the patient
     * @param nextVisit  the <code>String</code> date of the patient's
     *                   next visit
     */
    void addPatient(String name, String age, String nextVisit){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_AGE, age);
        cv.put(COLUMN_VISIT_DATE, String.valueOf(nextVisit));
        
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Patient added successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
