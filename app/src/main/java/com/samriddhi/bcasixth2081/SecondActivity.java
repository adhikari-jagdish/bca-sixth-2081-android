package com.samriddhi.bcasixth2081;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    TextView tvsName, tvsMobileNumber;
    EditText etAddress;
    Button btnSubmit, btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        tvsName = findViewById(R.id.tvs_name);
        tvsMobileNumber = findViewById(R.id.tvs_mobile_number);
        etAddress = findViewById(R.id.et_address);
        btnSubmit = findViewById(R.id.btns_submit);
        btnShowDialog = findViewById(R.id.btn_show_dialog);

        String name = getIntent().getStringExtra("name");
        Long mobileNumber = getIntent().getLongExtra("mobile_number", 0);
        if( name!=null && !name.isEmpty()){
            tvsName.setText(name);
        }
        tvsMobileNumber.setText(String.valueOf(mobileNumber));
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(etAddress!=null && etAddress.getText()!=null){
                   String address = etAddress.getText().toString();

                   Intent intent = new Intent();
                   intent.putExtra("address", address);
                   setResult(Activity.RESULT_OK, intent);
                   finish();
               }

            }
        });

        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment myDialogFragment = new MyDialogFragment();
                myDialogFragment.show(getSupportFragmentManager(), "MyDialog");
            }
        });

    }
}