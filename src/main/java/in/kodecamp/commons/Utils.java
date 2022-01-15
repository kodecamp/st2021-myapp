package in.kodecamp.commons;

import java.time.Duration;
import java.time.Instant;

public final class Utils {

  static public void measure(Runnable code) {
    Instant start = Instant.now();
    code.run();
    long timeTaken = Duration.between(start, Instant.now()).toMillis();
    System.out.println("Time Taken : " + timeTaken);

  }

  static public void sleep(int delayFactor) {
    try {
      Thread.sleep(delayFactor* 100);
    }catch(InterruptedException iEx) { }

  }
}
