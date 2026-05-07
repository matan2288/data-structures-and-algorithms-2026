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

    // Q6: Complete the following method that removes any nodes from the list
    // intNode
    // that contain the integer value n and returns a pointer to the new head of the
    // list.
    // The first item might be deleted, so the head may change.
    // If all nodes are deleted, return null.

    // ! Other Solution
    // public static Node deleteNum(int n, Node intNode) {
    // // Skip all matching nodes at the head
    // while (intNode != null && intNode.data == n) {
    // intNode = intNode.next;
    // }
    // // If list is now empty (all nodes matched), return null
    // if (intNode == null)
    // return null;

    // Node previous = intNode;
    // Node current = previous.next;

    // while (current != null) {
    // if (current.data = n) {
    // previous = current.next;
    // } else {
    // previous = current; // only advance previous if NOT deleting
    // }
    // current = current.next;

    // }

    // return intNode;
    // }

    public static Node deleteNum(int n, Node intNode) {
        if (intNode == null || intNode.next == null || intNode.next.next == null) {
            return intNode;
        }

        Node head = intNode;
        Node prev = intNode;
        Node current = prev.next;

        if (head.data == n) {
            head = current;
        }

        while (current != null) {
            if (current.data == n) {
                prev.next = current.next;
                current = current.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        Node print = deleteNum(2, list);

        printList(print);
    }
}
