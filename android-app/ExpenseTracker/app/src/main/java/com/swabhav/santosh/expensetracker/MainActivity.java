package com.swabhav.santosh.expensetracker;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.swabhav.santosh.expensetracker.databinding.ActivityMainBinding;
import com.swabhav.santosh.expensetracker.repository.Expenses;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private ExpensesItemAdapter expensesItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        expensesItemAdapter = new ExpensesItemAdapter(this);

        showDashboard();
        activityMainBinding.included.itemRecyclerView.setHasFixedSize(true);
        activityMainBinding.included.itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.included.itemRecyclerView.setAdapter(expensesItemAdapter);

        activityMainBinding.addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getBaseContext(), AddExpenseActivity.class), 1);
            }
        });
    }

    private void showDashboard(){
        activityMainBinding.included.allExpenseCount.setText(String.valueOf(Expenses.allExpensesCount(this)));
        activityMainBinding.included.totalExpense.setText("₹ "+(Expenses.totalExpensed(this)));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(resultCode, requestCode, intent);
        if(resultCode != 0) {
            expensesItemAdapter.updateExpenses();
            showDashboard();
            expensesItemAdapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), intent.getStringExtra("message"), Toast.LENGTH_SHORT).show();
        }
    }
}