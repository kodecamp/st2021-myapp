package in.kodecamp.optionals;

import java.util.Map;
import java.util.stream.Stream;

import in.kodecamp.optionals.Helper.ConditionKeys;

/**
 * TestConditionals
 */
public class TestConditionals {

    public String test1(String value) {
        // if( value != null) {
        //     return value.toUpperCase();
        // }
        // return value;
        return value != null ? value.toUpperCase(): value;
    }

    public static String test2(String value) {

        // if(value == null) {
        //     return methodFirst();
        // }
        // if(value.startsWith("First")) {
        //     return methodFirst();
        // }else if (value.startsWith("Second")) {
        //     return methodSecond();
        // }
        // return methodOther();
        Map<ConditionKeys, Rule<String>> rules = Helper.createConditionsMap(value);
        return Stream.of(ConditionKeys.values())
            .filter(conditionKey -> rules.get(conditionKey).condition().get())
            .map(conditionKey -> rules.get(conditionKey).block().get())
            .findFirst()
            .orElse(Helper.methodOther());



    }



}
