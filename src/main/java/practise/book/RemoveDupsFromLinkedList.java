package practise.book;

import practise.linkedList.MyLinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupsFromLinkedList {
    public static void main(String[] args) {
        final MyLinkedList<String> list = new MyLinkedList<>();
        list.addAll("Amazon", "Zolando", "Shopee", "GoJek", "Grab", "Shopee", "GoJek", "Grab", "Walmart", "Twitter", "Facbook");
        list.printAllElements();
        removeDups(list);
    }

    public static void removeDups(MyLinkedList<String> list) {
        Set<String> uniqueElem = new HashSet<>();
        MyLinkedList.Node<String> temp = new MyLinkedList.Node();
        temp = list.head();
        if (list.length() < 2) {
            list.printAllElements();
            return;
        }
        while(temp != null) {
            if (temp.next != null && uniqueElem.contains(temp.next.data())) {
                temp.next = temp.next.next;
                continue;
            }
            uniqueElem.add(temp.data());
            temp = temp.next;
        }
        list.printAllElements();
    }
}
