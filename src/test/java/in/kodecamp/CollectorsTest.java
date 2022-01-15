package in.kodecamp;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CollectorsTest
 */
public class CollectorsTest {

    public void testCollector() {

        // Map<String,List<Sample>> map = list().stream().collect(groupingBy(s -> s.city, mapping(s -> s, toList())));
        // System.out.println(map);

        Map<String, Double> map2 = list().stream().collect(groupingBy(Sample::getCity, summingDouble(Sample::getSalary)));
        System.out.println(map2);
    }


    private static List<Sample> list() {
        return List.of(Sample.from("Sunil", "Naini", 100.0), Sample.from("Rakesh", "Naini", 200.0), Sample.from("Dinesh", "Delhi", 300.0), Sample.from("Dilip", "Delhi", 400.0), Sample.from("Mahesh", "Muzaf", 500.0));
    }


    static class Sample {
        String name;
        String city;
        double salary;

        Sample(String name, String city, double salary) {
            this.name = name;
            this.city = city;
        }

        static Sample from(String name, String city, double salary) {
            return new Sample(name, city, salary);
        }

        double getSalary() {
            return this.salary;
        }

        String getCity() {
            return this.city;
        }
    }

    public void testArray() {
        String[][] values = {{"A", "C"}, {"A", "D"}, {"F", "C"}, {"A", "D"}};

        Map<String, List<String>> map = new HashMap<>();

        Arrays.stream(values).forEach(value -> {
            if(map.get(value[1]) == null) {
                List<String> list = new ArrayList<>();
                list.add(value[0]);
                map.put(value[1], list);
            }else{
                List<String> list = map.get(value[1]);
                list.add(value[0]);
            }
        });
        System.out.println(map);
    }


}
