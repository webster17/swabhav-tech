package com.swabhav.santosh.expensetracker.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Expenses {

    private static final String sharedPrefExpenses = "expensesRecord";
    private static final String sharedPrefKeyName = "expenses";

    private Expenses() {
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(sharedPrefExpenses, Context.MODE_PRIVATE);
    }

    private static void setSharedPreferences(Context context, JSONArray expenses) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(sharedPrefKeyName, expenses.toString());
        editor.commit();
    }

    public static JSONArray getAllExpenses(Context context) {
        try {
            return new JSONArray(getSharedPreferences(context).getString(sharedPrefKeyName, "[]"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    public static JSONObject getExpenseItem(Context context, int id) {
        try {
            return getAllExpenses(context).getJSONObject(id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setExpenseItem(Context context, int id, JSONObject expense) {
        JSONArray expenses = getAllExpenses(context);
        try {
            expense.put("rs", round((Double) expense.getDouble("rs"), 2));
            expenses.put(id, expense);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setSharedPreferences(context, expenses);
    }

    public static void addExpenseItem(Context context, JSONObject expense) {
        try {
            expense.put("rs", round((Double) expense.getDouble("rs"), 2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray expenses = getAllExpenses(context);
        expenses.put(expense);
        setSharedPreferences(context, expenses);
    }

    public static void deleteExpenseItem(Context context, int id) {
        JSONArray expenses = getAllExpenses(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Log.e("In ", "deleted method");
            expenses.remove(id);
        }
        setSharedPreferences(context, expenses);
    }

    public static Double totalExpensed(Context context) {
        Double totalExpense = 0.0;
        JSONArray expenses = getAllExpenses(context);
        JSONObject expense;

        for (int i = 0; i < expenses.length(); i++) {
            try {
                expense = expenses.getJSONObject(i);
                totalExpense = (Double) (totalExpense + expense.getDouble("rs"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return round(totalExpense, 2);
    }

    public static int allExpensesCount(Context context) {
        JSONArray expenses = getAllExpenses(context);
        return expenses.length();
    }

    public static Double round(Double number, int decimalPlace) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(df.format(number));
    }
}