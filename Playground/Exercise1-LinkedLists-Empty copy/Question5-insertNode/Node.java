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

    // Q5: Assuming the list pointed to by intNode is sorted in ascending order,
    // insert a node containing val into the correct position and return a pointer
    // to the head of the list.
    // The list might be empty (intNode == null), or val might be smaller than the
    // first value, so the head may change.

    //! Other Solution
    // public static Node insertNode(int val, Node intNode) {
    // Node headnode_backup = intNode;
    // Node previous = intNode;
    // Node current = previous.next;

    // while (current != null) {
    // if (current.data <= val && current.next.data >= val) {
    // previous = current;
    // current = new Node(val);
    // current = current.next;
    // } else {
    // current = current.next;
    // }

    // }

    // return headnode_backup;
    // }

    public static Node insertNode(int val, Node intNode) {
        if (intNode == null || intNode.next == null) {
            return intNode;
        }
        Node head = intNode;
        Node new_node = new Node(val);
        Node before_val = intNode;
        Node after_val = intNode;

        while (intNode.next != null) {
            if (intNode.data <= val && intNode.next.data >= val) {
                before_val = intNode;
            } else if (intNode.data >= val) {
                after_val = intNode;
            }
            intNode = intNode.next;
        }

        before_val.next = new_node;
        new_node.next = after_val;

        return head;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        Node print = insertNode(6, list);

        printList(print);
    }
}
