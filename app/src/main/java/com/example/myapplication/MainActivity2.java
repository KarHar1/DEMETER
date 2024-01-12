package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText goal_weight = findViewById(R.id.edittext_5);

        Intent intent = getIntent();
        User user1 = (User) intent.getSerializableExtra("user_data");

        RadioGroup radios = findViewById(R.id.radioGoals);

        radios.setOnCheckedChangeListener((radiogroup, id)-> {
            RadioButton radio = findViewById(id);

            switch (radio.getText().toString()) {
                case "WeightLoss":
                    user1.gml = 1;
                    break;
                case "WeightMaintenance":
                    user1.gml = 2;
                    break;
                case "WeightGain":
                    user1.gml = 3;
                    break;
                default: break;
            }
        });

        Button next1 = findViewById(R.id.next2);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String goalText = goal_weight.getText().toString();
                    if (!goalText.isEmpty()) {
                        int goal = Integer.parseInt(goalText);
                        user1.setGoal_weight(user1.weight-goal);
                        /*if (user1.bmi(user1.weight , user1.height)>18.5 && user1.bmi(user1.weight , user1.height)<26.5 ){
                            throw new RuntimeException("Ur Bmi is too high or too low , pick another weight goal");
                        }*/
                        Intent intent2 = new Intent(MainActivity2.this, MainActivity3.class);
                        intent2.putExtra("user_data1", user1);
                        startActivity(intent2);
                    } else {
                        Toast.makeText(MainActivity2.this, "Please enter a goal weight", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity2.this, "Invalid numeric input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
