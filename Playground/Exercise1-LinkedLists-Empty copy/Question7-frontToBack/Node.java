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

    // --- Helper: print a linked list ---
    public static void printList(Node head) {
        for (Node n = head; n != null; n = n.next)
            System.out.print(n.data + " -> ");
        System.out.println("null");
    }

    // Q7: Complete the following method that moves the first_pointer node in the linked
    // list
    // pointed to by intList to the end of the list and returns a pointer to the new
    // head.
    // If the list is empty or contains only one node, do not change the list.
    // Do this without creating any new Nodes.
    public static Node frontToBack(Node intList) {
        // TODO: implement
        return null;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        Node print = frontToBack(list);

        printList(print);
    }
}
