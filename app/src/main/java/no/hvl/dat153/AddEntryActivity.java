package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class AddEntryActivity extends AppCompatActivity {

    public List<Entry> entries;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        this.entries = MainActivity.getEntries();
        editText = findViewById(R.id.editTextName);
    }

    // Add new entry
    public void addNewEntry(View view) {
        this.entries.add(new Entry(editText.getText().toString(), R.drawable.wizardgooseedited));
        MainActivity.setEntries(this.entries);
    }

    // Go back
    public void goBack(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void viewAllEntries(View view) {
        Intent i = new Intent(this, ViewEntriesActivity.class);
        startActivity(i);
    }
}