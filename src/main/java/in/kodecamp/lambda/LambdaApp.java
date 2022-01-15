package in.kodecamp.lambda;

import java.util.List;
import java.util.function.Function;

/**
 * LambdaApp
 */
public class LambdaApp {

  public static void main(String[] args) {
    String value = "";
    Function<String, String> nullValidator = (str) -> str == null ? "Value is null" : str;
    Function<String, String> emptyValidator = (str) -> str.equals("")  ? "Value is empty" : str;


    String msg = validate(value,nullValidator);
    System.out.println("============ msg : " + msg);
  }

  static void strategyPattern() {
  }

  static int mult(Integer value1, Integer value2) {
     return value1.intValue() * value2.intValue();
  }

  static int calculate(List<Integer> numbers, Function<List<Integer>, Integer> operation) {
    return operation.apply(numbers);
  }

  static String validate(String value, Function<String, String> func) {
    return func.apply(value);
  }
}


