package com.samriddhi.bcasixth2081;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridViewActivity extends AppCompatActivity {

    GridView agvGridView;
    String [] bachelorCourses = {"BCA", "MBA", "BBA", "BIT", "MIT", "CSIT", "Btech", "Mtech", "MBA"};
    Integer [] randomNumbersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view);

        agvGridView = findViewById(R.id.agv_gridview);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(getIntent()!=null && getIntent().getExtras()!=null && !getIntent().getExtras().isEmpty()){
            int randomNumber = getIntent().getIntExtra("random_number", 0);

            if(randomNumber!=0){
                for(int i=0; i<10 ; i++){
                    randomNumber ++;
                    randomNumbersList[i] = randomNumber;
                }
            }

        }

        ArrayAdapter <Integer> arrayAdapter = new ArrayAdapter<>
                (getApplicationContext(), android.R.layout.simple_list_item_1, randomNumbersList);
        agvGridView.setAdapter(arrayAdapter);





    }
}