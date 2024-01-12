package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

                    User user1 = new User();
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
    }
}
