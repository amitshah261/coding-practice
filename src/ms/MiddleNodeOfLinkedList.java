package ms;

public class MiddleNodeOfLinkedList {

    private LinkedNode findMiddle(LinkedNode root) {
        LinkedNode slow = root;
        LinkedNode fast = root;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleNodeOfLinkedList mn = new MiddleNodeOfLinkedList();
        LinkedNode root = new LinkedNode(0);
        System.out.println(mn.findMiddle(root));
        root.next = new LinkedNode(1);
        root.next.next = new LinkedNode(2);
        root.next.next.next = new LinkedNode(3);
        root.next.next.next.next = new LinkedNode(4);
        System.out.println(mn.findMiddle(root));
        root.next.next.next.next.next = new LinkedNode(5);
        System.out.println(mn.findMiddle(root));
    }
}
