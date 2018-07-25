package com.swabhav.santosh.expensetracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swabhav.santosh.expensetracker.repository.Expenses;
import com.swabhav.santosh.expensetracker.databinding.ExpenseItemElementBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExpensesItemAdapter extends RecyclerView.Adapter<ExpensesItemAdapter.ViewHolder> {
    private JSONArray expenses;
    private String[] categoryItems;
    Context context;

    public ExpensesItemAdapter(Context context) {
        this.context = context;
        this.expenses = Expenses.getAllExpenses(context);
        categoryItems = context.getResources().getStringArray(R.array.category_item);
    }

    public void updateExpenses() {
        this.expenses = Expenses.getAllExpenses(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ExpenseItemElementBinding  expenseItemElementBinding;

        public ViewHolder(@NonNull View expenseItemTemplate) {
            super(expenseItemTemplate);
            expenseItemElementBinding = DataBindingUtil.bind(expenseItemTemplate);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View expenseItemTemplate = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .expense_item_element, parent, false);
        return new ViewHolder(expenseItemTemplate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        try {
            final JSONObject expense = expenses.getJSONObject(position);

            holder.expenseItemElementBinding.rs.setText(String.valueOf(expense.getDouble("rs")));
            holder.expenseItemElementBinding.date.setText(String.valueOf(expense.getString("date")));
            holder.expenseItemElementBinding.description.setText(String.valueOf(expense.getString("description")));
            holder.expenseItemElementBinding.category.setText(String.valueOf(categoryItems[expense.getInt("category")]));

            holder.expenseItemElementBinding.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, UpdateExpenseActivity.class);
                    intent.putExtra("id", position);
                    ((Activity)context).startActivityForResult(intent, 2);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        try {
            return expenses.length();
        } catch (NullPointerException ex) {
            return 0;
        }
    }
}