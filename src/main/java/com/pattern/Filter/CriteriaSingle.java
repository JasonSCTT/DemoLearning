package com.pattern.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason
 */
public class CriteriaSingle implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();

        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("Single")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}