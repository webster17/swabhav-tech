package com.swabhav.santosh.expensetracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;

import com.swabhav.santosh.expensetracker.repository.Expenses;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UpdateExpenseActivity extends AppCompatActivity {

    private Calendar myCalendar = Calendar.getInstance();
    private TextInputEditText rupees, description, date;
    private AppCompatSpinner category;
    private FloatingActionButton saveBtn;
    private JSONObject expense;
    private int id;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_expense);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        saveBtn = (FloatingActionButton) findViewById(R.id.saveBtn);
        rupees = (TextInputEditText) findViewById(R.id.rupees);
        description = (TextInputEditText) findViewById(R.id.description);
        date = (TextInputEditText) findViewById(R.id.date);
        category = (AppCompatSpinner) findViewById(R.id.category);
        id= getIntent().getIntExtra("id", -1);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("button", "Clickked");
            }
        });

        try {
            expense = Expenses.getExpenseItem(this, id);
            rupees.setText(String.valueOf(expense.getString("rs")));
            description.setText(String.valueOf(expense.getString("description")));
            date.setText(String.valueOf(expense.getString("date")));
            category.setSelection((int) expense.getInt("category"), true);
        }catch (JSONException e){
            e.getStackTrace();
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validData(view)){
                    updateExpense();
                }
            }
        });


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
                new DatePickerDialog(UpdateExpenseActivity.this, dateSetListener, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updatedateInput() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
        date.setText(sdf.format(myCalendar.getTime()));
    }

    private void updateExpense(){
        try {
            expense.put("rs", Float.parseFloat(rupees.getText().toString()))
                    .put("date", date.getText().toString())
                    .put("description", description.getText().toString())
                    .put("category", Integer.parseInt(String.valueOf(category.getSelectedItemPosition())));
            Expenses.setExpenseItem(getBaseContext(), id, expense);
            setResult(2, new Intent().putExtra("message", "Successfully updated!"));
            finish();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_update_expense, menu);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.delete);
        toolbar.setOverflowIcon(drawable);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        deleteExpense();
        return true;
    }

    private void deleteExpense(){
        Log.e("Clicked","Delete");
        Expenses.deleteExpenseItem(getBaseContext(), id);
        setResult(3, new Intent().putExtra("message", "Successfully deleted!"));
        finish();
    }

    private boolean validData(View view){
        if(rupees.getText().toString().equals("")) {
            makeSnackBar(view, "Rupee field must be required");
            return false;
        }
        if(description.getText().toString().equals("")){
            makeSnackBar(view, "Description field must be required");
            return false;
        }
        if(date.getText().toString().equals("")) {
            makeSnackBar(view, "Date field must be required");
            return false;
        }
        return true;
    }

    private void makeSnackBar(View view, String message){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}
