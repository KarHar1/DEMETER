package com.example.myapplication;

import static com.example.myapplication.MainActivity2.backPressedEnabled;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity3 extends AppCompatActivity {

    Intent intent;
    User user1;
    EditText timePeriod;
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main3);

        // Initialize views within the onCreate method
        timePeriod = findViewById(R.id.editTextDate);

        intent = getIntent();
        user1 = (User) intent.getSerializableExtra("user_data1");

        RadioGroup radios = findViewById(R.id.radioExer);

        radios.setOnCheckedChangeListener((radiogroup, id)-> {
            RadioButton radio = findViewById(id);

            switch (radio.getText().toString()) {
                case "sedentary":
                    user1.exer = 1;
                    break;
                case "light":
                    user1.exer = 2;
                    break;
                case "medium":
                    user1.exer = 3;
                    break;
                case "active":
                    user1.exer = 4;
                    break;
                default:
                    break;
            }
        });

        Button next = findViewById(R.id.next2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultTextView.toString().isEmpty() || radios.getCheckedRadioButtonId()==-1 ) {
                    Toast.makeText(MainActivity3.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent3 = new Intent(MainActivity3.this, MainActivity4.class);
                intent3.putExtra("user_data2", user1);
                startActivity(intent3);
            }
        });
    }


    @Override
    public void onBackPressed() {

        if (backPressedEnabled) {
            // Call the super method to maintain the default back behavior
            super.onBackPressed();
        } else {
            // Display a Toast message
            Toast.makeText(MainActivity3.this, "There is no back action", Toast.LENGTH_LONG).show();
            // You may choose to finish the activity or perform other actions here
        }
    }

}
