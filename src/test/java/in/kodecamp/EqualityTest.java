package in.kodecamp;

import java.util.ArrayList;
import java.util.List;

public class EqualityTest {
    // intstance(object) variable => obejct dependent => needs an object to be called
    // is it shared
    private int count = 0;

    // water pump
    private static int aCount= 0;
    // instance(object dependent) method => needs and object to be accessed
    public void testLists() {
        List<String> list = new ArrayList<>();
        list.forEach(System.out::println);



    }

    // object independent method
    public static void testList1() {
    }


    public static Person createPerson() {
        return new Person(1, "Golu", "Kanpur");

    }

    //
    private static int person;

    //
    private static class Person{
        int id;
        String name;
        String address;

        Person(int id , String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        // write this method for id and name
        @Override
        public boolean equals(Object obj) {
            Person p = (Person)obj;
            // return this.id == p.id;
            return this.name.equals(p.name);
        }

        public int id() {
            return this.id;
        }

        public String name() {
            return this.name;
        }


    };


    public void testCollectionTest() {
        System.out.println("................ Testing....................");
        int person = EqualityTest.person = 10;

        //
        EqualityTest.Person p1 = new EqualityTest.Person(1, "Bholu", "Kanpur");
        EqualityTest.Person p2 = new EqualityTest.Person(10, "Bholu", "Kanpur");

        System.out.println("###### " + p1);
        System.out.println("###### " + p2);

        assert (p1.equals(p2)) : "Both are not equal";
    }




}
