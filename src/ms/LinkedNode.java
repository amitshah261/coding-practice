package ms;

class LinkedNode {
    private int data;
    LinkedNode next;

    LinkedNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
