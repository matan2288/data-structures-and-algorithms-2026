class LinkedListExample {

    // A Node is the building block of a linked list.
    // Each node holds a value (data) and a reference to the next node in the chain.
    // The last node's "next" is null, marking the end of the list.
    //
    //  [1 | *] -> [2 | *] -> [3 | null]
    //   data next   data next   data next
    record Node(int data, Node next) { }

    public static void main(String[] args) {

        // === Building the list node by node using references (pointers) ===

        Node c = new Node(3, null);  // c -> [3 | null]
        Node b = new Node(2, c);     // b -> [2 | *] -> [3 | null]
        Node a = new Node(1, b);     // a -> [1 | *] -> [2 | *] -> [3 | null]

        // 'a' is the head of the list.
        // 'a.next()' is a reference that points to 'b'.
        // 'b.next()' is a reference that points to 'c'.
        // 'c.next()' is null — end of the list.

        System.out.println("a.data(): " + a.data());         // 1
        System.out.println("a.next(): " + a.next());         // Node[data=2, next=Node[...]]
        System.out.println("a.next() == b: " + (a.next() == b)); // true — same reference

        // === Traversing the list by following references ===

        for (Node n = a; n != null; n = n.next())
            System.out.print(n.data() + " -> ");
        System.out.println("null"); // 1 -> 2 -> 3 -> null
    }
}
