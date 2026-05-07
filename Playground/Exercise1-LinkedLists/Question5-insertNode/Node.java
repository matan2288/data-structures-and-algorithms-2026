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

    // Q5: Assuming the list pointed to by intNode is sorted in ascending order,
    // insert a node containing val into the correct position and return a pointer
    // to the head of the list.
    // The list might be empty (intNode == null), or val might be smaller than the
    // first value, so the head may change.
    public static Node insertNode(int val, Node intNode) {
        Node newNode = new Node(val);

        if (intNode == null || val <= intNode.data) {
            newNode.next = intNode;
            return newNode;
        }

        Node previous = intNode;
        Node current = previous.next;

        while (current != null) {
            if (val >= previous.data && val <= current.data) {
                previous.next = newNode;
                newNode.next = current;
                return intNode;
            } else {
                previous = previous.next;
                current = current.next;
            }
        }

        return intNode;
    }

    // --- Helper: print a linked list ---
    public static void printList(Node head) {
        for (Node n = head; n != null; n = n.next)
            System.out.print(n.data + " -> ");
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        Node print = insertNode(6, list);

        printList(print);
    }
}
