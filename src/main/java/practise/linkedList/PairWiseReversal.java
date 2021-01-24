package practise.linkedList;

import java.util.List;

public class PairWiseReversal {
    public static void main(String[] args) {
        Linked_List<String> list = new Linked_List<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        Linked_List.Node<String> temp = list.head;
        doPairWiseReversal(temp);
        printLinkedList(temp);
    }

    static void doPairWiseReversal(Linked_List.Node<String> temp) {

    }
    static void printLinkedList(Linked_List.Node<String> temp) {
        Linked_List.Node<String> cur = temp.next;
        while(cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}

class Linked_List<T> {
    public Node head = null;

    public static class Node<T> {
        T data;
        public Node next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public T getData() {
            return data;
        }
    }

    public void add(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = new Node();
            head.next = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
}
