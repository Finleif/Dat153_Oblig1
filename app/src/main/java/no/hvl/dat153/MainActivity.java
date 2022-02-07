package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void addNewEntry(View view) {
        Intent i = new Intent(this, AddEntryActivity.class);
        startActivity(i);
    }

    public void viewAllEntries(View view) {
        Intent i = new Intent(this, ViewEntriesActivity.class);
        startActivity(i);
    }
}