package in.kodecamp;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LoopTest
 */
public class LoopTest {


    public void testLoopNumbers() {
        System.out.println("--> testLoopNumbers");
        IntStream.range(1, 10)
            .forEach(System.out::println);
    }

    public void testLoopNumbersClosed() {
        System.out.println("--> testLoopNumbersClosed");
        IntStream.rangeClosed(1, 10)
            .forEach(System.out::println);
    }

    public void testLoopNumbersFirstFive() {
        System.out.println("--> testLoopNumbersFirstFive");
        IntStream.rangeClosed(1, 10)
            .limit(5)
            .forEach(System.out::println);
    }

    public void testLoopNumbersConditional() {
        System.out.println("--> testLoopNumbersConditional");
        IntStream.rangeClosed(1, 10)
            .takeWhile((number) -> number % 2 == 0)
            .forEach(System.out::println);
    }

    public void testLoopNumbersInSteps() {
        System.out.println("--> testLoopNumbersInSteps");
        IntStream.iterate(0, (n) -> n + 2)
            .limit(10)
            .forEach(System.out::println);
    }

    public void testLoopNumbersOther() {
        System.out.println("--> testLoopNumbersOther");
        List<Integer> numbers = Arrays.asList(5,5,4,4,3,3,2,2,1,1)
            .stream()
            .sorted()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("--> Sorted : " + numbers);
    }

    public void testLoopNumbersOther2() {
        System.out.println("--> testLoopNumbersOther2");
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Sunil"),
                new Employee(1, "Sunil"),
                new Employee(2, "Indra"),
                new Employee(2, "Indra"),
                new Employee(3, "Dev"),
                new Employee(4, "Nagesh")
                )
            .stream()
            .sorted((e1, e2) -> e1.name.compareTo(e2.name))
            .distinct()
            .collect(Collectors.toList());
        System.out.println("--> Sorted : " + employees);
    }

    public void testArrayElementJoin() {
        String[] values = {"Sunil", "Rakesh", "Dinesh"};
        String rs = Arrays.stream(values)
            .reduce("", (carry, str) -> carry + " | " + str);
        System.out.println("---------- String Result : " + rs);
    }

    private static class Employee {
        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("Employee { id = %d, name = %s}", id, name);
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Employee)) {
                return false;
            }
            Employee e = (Employee)o;
            return Objects.equals(this.name,e.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.name);
        }

    }

}
