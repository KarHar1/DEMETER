package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    User user1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // Get the intent and retrieve user data
        Intent intent = getIntent();
        user1 = (User) intent.getSerializableExtra("user_data2");

        // Display calculated overall daily calories
        TextView cal = findViewById(R.id.xxxx);
        cal.setText(user1.coutOverallDailyCalories());
    }
}
