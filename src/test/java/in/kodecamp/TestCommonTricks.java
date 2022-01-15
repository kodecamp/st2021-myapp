package in.kodecamp;

import java.util.stream.IntStream;

/**
 * StringUtilTest
 */
public class TestCommonTricks {
    public void testUtil() {
        IntStream.iterate(0, (i) -> i + 3)
            .limit(10)
            .filter((n) -> n % 2 == 0)
            .forEach(System.out::println);
    }

    public void testFooBar() {
        // if devided by 2 -> foo
        // if divided by 3 -> bar
        // if divided by 2 and 3 both -> foo/bar
    }
}
