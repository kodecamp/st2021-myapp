package in.kodecamp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import in.kodecamp.commons.Logger;

/**
 * ListTest
 */
public class ListTest {

    static final int NO_OF_ITEMS = 1000000;

    public void setUp() {
        // Logger.log("setup", "Everything is setup");
    }

    public void testLinkedListAppend() {
        List<Integer> list = new LinkedList<>();
        long start = System.currentTimeMillis();

        for(int i = 0; i < NO_OF_ITEMS; i++) {
            list.add(i);
        }

        long timeTaken = System.currentTimeMillis() - start;
        Logger.logv("time taken", timeTaken);
        assert true;
    }

    public void testArrayListAppend() {
        List<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();

        for(int i = 0; i < NO_OF_ITEMS; i++) {
            list.add(i);
        }

        long timeTaken = System.currentTimeMillis() - start;
        Logger.logv("time taken", timeTaken);
        assert true;
    }


    public void tearDown() {
        // Logger.log("tearDown", "Everything is destroyed");
    }


}
