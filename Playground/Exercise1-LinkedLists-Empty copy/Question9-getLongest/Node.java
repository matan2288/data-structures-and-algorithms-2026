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
        for (Node n = head; n != null; n = n.next)
            System.out.print(n.data + " -> ");
        System.out.println("null");
    }

    // Q9: Return the length of the longest sequence of identical consecutive values
    // in the linked list pointed to by intList.
    // Example: (2,1,1,1,1,1,8,3,3,3,6,6) → 5 (five consecutive 1s).
    // If the list is empty, return 0.
    public static int getLongest(Node intList) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        // Node list = new Node(1,
        //         new Node(1,
        //                 new Node(2,
        //                         new Node(1,
        //                                 new Node(1,
        //                                         new Node(1,
        //                                                 new Node(8,
        //                                                         new Node(3,
        //                                                                 new Node(3,
        //                                                                         new Node(3,
        //                                                                                 new Node(6,
        //                                                                                         new Node(6))))))))))));

        Node list = new Node(1, new Node(1, new Node(1)));

        int print = getLongest(list);

        System.out.println(print);

    }
}
