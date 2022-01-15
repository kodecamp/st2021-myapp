package in.kodecamp;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CollectionTest {


	@Override
	public String toString() {
		return "CollectionTest []";
	}

	//1. find the all person who are present in both the collections.
    //2. find the person which are not in second collection.
    //3. find all person of older than the given age.
    //4. find the union of two collection.
    public void testCommon1() {
        System.out.println("testCommon 1");
        numbers().limit(10).mapToObj((number) -> new Employee(number, "Name_"+number, "City_"+number));
    }

    public void testCommon2() {
        System.out.println("testCommon 2");
        List<Integer> values = numbers()
            .limit(10)
            .filter(CollectionTest::isEven)
            .map(CollectionTest::times)
            .boxed().collect(Collectors.toList());
        System.out.println(values);
    }

    public void testCommon3() {
        var finalString = numbers()
            .limit(10)
            .mapToObj((number) -> new Employee(number, "Name_"+number, "City_"+number))
            .map(e -> e.name)
            .collect(joining(","));
        System.out.println(finalString);
    }
    public void testCommon4() {
        var  map = numbers()
            .limit(10)
            .mapToObj((number) -> new Employee(number, "Name_"+number, "City_"+number))
            .collect(toMap(e -> e.name, Function.identity()));
        System.out.println("map : " + map);
    }

    public void testCommon5() {
        var  map = numbers()
            .limit(10)
            .mapToObj((number) -> new Employee(number, "Name_"+number, "City_"+number))
            .collect(groupingBy(e -> e.city, mapping(e -> e.name(), toList() )));
        System.out.println("map : " + map.values());
    }

    public void testCommon6() {
        System.out.println("TEST COMMON : 6");
        try {
            int x = 10;
            int y = 0;
            int z = x / y;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("############################## Hello World");
        }
    }

    static boolean isEven(int number)  {
        System.out.println("Iseven : "+ number);
        return number %2 == 0;
    }

    static int times(int number) {
        return 100*number;
    }


    static int times(int times, int number, String gain)  {
        System.out.println("times : "+ number);
        return times*number;
    }

    void times(int times, int number , int gain) {
        return;
    }

    static IntStream numbers() {
      var intSupplier = new IntSupplier(){
        int startFrom = 1;
            @Override
            public int getAsInt() {
            return startFrom++;
            }
        };
      return IntStream.generate(intSupplier);
    }


    public void testGroupByCity() {
        System.out.println("------------------- testGroupByCity -------------------------");
        //@formatter:off

        Map<GroupKey, List<Employee>> empMap = getAllEmployees().stream()
            .collect(
                    // groupingBy(Employee::city)
                    groupingBy(e -> new GroupKey(e.id, e.city))
                    ); // end of collect
        System.out.println(empMap);
        //@formatter:on
    }

    static List<Employee> getAllEmployees() {
        return List.of(
                new Employee(1, "Sunil", "Naini"),
                new Employee(2, "Rakesh", "Naini"),
                new Employee(3, "Suresh", "Delhi"),
                new Employee(4, "Dileep", "Delhi"),
                new Employee(4, "Mahesh", "Mumbai"),
                new Employee(4, "Madhu", "Mumbai")
                );
    }


}

class GroupKey {
    int id;
    String city;
    GroupKey(int id, String city) {
        this.id = id;
        this.city = city;
    }

    int id() {
        return this.id;
    }
    String city() {
        return this.city;
    }

    public int hashCode() {
        return this.city.hashCode();
    }

    public boolean equals(Object obj) {
        GroupKey gk = (GroupKey) obj;
        return this.city.equals(gk.city);
    }

    public String toString() {
        return String.format(" %s: %s ", this.city, this.id);
    }

}


class Employee {
    int id;
    String name;
    String city;

    Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    String name() {
        return this.name;
    }

    String city() {
        return this.city;
    }

    public String toString() {
        return String.format("{ id = %d, name = %s, city = %s }", this.id, this.name, this.city);
    }

}

enum PrimeMinister {
    INSTANCE;
    private int value = 100;
    private int value2 = 200;

    public String doSomething() {
        return "Hello World" + value;
    }
}
