package com.samriddhi.bcasixth2081;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class ConstraintLayoutActivity extends AppCompatActivity {
    TextView textOne, text_two;
    Button submit_button;
    EditText fullName, phoneNumber;
    Spinner spinnerDropdown;

    List<String> items = Arrays.asList("Kathmandu", "Chandragiri", "Nagarkot", "Pokhara", "Lumbini");
    //String[] places = getResources().getStringArray(R.array.tour_places);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_constraint_layout);

        //Get Intent Data from Previous screen
        String name = getIntent().getStringExtra("full_name");
        int age = getIntent().getIntExtra("age", 10);
        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();

        textOne = findViewById(R.id.textOne);
        text_two = findViewById(R.id.textTwo);
        submit_button = findViewById(R.id.submitButton);
        fullName = findViewById(R.id.full_name);
        phoneNumber = findViewById(R.id.mobile_number);
        spinnerDropdown = findViewById(R.id.spinner);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConstraintLayoutActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();

                String fullNameValue = fullName.getText().toString();
                long phoneNumberValue = Long.parseLong(phoneNumber.getText().toString());

                try{
                    textOne.setText(fullNameValue);
                    text_two.setText(String.valueOf(phoneNumberValue));

                }catch(Exception e){

                }


            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerDropdown.setAdapter(adapter);

        spinnerDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ConstraintLayoutActivity.this, items.get(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}