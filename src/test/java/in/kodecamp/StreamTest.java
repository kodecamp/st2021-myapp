package in.kodecamp;

import java.util.Optional;

import in.kodecamp.entities.TestEmployee;

public class StreamTest {

	public StreamTest() {
	}

	public void testStream() {
        //@formatter:off
        TestEmployee.getAllEmployees()
            .stream()
            .filter(StreamTest::filter)
            .map(StreamTest::map)
            .forEach(e -> {
                System.out.println("inserted in db : " + e.id);
            });
        //@formatter:on
    }

    public void testInfiniteCollection(Optional<Integer> value) {
        var rs = value.filter((val) -> val > 10)
            .map((val) -> val * 10)
            .get();
        System.out.println(":::::::::::::::::::::::: get -> " + rs);
    }

    // hello this is
    static boolean filter(TestEmployee emp) {
        System.out.println("filter: " + emp.id);
        return emp.billAmount > 200;
    }

    static TestEmployee map(TestEmployee emp) {
        System.out.println("map: " + emp.id);
        return emp;
    }
}
