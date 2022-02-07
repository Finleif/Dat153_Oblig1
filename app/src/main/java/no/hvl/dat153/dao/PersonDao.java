package no.hvl.dat153.dao;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import no.hvl.dat153.model.Person;

public class PersonDao implements Dao {

    Uri Miranda = Uri.parse("android.resource://no.hvl.dat153/drawable/miranda");
    Uri Charlie = Uri.parse("android.resource://no.hvl.dat153/drawable/charlie");
    Uri Cleopatra = Uri.parse("android.resource://no.hvl.dat153/drawable/foxxycleopatra");


    List<String> listOfNames = new ArrayList<>();
    List<Person> personArrayList = new ArrayList<>(Arrays.asList(
            new Person("Miranda", Miranda),
            new Person("Charlie", Charlie),
            new Person("Foxxy Cleopatra", Cleopatra)
    ));

    public PersonDao() {
    }

    @Override
    public List<Person> getAllPersons() {
        return personArrayList;
    }

    @Override
    public Person getPerson(int index) {
        return personArrayList.get(index);
    }

    @Override
    public void insert(Person p) {
        personArrayList.add(p);
    }

    @Override
    public void delete(Person p) {
        personArrayList.remove(p);
    }

    public List<String> getNames() {
        Iterator<Person> iterator = personArrayList.iterator();
        while(iterator.hasNext()) {
            listOfNames.add(iterator.next().getName());
        }
        return listOfNames;
    }
}
