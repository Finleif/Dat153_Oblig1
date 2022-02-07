package no.hvl.dat153.misc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import no.hvl.dat153.model.Person;

public class SortList {
    private List<Person> personList;


    public SortList(List<Person> studentList){ this.personList = personList; }

    public void sortedAz(){
        Collections.sort(this.personList, Comparator.comparing(Person::getName));
    }

    public void sortedZa(){
        this.personList.sort(Comparator.comparing(Person::getName, Comparator.reverseOrder()));
    }

    public List<Person> sortedList(){ return this.personList; }
}

