package no.hvl.dat153.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import java.util.List;

import no.hvl.dat153.dao.PersonDao;
import no.hvl.dat153.model.Person;
import no.hvl.dat153.R;

public class dbActivity extends AppCompatActivity{

    private PersonDao personDao = new PersonDao();
    private List<Person> personList = personDao.getAllPersons();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        final Button add_new_person = findViewById(R.id.add_new_person);
        Intent addNewPerson = new Intent(this, AddNewPersonActivity.class);

        add_new_person.setOnClickListener(v -> startActivity(addNewPerson));
        }
}