package com.swabhav.santosh.numbers;

import com.swabhav.santosh.numbers.implementation.FactAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private EditText numberInput;
    private Button searchBtn;
    private LinearLayout responseLayout;
    private List<String> facts = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBtn = (Button) findViewById(R.id.searchBtn);
        numberInput = (EditText) findViewById(R.id.numberInput);
        responseLayout = (LinearLayout) findViewById(R.id.responseLayout);
        responseLayout.setVisibility(View.GONE);


        recyclerView = (RecyclerView) findViewById(R.id.factRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                getFact(Integer.parseInt(numberInput.getText().toString()));
            }
        });
    }

    public void getFact(int number) {

        numberInput.setText("");

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://numbersapi.com/" + number;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        facts.add(0, response);
                        recyclerView.setAdapter(new FactAdapter((ArrayList<String>) facts));
                        responseLayout.setVisibility(View.VISIBLE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Response is not getting!", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }
}
