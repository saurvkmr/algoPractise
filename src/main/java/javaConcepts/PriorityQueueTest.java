package javaConcepts;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        Queue q = new PriorityQueue();
        q.add("a");
        q.add("A");
        q.add("AZ");
        q.add("Ab");
        q.add("Ac");
        q.add("bc");
        q.add("db");
        q.add("bd");
        printQueue(q);
    }

    private static void printQueue(Queue q) {
        while(!q.isEmpty())
            System.out.println(q.poll());
    }
}
