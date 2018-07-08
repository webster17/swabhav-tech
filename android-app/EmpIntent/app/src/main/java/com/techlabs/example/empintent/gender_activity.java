package com.techlabs.example.empintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class gender_activity extends AppCompatActivity {

    private RadioGroup gender;
    private RadioButton selectedGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_activity);
        this.setTitle("Select Gender");

        gender = (RadioGroup) findViewById(R.id.gender);
        selectedGender = (RadioButton) gender.findViewById(gender.getCheckedRadioButtonId());

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup gender, int checkedGender) {
                RadioButton checRadioButton = (RadioButton)gender.findViewById(checkedGender);
                boolean isChecked= checRadioButton.isChecked();
                if(isChecked){
                    Intent intent = new Intent();
                    intent.putExtra("gender_name",checRadioButton.getText().toString());
                    setResult(2,intent);
                    finish();
                }

            }
        });
    }
}
