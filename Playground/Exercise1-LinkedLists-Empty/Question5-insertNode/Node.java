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

    public static void printList(Node head) {
        for (Node n = head; n != null; n = n.next) {
            System.out.print(n.data + " -> ");
        }

        // System.out.println("Previous node data: " + (previous != null ? previous.data
        // : "null"));
        // System.out.println("Current node data: " + (current != null ? current.data :
        // "null"));

        System.out.println("null");
    }

    // Q5: Assuming the list pointed to by intNode is sorted in ascending order,
    // insert a node containing val into the correct position and return a pointer
    // to the head of the list.
    // The list might be empty (intNode == null), or val might be smaller than the
    // first value, so the head may change.
    public static Node insertNode(int val, Node intNode) {
        if (intNode == null || intNode.next == null) {
            return intNode;
        }

        Node newNode = new Node(val);
        Node prev = intNode;
        Node current = intNode.next;

        while (current != null) {

            if (prev.data <= val && current.data >= val) {
                prev.next = newNode;
                newNode.next = current;
                return intNode;
            } else {
                prev = prev.next;
                current = current.next;
            }
        }

        return intNode;

    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        Node print = insertNode(6, list);

        printList(print);
    }
}
