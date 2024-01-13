package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String FIRST_TIME_KEY = "first_time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user1 = new User();

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        if (prefs.getBoolean(FIRST_TIME_KEY, true)) {

            // The app is opened for the first time
            setContentView(R.layout.activity_main);

            EditText nameEditText = findViewById(R.id.edittext_1);
            EditText ageEditText = findViewById(R.id.edittext_2);
            EditText weightEditText = findViewById(R.id.edittext_3);
            EditText heightEditText = findViewById(R.id.edittext_4);
            EditText genderEditText = findViewById(R.id.edittext_5);
            Button nextButton = findViewById(R.id.button);


            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nameText = nameEditText.getText().toString();
                    String ageText = ageEditText.getText().toString();
                    String weightText = weightEditText.getText().toString();
                    String heightText = heightEditText.getText().toString();
                    String genderText = genderEditText.getText().toString();

                    if (nameText.isEmpty() || ageText.isEmpty() || weightText.isEmpty() || heightText.isEmpty() || genderText.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    try {
                        int age = Integer.parseInt(ageText);
                        int weight = Integer.parseInt(weightText);
                        int height = Integer.parseInt(heightText);


                        user1.setName(nameText);
                        user1.setAge(age);
                        user1.setWeight(weight);
                        user1.setHeight(height);
                        user1.setGender(true);

                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("user_data", user1);
                        startActivity(intent);

                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid numeric input", Toast.LENGTH_SHORT).show();
                    }
                }
            });


            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(FIRST_TIME_KEY, false);
            editor.apply();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("user_data", user1);

        } else {
            Intent intent = new Intent(MainActivity.this, MainActivity4.class);
            intent.putExtra("user_data2", user1);
            startActivity(intent);
            finish();
        }
    }
}
