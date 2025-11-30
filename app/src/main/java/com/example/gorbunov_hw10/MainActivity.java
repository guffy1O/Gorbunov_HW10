package com.example.gorbunov_hw10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAge;
    private Button buttonSend;

    public static final String EXTRA_NAME = "com.example.gorbunov_hw10.NAME";
    public static final String EXTRA_AGE = "com.example.gorbunov_hw10.AGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String ageStr = editTextAge.getText().toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(MainActivity.this, "Пожалуйста, введите имя", Toast.LENGTH_SHORT).show();
                return;
            }
            if (ageStr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Пожалуйста, введите возраст", Toast.LENGTH_SHORT).show();
                return;
            }

            int age = Integer.parseInt(ageStr);

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(EXTRA_NAME, name);
            intent.putExtra(EXTRA_AGE, age);

            startActivity(intent);
        });
    }
}