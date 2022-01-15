package in.kodecamp;

import java.util.Objects;

/**
 * TestObjects
 */
public class TestObjects {


    public void testRequireNotNull() {
        String msg = null;
        // String value = Objects.requireNonNull(msg);
        // String value = Objects.requireNonNullElse(msg, "Default Value");
        String value = Objects
            .requireNonNullElseGet(msg, TestObjects::defaultValue);
        System.out.println("--> value : " + value);
    }

    static void testObject(TestObject to) {
        var testObj = Objects.requireNonNullElse(to, TestObject.empty());

    }

    // value supplier method
    static String defaultValue() {
        return "Some Default Value From Algo";
    }

    static class TestObject {
        private final String value1;
        private final String value2;

        private TestObject(String val1, String val2) {
            this.value1 = Objects.requireNonNullElse(val1, "");
            this.value2 = Objects.requireNonNullElseGet(val2, () -> "");
        }

        static TestObject from(String value1, String value2) {
            return new TestObject(value1, value2);
        }

        static TestObject empty() {
            return new TestObject("", "");
        }

    }
}
