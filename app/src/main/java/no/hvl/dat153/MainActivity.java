package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dbButton = findViewById(R.id.databasebutton);

        /** sends user from the database button to the actual database activity*/
        dbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DatabaseActivity.class));
            }
        });
    }
}


// mål er å sende videre til database aktivitet fikset