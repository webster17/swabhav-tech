package com.swabhav.santosh.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.swabhav.santosh.tictactoe.R.color.colorDefault;

public class MainActivity extends AppCompatActivity {

    private Button[] cellBtn= new Button[9];
    private Button btnReset;
    private TextView textViewStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cellBtn[0]= (Button) findViewById(R.id.cellBtn0);
        cellBtn[1]= (Button) findViewById(R.id.cellBtn1);
        cellBtn[2]= (Button) findViewById(R.id.cellBtn2);
        cellBtn[3]= (Button) findViewById(R.id.cellBtn3);
        cellBtn[4]= (Button) findViewById(R.id.cellBtn4);
        cellBtn[5]= (Button) findViewById(R.id.cellBtn5);
        cellBtn[6]= (Button) findViewById(R.id.cellBtn6);
        cellBtn[7]= (Button) findViewById(R.id.cellBtn7);
        cellBtn[8]= (Button) findViewById(R.id.cellBtn8);
        btnReset = (Button) findViewById(R.id.btnReset);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

        private View.OnClickListener onClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        }
        for (Button btn : cellBtn){
            btn.setO;
        }

    }

    private void resetGame(){
        for (Button btn : cellBtn){
            btn.setText("X");
            btn.setBackgroundResource(R.color.colorDefault);
        }
        textViewStatus.setText("Player 1's turn");
    }
}
