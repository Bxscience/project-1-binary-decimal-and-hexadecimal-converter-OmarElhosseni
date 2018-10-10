package com.elhosseno.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final EditText editD = (EditText)findViewById(R.id.EditD);
        final EditText editB = (EditText)findViewById(R.id.EditB);
        final EditText editH = (EditText)findViewById(R.id.EditH);
        final Button ConvertButton = (Button) findViewById(R.id.ConvertButton);

        editD.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editB.setText("");
                    editH.setText("");
                }
            }
        });

        editB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editD.setText("");
                    editH.setText("");
                }
            }
        });

        editH.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    editB.setText("");
                    editD.setText("");
                }
            }
        });


        ConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("hello", "onClick: " + editB.getText().toString());
                Log.d("hello", "onClick: " + editD.getText().toString());
                Log.d("hello", "onClick: " + editH.getText().toString());
                if(editD.getText().toString().length() > 0 ) {
                    if(editD.getText().toString().matches("[0-9]+")) {
                        int dval = Integer.parseInt(editD.getText().toString());
                        editB.setText(Integer.toBinaryString(dval));
                        editH.setText(Integer.toHexString(dval));
                    } else {
                        Toast.makeText(MainActivity.this, "Decimal value is invalid", Toast.LENGTH_SHORT).show();
                    }
                } else if(editB.getText().toString().length() > 0) {
                    if( editB.getText().toString().matches("[0-1]+")) {
                        int dval = Integer.parseInt(editB.getText().toString(),2);
                        editD.setText(Integer.toString(dval));
                        editH.setText(Integer.toHexString(dval));
                    } else {
                        Toast.makeText(MainActivity.this, "Binary value is invalid", Toast.LENGTH_SHORT).show();
                    }
                } else if(editH.getText().toString().length() > 0) {
                    if(editH.getText().toString().matches("-?[0-9a-fA-F]+")) {
                        int dval = Integer.parseInt(editH.getText().toString(),16);
                        editB.setText(Integer.toBinaryString(dval));
                        editD.setText(Integer.toString(dval));
                    } else {
                        Toast.makeText(MainActivity.this, "Hexadecimal value is invalid", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        };



    }

