package javaConcepts;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
    static List<String> shared = new LinkedList<>();

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.submit(new Producer());
        ex.submit(new Consumer());
    }

    private static class Producer implements Runnable {

        @Override
        public void run() {
            synchronized (shared) {
                while(shared.size() > 1) {
                    try {
                        System.out.println("Waiting");
                        shared.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                shared.add("Saurav");
                System.out.println("Added Item");
                shared.notify();
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            synchronized (shared) {
                while(shared.size() == 0) {
                    try {
                        System.out.println("Waiting");
                        shared.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                shared.remove("Saurav");
                System.out.println("Removed Item");
                shared.notify();
            }
        }
    }
}
