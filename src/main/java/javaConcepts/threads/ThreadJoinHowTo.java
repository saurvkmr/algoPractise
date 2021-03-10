package javaConcepts.threads;

import java.util.stream.IntStream;

public class ThreadJoinHowTo {
    public static void main(String[] args) {
        try {
            Thread th1 = new Thread(new WorkerThread("Thread_1"));
            Thread th2 = new Thread(new WorkerThread("Thread_2"));
            Thread th3 = new Thread(new WorkerThread("Thread_3"));

            th1.start();
            th1.join();

            th2.start();
            th2.join();

            th3.start();
            th3.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private static class WorkerThread implements Runnable {
        String threadName;
        WorkerThread(String nameThread) {
            threadName = nameThread;
        }
        @Override
        public void run() {
            IntStream.rangeClosed(0, 20)
                    .forEach(e -> System.out.println(String.join(" ", threadName, String.valueOf(e))));
        }
    }
}
