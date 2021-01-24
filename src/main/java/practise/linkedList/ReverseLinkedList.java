package practise.linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.addAll("a", "b", "c", "d", "e", "f", "g");
        MyLinkedList.Node<String> node = linkedList.head;
        reverseLinkedList(node, linkedList);
    }

    static void reverseLinkedList(MyLinkedList.Node<String> node, MyLinkedList<String> linkedList) {
        MyLinkedList.Node<String> prev = node.next;
        MyLinkedList.Node<String> curr = prev.next;
        MyLinkedList.Node<String> next = curr.next;
        System.out.println(prev.data);
        prev.next = null;
        while(next.next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        if (next.next == null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            curr.next = prev;
            linkedList.head.next = curr;
        }

        linkedList.printAllElements();
    }
}
