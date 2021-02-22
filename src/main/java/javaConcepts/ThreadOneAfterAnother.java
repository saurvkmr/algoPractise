package javaConcepts;

public class ThreadOneAfterAnother {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new WorkerThread("Thread 1"));
        Thread t2 = new Thread(new WorkerThread("Thread 2", t1));
        Thread t3 = new Thread(new WorkerThread("Thread 3", t2));

        t1.start();
        t2.start();
        t3.start();
    }

    private static class WorkerThread implements Runnable {

        String name;
        Thread th;

        public WorkerThread(String name) {
            this.name = name;
        }

        public WorkerThread(String name, Thread th) {
            this.name = name;
            this.th = th;
        }

        @Override
        public void run() {
            try {
                if (th != null) th.join();
            } catch (Exception e) {
            }

            for (int i = 0; i < 4; i++)
                System.out.println("Thread name is " + name);
        }
    }
}
