package in.kodecamp;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * TestGuava
 */
public class TestGuava {

    public void testStream() {
        List<SampleObj> objects = List.of(
                SampleObj.from("Sunil", "Lucknow", 100),
                SampleObj.from("Suresh", "Lucknow", 200),
                SampleObj.from("Rakesh", "Delhi", 300),
                SampleObj.from("Dinesh", "Delhi", 300),
                SampleObj.from("Diego", "Delhi", 300));

        Map<String, List<SampleObj>> groups = objects
                                            .stream()
                                            .collect(groupingBy(SampleObj::city));

        System.out.println(groups);

        Map<String, Double> average = objects
                                        .stream()
                                        .collect(groupingBy(
                                                SampleObj::city,
                                                averagingDouble(SampleObj::salary)));

        System.out.println(average);
        SortedMap<String, Double> smap = new TreeMap<>(average);
        System.out.println(smap);
    }

    /**<p>
     * This SampleObj
     * </p>
     * */
    private static class SampleObj {
        String name;
        String city;
        int salary;

        /**
         * <p>
         * Protected Constructor
         * </p>
         * @param name
         * @param city
         * @param salary
         */
        SampleObj(String name, String city, int salary) {
            this.name = name;
            this.city = city;
            this.salary = salary;
        }

        /**
         *
         * @param name
         * @param city
         * @param salary
         * @return
         */
        static SampleObj from(String name, String city, int salary) {
            return new SampleObj(name, city, salary);
        }

        public String city() {
            return this.city;
        }

        public int salary() {
            return this.salary;
        }

        @Override
        public String toString() {
            return String.format("[ name = %s, city = %s, salary = %d ]",
                    name, city, salary);
        }
    }

}
