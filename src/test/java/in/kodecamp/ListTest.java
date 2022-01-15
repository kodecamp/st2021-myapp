package in.kodecamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import in.kodecamp.collections.ListExample;
import in.kodecamp.collections.ListExample.Person;
import in.kodecamp.commons.Logger;

/**
 * ListTest
 */
public class ListTest {

    static final int NO_OF_ITEMS = 1000000;

    public void setUp() {
        // Logger.log("setup", "Everything is setup");
    }

    public void testLinkedListAppend() {
        List<Integer> list = new LinkedList<>();
        long start = System.currentTimeMillis();

        for(int i = 0; i < NO_OF_ITEMS; i++) {
            list.add(i);
        }

        long timeTaken = System.currentTimeMillis() - start;
        Logger.logv("time taken", timeTaken);
        assert true;
    }

    public void testArrayListAppend() {
        List<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();

        for(int i = 0; i < NO_OF_ITEMS; i++) {
            list.add(i);
        }

        long timeTaken = System.currentTimeMillis() - start;
        Logger.logv("time taken", timeTaken);
        assert true;
    }

    public void testList() {
        System.out.println("### testList");
        List<Person> people = ListExample.createList(100);
        System.out.println(people);
        System.out.println(people.size());
        System.out.println(people.isEmpty());

        Person myPerson = new Person(20, "Suresh");

        boolean isFound = people.contains(myPerson);
        System.out.println("isFound : " + isFound);
        int index = people.indexOf(myPerson);
        System.out.println("found at index : " + index);
        // constant time 100 10000 10000000
        Person foundObj = people.get(index);
        System.out.println("found obj : " + foundObj);
        // destructive method
        Collections.sort(people);
        System.out.println(people);
    }


    public void tearDown() {
        // Logger.log("tearDown", "Everything is destroyed");
    }


}
