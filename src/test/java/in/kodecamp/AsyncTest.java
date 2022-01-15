package in.kodecamp;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import in.kodecamp.commons.Utils;

public class AsyncTest {

    public void test() {

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","3");
        System.out.println("getParallelism=" + ForkJoinPool.commonPool().getParallelism());

        System.out.println("-------------- Completable Future---------------");

        Utils.measure(() -> {
            CompletableFuture[] tasks = IntStream.range(1, 6)
                .mapToObj((n) -> CompletableFuture.supplyAsync(() -> factTask(n)))
                .toArray(CompletableFuture[]::new);

            Arrays.stream(tasks)
                .map((task) -> task.join())
                .forEach(System.out::println);

        });

        System.out.println("-------------- Parallel Stream -----------------");
        Utils.measure(() -> {
            Integer[] values = IntStream.range(1,6)
                .parallel()
                .mapToObj((n) -> factTask(n))
                .toArray(Integer[]::new);

            Arrays.stream(values).forEach(System.out::println);

        });

        System.out.println("-------------- Sequential ---------------------");
        Utils.measure(() -> {
            Integer[] values = IntStream.range(1,6)
                .mapToObj((n) -> factTask(n))
                .toArray(Integer[]::new);
            Arrays.stream(values).forEach(System.out::println);
        });

        String msg = "Hello my name is {0} and address is {1}";
        String[] values = { "John Doe", "Naini" };
        System.out.println(MessageFormat.format(msg, (Object[])values));

    }

    static int factTask(int number) {
        System.out.println("number -> " + number);
        Utils.sleep(10);
        return IntStream.range(1, number + 1)
            .reduce(1, (carry, current) -> carry * current);
    }


}
