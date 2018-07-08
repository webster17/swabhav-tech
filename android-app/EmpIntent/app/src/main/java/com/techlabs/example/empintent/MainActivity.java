package com.techlabs.example.empintent;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private Button btn_detail;
    private Button btn_gender;
    private Button btn_contact;

    private ButtonBarLayout genderLayout;
    private TextView view_gender;
    private ButtonBarLayout gender_detail;


    private ButtonBarLayout contactLayout;
    private TextView viewContactName;
    private TextView viewContactNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_detail= (Button) findViewById(R.id.btn_detail);
        btn_gender = (Button) findViewById(R.id.btn_gender);
        btn_contact = (Button) findViewById(R.id.btn_contact);

        genderLayout = (ButtonBarLayout) findViewById(R.id.gender_detail);
        view_gender = (TextView) findViewById(R.id.view_gender);
        gender_detail = (ButtonBarLayout) findViewById(R.id.gender_detail);
        genderLayout.setVisibility(View.GONE);

        contactLayout = (ButtonBarLayout) findViewById(R.id.contact_detail);
        viewContactName = (TextView) findViewById(R.id.view_contact_name);
        viewContactNo = (TextView) findViewById(R.id.view_contact_no);
        contactLayout.setVisibility(View.GONE);

        String gender = getIntent().getStringExtra("gender");

        btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDetailIntent();
            }
        });

        btn_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSelectGenderIntent();
            }
        });

        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewContactList();
            }
        });
    }

    protected void viewContactList(){
        Intent contactListIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(contactListIntent, 3);
    }

    private void callDetailIntent(){

        JSONObject detailObj = new JSONObject();

        try {
            detailObj.put("name", "Santosh");
            detailObj.put("qualification", "BEIT");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Intent detailIntent = new Intent(this, viewDetail_activity.class);
        detailIntent.putExtra("detail", detailObj.toString());
        startActivity(detailIntent);
    }

    private void callSelectGenderIntent() {
        startActivityForResult(new Intent(this, gender_activity.class), 2);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2) {
            view_gender.setText(data.getStringExtra("gender_name"));
            genderLayout.setVisibility(View.VISIBLE);
        }
        else if(requestCode == 3){
            if(resultCode == Activity.RESULT_OK){
                Uri contactData = data.getData();
                Cursor cursor = getContentResolver().query(contactData, null,null,null,null);
                if(cursor.moveToFirst()) {
                    String contactId = cursor.getString(cursor.getColumnIndex((ContactsContract.Contacts._ID)));
                    viewContactName.setText(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));

                    if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0) {
                        Cursor phoneNoCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"= ?", new String[]{contactId}, null);
                        while (phoneNoCursor.moveToNext()){
                            viewContactNo.setText(phoneNoCursor.getString(phoneNoCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                        }
                    }
                    contactLayout.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
