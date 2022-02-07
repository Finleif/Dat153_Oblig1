package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Entry> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entries = new ArrayList<Entry>(0);
        entries.add(new Entry("Jonas", R.drawable.duckone));
        entries.add(new Entry("Petter", R.drawable.ducktwo));
        entries.add(new Entry("Lars", R.drawable.duckthree));
    }

    public void beginQuiz(View view) {
        Intent i = new Intent(this, QuizActivity.class);
        startActivity(i);
    }

    public void addNewEntry(View view) {
        Intent i = new Intent(this, AddEntryActivity.class);
        startActivity(i);
    }

    public void viewAllEntries(View view) {
        Intent i = new Intent(this, ViewEntriesActivity.class);
        startActivity(i);
    }

    public static List<Entry> getEntries() {
        return entries;
    }

    public static void setEntries(List<Entry> entries) {
        MainActivity.entries = entries;
    }

}