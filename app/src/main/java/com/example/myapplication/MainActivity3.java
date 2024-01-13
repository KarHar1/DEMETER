package com.example.myapplication;

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
        resultTextView = findViewById(R.id.ResultText);

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
                // Call the method to calculate date difference
                calculateDateDifference();
                Intent intent3 = new Intent(MainActivity3.this, MainActivity4.class);
                intent3.putExtra("user_data2", user1);
                startActivity(intent3);
            }
        });
    }

    private void calculateDateDifference() {
        String dateString = timePeriod.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        long differenceInDays = 0;
        try {
            Date inputDate = dateFormat.parse(dateString);
            Date currentDate = new Date();

            long differenceInMillis = currentDate.getTime() - inputDate.getTime();
            differenceInDays = differenceInMillis / (24 * 60 * 60 * 1000);
            user1.days = (int) differenceInDays;

            // Display the calculated date difference
            resultTextView.setText(String.valueOf(user1.days));

        } catch (ParseException e) {
            resultTextView.setText("Invalid date format");
        }
    }
}
