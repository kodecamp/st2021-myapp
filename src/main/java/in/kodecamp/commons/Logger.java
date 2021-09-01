package in.kodecamp.commons;

import java.util.Arrays;
import java.util.stream.Stream;

public class Logger {

  static public void log(Object... args) {
    String nameofCurrMethod = new Throwable()
                                      .getStackTrace()[1]
                                      .getMethodName();
    Stream<Object> streams = Arrays.stream(args);
    //@formatter:off
        System.out.println("### Method => "+nameofCurrMethod);
        String msg = streams.map((Object obj) -> obj.toString())
            .reduce((finalStr, str) -> finalStr +" -> "+ str).get();
        System.out.println(msg);
        //@formatter:on
  }

  static public void logv(Object... args) {

    String nameofCurrMethod = new Throwable()
                                      .getStackTrace()[1]
                                      .getMethodName();
    Stream<Object> streams = Arrays.stream(args);
    //@formatter:off
        String msg = streams.map((Object obj) -> obj.toString())
            .reduce((finalStr, str) -> finalStr +" =: "+ str).get();

        System.out.println("### Method => "+nameofCurrMethod);
        System.out.println(msg);
        //@formatter:on
  }
}
