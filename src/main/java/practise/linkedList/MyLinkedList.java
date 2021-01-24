package practise.linkedList;

import util.ConstantsKt;

public class MyLinkedList<T> {
    Node head;
    int size;

    public void add(T data) {
        if (this.head == null) {
            head = new Node();
            Node n = new Node(data);
            head.next = n;
            return;
        }

        Node temp = this.head;
        Node n = new Node(data);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n;
        size++;
    }

    public void addAll(T... data) {
        if (head == null) {
            head = new Node();
        }
        Node temp = this.head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        for (T d : data) {
            Node n = new Node(d);
            temp.next = n;
            temp = temp.next;
            size++;
        }
    }

    public void remove(T data) {
        Node temp = this.head;
        Node n = new Node(data);

        if (head.data == data) {
            temp.next = head.next;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

    }

    public void printAllElements() {
        Node temp = this.head.next;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.data);
            sb.append(ConstantsKt.EMPTY_SPACE);
            temp = temp.next;
        }
        System.out.println(sb.toString().trim());
    }

    public Node head() {
        return head;
    }

    public int length() {
        return size;
    }

    public static class Node<T> {
        public Node next;
        T data;

        public Node() {}
        public Node(T data) {this.data = data;}

        public Node next() {
            return next;
        }

        protected void setNext(Node next) {
            this.next = next;
        }

        public T data() {
            return data;
        }

        protected void setData(T data) {
            this.data = data;
        }
    }
}
