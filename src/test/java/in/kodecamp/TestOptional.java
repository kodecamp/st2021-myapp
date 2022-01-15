package in.kodecamp;

import in.kodecamp.optionals.TestConditionals;

/**
 * TestOptional
 */
public class TestOptional {

    public void testStartWithFirst() {
        System.out.println("-> testStartWithFirst =================");
        String val = TestConditionals.test2("First Name");
        System.out.println("============== : " + val);
    }

    public void testStartWithSecond() {
        System.out.println("-> testStartWithSecond =================");
        String val = TestConditionals.test2("Second Name");
        System.out.println("============== : " + val);
    }

    public void testStartWithOther() {
        System.out.println("-> testStartWithOther =================");
        String val = TestConditionals.test2("abcd Name");
        System.out.println("============== : " + val);
    }

}
