package com.samriddhi.bcasixth2081;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstActivity extends AppCompatActivity {

    EditText etName, etMobileNumber, etRandomNumber;
    Button submitBtn, submitBtnRandomNumber;
    final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etName = findViewById(R.id.et_name);
        etMobileNumber = findViewById(R.id.et_mobile_number);
        submitBtn = findViewById(R.id.btn_submit);
        etRandomNumber = findViewById(R.id.et_random_number);
        submitBtnRandomNumber = findViewById(R.id.btn_submit_random_number);

    }


    @Override
    protected void onStart() {
        super.onStart();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText() != null && etMobileNumber.getText() != null && !etMobileNumber.getText().toString().isEmpty()) {
                    String name = etName.getText().toString();
                    long mobileNumber = Long.parseLong(etMobileNumber.getText().toString());
                    Intent intentObj = new Intent(getBaseContext(), SecondActivity.class);
                    intentObj.putExtra("name", name);
                    intentObj.putExtra("mobile_number", mobileNumber);
                    startActivityForResult(intentObj, REQUEST_CODE);
                }


            }
        });

        submitBtnRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etRandomNumber!=null && etRandomNumber.getText() != null && !etRandomNumber.getText().toString().isEmpty()) {
                    int randomNumber = Integer.parseInt(etRandomNumber.getText().toString());
                    if (randomNumber > 100 || randomNumber < 1) {
                        Toast.makeText(getApplicationContext(), "Please enter number between 1 and 100", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intentObj = new Intent(getBaseContext(), GridViewActivity.class);
                        intentObj.putExtra("random_number", randomNumber);
                        startActivity(intentObj);
                    }

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                String returnedAddress = data.getStringExtra("address");
                Toast.makeText(this, returnedAddress, Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int menuItemId = item.getItemId();

        if (menuItemId == R.id.menu_settings) {
            Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (menuItemId == R.id.menu_share) {
            Toast.makeText(this, "Share Clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (menuItemId == R.id.menu_exit) {
            finish(); // Closes the app
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}