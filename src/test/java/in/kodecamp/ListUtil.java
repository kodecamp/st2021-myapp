package in.kodecamp;

import java.util.ArrayList;
import java.util.List;

/**
 * ListUtil
 */
public class ListUtil {

    static List<Integer> of(int upto) {
        List<Integer> numbers1 = new ArrayList<>();
        for(int i = 0 ; i < upto; i++) {
        numbers1.add(i);
        }
        return numbers1;
    }
}
