package javaConcepts;

public class ThreadOneAfterAnother {

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new WorkerThread("Thread one"));
        Thread two = new Thread(new WorkerThread("Thread two", one));
        Thread three = new Thread(new WorkerThread("Thread three", two));

        one.start();
        two.start();
        three.start();
    }

    private static class WorkerThread implements Runnable {

        String name;
        Thread parentThread;

        public WorkerThread(String name) {
            this.name = name;
        }

        public WorkerThread(String name, Thread th) {
            this.name = name;
            this.parentThread = th;
        }

        @Override
        public void run() {
            try {
                if (parentThread != null) parentThread.join();
            } catch (Exception e) {
            }

            for (int i = 0; i < 4; i++)
                System.out.println(name);
        }
    }
}
