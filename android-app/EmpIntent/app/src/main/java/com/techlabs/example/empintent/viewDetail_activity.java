package com.techlabs.example.empintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class viewDetail_activity extends AppCompatActivity {

    JSONObject detailObj;
    TextView name;
    TextView qualification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail_activity);
        this.setTitle(R.string.detail_activity_name);

        try {
            detailObj = new JSONObject(getIntent().getStringExtra("detail"));
        }catch(JSONException e){
            Log.e("Json Error", e.getMessage());
        }

        name = (TextView) findViewById(R.id.name);
        qualification = (TextView) findViewById(R.id.qualification);

        try {
            name.setText((String) detailObj.get("name"));
            qualification.setText((String) detailObj.get("qualification"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
