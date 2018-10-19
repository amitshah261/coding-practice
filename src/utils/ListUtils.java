package utils;

public class ListUtils {
    public static void printList(LinkedNode node){
        LinkedNode temp = node;
        while(temp != null){
            System.out.print(temp + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void printDoublyList(LinkedNode node){
        LinkedNode temp = node;
        while(temp != null){
            System.out.print("[ prev: " + temp.prev + " | " + temp  + "] -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
