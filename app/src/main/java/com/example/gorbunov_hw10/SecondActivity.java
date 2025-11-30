package com.example.gorbunov_hw10;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private ImageView imageViewCard;
    private TextView textViewGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageViewCard = findViewById(R.id.imageViewCard);
        textViewGreeting = findViewById(R.id.textViewGreeting);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString(MainActivity.EXTRA_NAME);
            int age = extras.getInt(MainActivity.EXTRA_AGE, 0); // 0 - значение по умолчанию

            String greetingText = "С днем рождения, " + name + "!\n" +
                    "Вам исполнилось " + age + " лет!";
            textViewGreeting.setText(greetingText);
        }
    }
}