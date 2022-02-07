package no.hvl.dat153.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import no.hvl.dat153.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String score = "";
        String total = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            score = extras.getString("score");
            total = extras.getString("total");
        }
        String display = "Your score is " + score + " correct of " + total + " total!";
        TextView textView = findViewById(R.id.showResult);
        textView.setText(display);

        final Button returnToStart = findViewById(R.id.returnToStartBtn);
        Intent MainActivity = new Intent(this, MainActivity.class);
        returnToStart.setOnClickListener(v -> startActivity(MainActivity));
    }
}