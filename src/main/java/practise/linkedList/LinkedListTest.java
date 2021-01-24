package practise.linkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Walmart");
        linkedList.addAll("Amazon", "Zolando", "Shopee", "GoJek", "Grab");
        linkedList.printAllElements();
        System.out.println(linkedList.size);
    }
}
