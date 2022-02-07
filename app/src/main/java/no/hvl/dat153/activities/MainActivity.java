package no.hvl.dat153.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import no.hvl.dat153.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find button
        final Button take_quiz = findViewById(R.id.start_quiz);
            //Create intent
            Intent quiz = new Intent(this,QuizActivity.class);
                //Set onclick
                take_quiz.setOnClickListener(v -> startActivity(quiz));

        //Find button
        final Button see_list = findViewById(R.id.peek_db);
            //Create intent
            Intent list = new Intent(this,dbActivity.class);
                //Set onclick
                see_list.setOnClickListener(v -> startActivity(list));
    }
}