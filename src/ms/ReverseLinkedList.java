package ms;

import utils.LinkedNode;
import utils.ListUtils;

/*
    In-place reversal of a linked list.
 */
public class ReverseLinkedList {

    private LinkedNode reverseList(LinkedNode root) {
        LinkedNode prev = null, next = null;
        LinkedNode temp = root;

        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    private LinkedNode reverseDoublyLinkedList(LinkedNode root){
        if(root == null){
            return root;
        }
        LinkedNode temp = root;
        LinkedNode next = null, prev = null;
        while(temp != null){
            next = temp.next;
            temp.next = temp.prev;
            temp.prev = next;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    /*
    1 > 2 > 3 > 4 > 5
    next = 2
    1 > null
    prev = 1
    temp = 2
    < 1  2 > 3 > 4 > 5
    */
    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        LinkedNode root = new LinkedNode(0);
        root.next = new LinkedNode(1);
        root.next.prev = root;
        root.next.next = new LinkedNode(2);
        root.next.next.prev = root.next;
        root.next.next.next = new LinkedNode(3);
        root.next.next.next.prev = root.next.next;
        root.next.next.next.next = new LinkedNode(4);
        root.next.next.next.next.prev = root.next.next.next;
        root.next.next.next.next.next = new LinkedNode(5);
        root.next.next.next.next.next.prev = root.next.next.next.next;
        ListUtils.printList(root);
//        ListUtils.printList(rl.reverseList(root));
        ListUtils.printDoublyList(rl.reverseDoublyLinkedList(root));
    }
}
