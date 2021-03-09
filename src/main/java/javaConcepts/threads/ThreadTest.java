package javaConcepts.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadTest {
    static int count = 0;
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(2);

        /*IntStream.rangeClosed(0, 1000)
                .forEach(e -> executors.submit(() -> increment()));*/
        IntStream.rangeClosed(0, 1000)
                .forEach(e -> executors.submit(() -> incrementSync()));
        executors.shutdown();
        System.out.println(count);
    }

    private static void test() {
        ExecutorService executors = Executors.newFixedThreadPool(2);

        /*IntStream.rangeClosed(0, 1000)
                .forEach(e -> executors.submit(() -> increment()));*/
        IntStream.rangeClosed(0, 1000)
                .forEach(e -> executors.submit(() -> incrementSync()));
        executors.shutdown();
        System.out.println(count);
    }

    private static void increment() {
        count = count + 1;
    }

    private synchronized static void incrementSync() {
        count = count + 1;
    }
}
