package no.hvl.dat153.dao;

import java.util.List;

import no.hvl.dat153.model.Person;

public interface Dao {
    public List<Person> getAllPersons();

    public Person getPerson(int index);

    public void insert(Person p);

    public void delete(Person p);
}
