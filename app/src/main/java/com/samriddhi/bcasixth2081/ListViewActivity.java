package com.samriddhi.bcasixth2081;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewActivity extends AppCompatActivity {

    String[] bachelorCourses = {"BCA", "BBA", "CSIT", "BIM", "MBA", "BBS", "MBS", "BA", "BE", "BTECH"};
    ListView coursesListView;
    Button btnSubmitListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);

        coursesListView = findViewById(R.id.courses_list_view);

        btnSubmitListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GridViewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, bachelorCourses);
        coursesListView.setAdapter(arrayAdapter);
    }
}