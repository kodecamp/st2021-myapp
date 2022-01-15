package in.kodecamp;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

import java.util.List;
import java.util.Map;

import in.kodecamp.entities.TestEmployee;


public class GroupByTest {

    public void testGroupByCity() {
        System.out.println("-----------testGroupByCity --------");
        //@formatter:off

        Map<GroupByKey, List<TestEmployee>> empMap = TestEmployee.getAllEmployees().stream()
            .collect(
                    groupingBy(e -> new GroupByKey(e.id, e.name))
                    ); // end of collect
        System.out.println(empMap);

        Map<GroupByKey, Double> empMapWithTotal = TestEmployee.getAllEmployees().stream()
            .collect(
                    groupingBy(e -> new GroupByKey(e.id, e.name), summingDouble(TestEmployee::billAmount))
                    ); // end of collect
        System.out.println(empMapWithTotal);

        Map<GroupByKey, Double> empMapWithAverage = TestEmployee.getAllEmployees().stream()
            .collect(
                    groupingBy(e -> new GroupByKey(e.id, e.name), averagingDouble(TestEmployee::billAmount))
                    ); // end of collect
        System.out.println(empMapWithAverage);
        //@formatter:on
    }


}

class GroupByKey {
    int id;
    String name;
    GroupByKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int id() {
        return this.id;
    }
    String name() {
        return this.name;
    }

    // groupby key
    public int hashCode() {
        return this.id;
    }

    // groupby key equals
    public boolean equals(Object obj) {
        GroupByKey gk = (GroupByKey) obj;
        return this.id == gk.id;
    }

    public String toString() {
        return String.format(" %d:%s ", this.id, this.name);
    }

}


