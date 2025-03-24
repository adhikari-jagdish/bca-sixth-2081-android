package com.samriddhi.bcasixth2081;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.samriddhi.bcasixth2081.helpers.DBHandler;

import java.util.ArrayList;

public class SqliteDbActivity extends AppCompatActivity {

    private DBHandler dbHandler;
    EditText idEdtCourseName, idEdtCourseDuration;
    Button btnAddCourse;
    ListView coursesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sqlite_db);

        dbHandler = new DBHandler(getApplicationContext());

        idEdtCourseName = findViewById(R.id.asd_et_course_name);
        idEdtCourseDuration = findViewById(R.id.asd_et_course_duration);
        btnAddCourse = findViewById(R.id.asd_btn_add_course);
        coursesListView = findViewById(R.id.asq_courses_listview);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadSqliteData();
        btnAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idEdtCourseName != null && idEdtCourseDuration != null) {
                    if (idEdtCourseName.getText() != null && idEdtCourseDuration.getText() != null) {
                        if (!idEdtCourseName.getText().toString().isEmpty() && !idEdtCourseDuration.getText().toString().isEmpty()) {
                            String courseName = idEdtCourseName.getText().toString();
                            String courseDuration = idEdtCourseDuration.getText().toString();

                            dbHandler.addNewCourse(courseName, courseDuration);

                            Toast.makeText(getApplicationContext(), "Insert Success", Toast.LENGTH_SHORT).show();
                            idEdtCourseDuration.getText().clear();
                            idEdtCourseName.getText().clear();

                            loadSqliteData();
                        }
                    }
                }
            }
        });
    }

    /// This method is used to Load Data from SQLite DB into UI
    private void loadSqliteData() {

        Cursor cursor = dbHandler.getAllCourses();
        ArrayList<String> courses = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String duration = cursor.getString(2);
                courses.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        ArrayAdapter coursesAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,courses );
        coursesListView.setAdapter(coursesAdapter);
    }
}