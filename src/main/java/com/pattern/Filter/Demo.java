package com.pattern.Filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jason
 */
public class Demo {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Robbert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "FeMale", "Single"));
        persons.add(new Person("Diana", "FeMale", "Married"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));


        Criteria male = new CriterMale();


        System.out.println(Arrays.toString(male.meetCriteria(persons).toArray()));


    }
}
