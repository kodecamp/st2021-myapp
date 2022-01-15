package in.kodecamp.collections;

import java.util.LinkedList;
import java.util.List;

/**
 * ListExample
 */
public class ListExample extends java.lang.Object {

  static public List<Person> createList(int noOfItems) {
    List<Person> people = new LinkedList<>();
    Person p = null;
    for(int i = noOfItems-1 ; i >= 0; i--) {
      p = new Person(i+1, "Name_"+ (i+1));
      people.add(p);
    }
    return people;
  }

  static public class Person implements Comparable<Person>{
    int id;
    String name;


    public Person(int id, String name) {
      this.id = id;
      this.name = name;
    }

    // string representation of the person
    @Override
    public String toString() {
      String personString = "[ id = "+ id + " name : "+ name +"]";
      return personString;
    }

    @Override
    public boolean equals(Object anotherObj) {
      if(! (anotherObj instanceof Person)) {
        return false;
      }
      // type conversion => risky operation
      Person obj = (Person)anotherObj;
      // System.out.println("------------ equals");
      // if (obj.id == this.id) {
      //   return true;
      // }
      // return false;
      return obj.id == this.id ? true : false;
    }

      @Override
      public int compareTo(Person o) {
	Integer thisId = Integer.valueOf(this.id);
	Integer otherId = Integer.valueOf(o.id);
	return thisId.compareTo(otherId);
      }

  }

}
