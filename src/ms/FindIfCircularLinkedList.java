package ms;

public class FindIfCircularLinkedList {

    boolean findIfLinkedListHasCycle(LinkedNode node){
        LinkedNode slow = node;
        LinkedNode fast = node.next;

        while(fast != null && fast.next != null){
            if(slow.equals(fast)){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        FindIfCircularLinkedList fc = new FindIfCircularLinkedList();
        LinkedNode root = new LinkedNode(0);
        root.next = new LinkedNode(1);
        root.next.next = root;
        System.out.println(fc.findIfLinkedListHasCycle(root));
        root.next.next = new LinkedNode(2);
        root.next.next.next = new LinkedNode(3);
        root.next.next.next.next = new LinkedNode(4);
        System.out.println(fc.findIfLinkedListHasCycle(root));
        root.next.next.next.next.next = root.next.next;
        System.out.println(fc.findIfLinkedListHasCycle(root));
    }
}
