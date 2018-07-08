package com.techlabs.example.percentagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

public class MainActivity extends AppCompatActivity {

    private EditText fname;
    private EditText sname;
    private TextView fnameView;
    private TextView snameView;
    private TextView percentageView;
    private CardView cardView;
    private ImageButton fnameImageButton;
    private ImageButton snameImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = this.findViewById(R.id.fname);
        sname = this.findViewById(R.id.sname);
        fnameImageButton = this.findViewById(R.id.fnameImageBtn);
        snameImageButton = this.findViewById(R.id.snameImageBtn);
        fnameView = this.findViewById(R.id.fnameView);
        snameView = this.findViewById(R.id.snameView);
        percentageView = this.findViewById(R.id.percentageView);
        cardView = this.findViewById(R.id.cardView);
        cardView.setVisibility(View.GONE);


        fnameImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewContactList(2);
            }
        });

        snameImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewContactList(3);
            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateInput();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        fname.addTextChangedListener(textWatcher);
        sname.addTextChangedListener(textWatcher);

    }

    private void displayCalculatedPercentage() {
        snameView.setText(sname.getText());
        fnameView.setText(fname.getText());
        long percentage = fname.getText().toString().hashCode() + sname.getText().toString().hashCode();
        percentageView.setText((Math.abs(percentage) % 101) + "%");
        cardView.setVisibility(View.VISIBLE);
    }

    protected void viewContactList(int requestCode) {
        Intent contactListIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(contactListIntent, requestCode);
    }

    private void validateInput() {
        if (sname.getText().toString().matches("") || fname.getText().toString().matches(""))
            cardView.setVisibility(View.GONE);
        else
            displayCalculatedPercentage();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            Uri contactData = data.getData();
            Cursor cursor = getContentResolver().query(contactData, null, null, null, null);
            if (cursor.moveToFirst()) {
                String contactId = cursor.getString(cursor.getColumnIndex((ContactsContract.Contacts._ID)));
                if (requestCode == 2)
                    fname.setText(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                else if (requestCode == 3)
                    sname.setText(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
            }
        }
        validateInput();
    }
}

