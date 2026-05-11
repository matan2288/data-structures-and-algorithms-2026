public class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this(data, null);
    }

    // Q8: Complete the following method that reverses the pointers in the linked
    // list
    // pointed to by intList and returns a pointer to the new head (originally the
    // last node).
    // Do not create new nodes, free existing nodes, or modify any data values.
    public static Node reverse(Node intList) {
        // TODO: implement
        return null;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        Node print = reverse(list);

        LinkedListPrinter.printList(print);
    }
}
