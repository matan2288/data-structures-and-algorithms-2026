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
        System.out.println("null");
    }

    // Q6: Complete the following method that removes any nodes from the list
    // intNode
    // that contain the integer value n and returns a pointer to the new head of the
    // list.
    // The first item might be deleted, so the head may change.
    // If all nodes are deleted, return null.
    public static Node deleteNum(int n, Node intNode) {
        if (intNode == null || intNode.next == null) {
            return intNode;
        } else if(intNode.data == n) {
            return intNode.next;
        }

        Node prev = intNode;
        Node current = intNode.next;

        while (current != null) {
            if (current.data == n) {
                prev.next = current.next;
                break;
            } else {
                prev = prev.next;
                current = current.next;
            }

        }

        return intNode;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7,  new Node(9))));

        Node print = deleteNum(5, list);

        printList(print);
    }
}
