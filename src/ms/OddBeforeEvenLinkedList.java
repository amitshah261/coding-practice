package ms;

public class OddBeforeEvenLinkedList {

    private LinkedNode placeOddBeforeEven(LinkedNode root) {
        LinkedNode even = root;
        LinkedNode evenHead = even;
        if (root == null || root.next == null) {
            return root;
        }
        LinkedNode odd = root.next;
        LinkedNode oddHead = odd;
        while (odd.next != null) {
            even.next = odd.next;
            odd.next = odd.next.next;
            even = even.next;
            if (odd.next != null)
                odd = odd.next;
        }
        even.next = null;
        odd.next = evenHead;
        return oddHead;
    }

    private void printList(LinkedNode root) {
        while (root != null) {
            System.out.print(root + " -> ");
            root = root.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        OddBeforeEvenLinkedList obe = new OddBeforeEvenLinkedList();
        System.out.println("1) CurrentList: ");
        obe.printList(null);
        System.out.println("After adjustment: ");
        obe.printList(obe.placeOddBeforeEven(null));
        LinkedNode root = new LinkedNode(0);
        System.out.println("\n2) CurrentList: ");
        obe.printList(root);
        System.out.println("After adjustment: ");
        obe.printList(obe.placeOddBeforeEven(root));
        root.next = new LinkedNode(1);
        root.next.next = new LinkedNode(2);
        root.next.next.next = new LinkedNode(3);
        root.next.next.next.next = new LinkedNode(4);
        root.next.next.next.next.next = new LinkedNode(5);
        System.out.println("\n3) CurrentList: ");
        obe.printList(root);
        System.out.println("After adjustment: ");
        obe.printList(obe.placeOddBeforeEven(root));
        System.out.println("\n4) CurrentList: ");
        obe.printList(root);
        System.out.println("After adjustment: ");
        obe.printList(obe.placeOddBeforeEven(root));
    }
}
