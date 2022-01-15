package in.kodecamp.optionals;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper
 */
public final class Helper {

    static enum ConditionKeys {
        FIRST, SECOND, THIRD
    }

    public static Map<ConditionKeys, Rule<String>> createConditionsMap(String orgValue) {
        Map<ConditionKeys, Rule<String>> map = new HashMap<>();
        map.put(ConditionKeys.FIRST, startWithFirstRule(orgValue));
        map.put(ConditionKeys.SECOND, startWithSecondRule(orgValue));
        map.put(ConditionKeys.THIRD, startWithThirdRule(orgValue));
        return map;

    }

    static private Rule<String> startWithFirstRule(String orgValue) {
        return Rule.<String>builder()
            .condition( () -> orgValue.startsWith("First"))
            .block(Helper::methodFirst)
            .build();
    }

    static private Rule<String> startWithSecondRule(String orgValue) {
        return Rule.<String>builder()
            .condition( () -> orgValue.startsWith("Second"))
            .block(Helper::methodSecond)
            .build();
    }

    static private Rule<String> startWithThirdRule(String orgValue) {
        return Rule.<String>builder()
            .condition( () -> orgValue.startsWith("Third"))
            .block(Helper::methodThird)
            .build();
    }

    static private Rule<String> startWithOtherRule(String orgValue) {
        return Rule.<String>builder()
            .condition( () -> orgValue.startsWith("Second"))
            .block(Helper::methodSecond)
            .build();
    }

    static private String methodFirst() {
        return "First Value Check";
    }

    static private String methodSecond() {
        return "Second Value Check";
    }

    static private String methodThird() {
        return "Second Value Check";
    }

    static public String methodOther() {
        return "Other Value Check";
    }

}

