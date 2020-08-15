package com.example.androidshaper.androidspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinnerCountry;
    Button buttonCheck;
    TextView textViewCountry;
    String[] countryNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerCountry=findViewById(R.id.spinnerCountry);
        buttonCheck=findViewById(R.id.buttonCheck);
        textViewCountry=findViewById(R.id.textViewCountry);
        countryNames=getResources().getStringArray(R.array.countryName);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.countryName,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(arrayAdapter);
        spinnerCountry.setOnItemSelectedListener(this);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=spinnerCountry.getSelectedItem().toString();
                textViewCountry.setText(name);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String message=adapterView.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}