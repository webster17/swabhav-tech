package com.swabhav.santosh.expensetracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;

import com.swabhav.santosh.expensetracker.repository.Expenses;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddExpenseActivity extends AppCompatActivity {

    private Calendar myCalendar = Calendar.getInstance();
    private TextInputEditText rupees, description, date;
    private AppCompatSpinner category;
    private FloatingActionButton saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        saveBtn = (FloatingActionButton) findViewById(R.id.saveBtn);
        rupees = (TextInputEditText) findViewById(R.id.rupees);
        description = (TextInputEditText) findViewById(R.id.description);
        date = (TextInputEditText) findViewById(R.id.date);
        category = (AppCompatSpinner) findViewById(R.id.category);

        final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updatedateInput();
            }
        };

        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddExpenseActivity.this, dateSetListener, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validData(view)){
                    saveExpense(view);
                }
            }
        });
    }

    private void updatedateInput() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
        date.setText(sdf.format(myCalendar.getTime()));
    }

    private void saveExpense(View view) {
        JSONObject expense = new JSONObject();
        try {
            expense.put("rs", Float.parseFloat(rupees.getText().toString()))
                    .put("date", date.getText().toString())
                    .put("description", description.getText().toString())
                    .put("category", Integer.parseInt(String.valueOf(category.getSelectedItemPosition())));
            Expenses.addExpenseItem(getBaseContext(), expense);
            setResult(1, new Intent().putExtra("message", "Successfully added!"));
            finish();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean validData(View view){
        if(rupees.getText().toString().equals("")) {
            makeSnackBar(view, "Rupee field must be required!");
            return false;
        }
        if(description.getText().toString().equals("")){
            makeSnackBar(view, "Description field must be required!");
            return false;
        }
        if(date.getText().toString().equals("")) {
            makeSnackBar(view, "Date field must be required!");
            return false;
        }
        return true;
    }

    private void makeSnackBar(View view, String message){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}