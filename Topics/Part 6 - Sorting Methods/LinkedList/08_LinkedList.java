// Linked list — nodes chained by next references.
// Access by index: O(n) | Prepend at head: O(1) | Traverse all: O(n)
// Space: O(1) per new node (excluding stored elements)
class LinkedList {

    record Node(int data, Node next) { }

    // O(1) — new node points at current head
    static Node prepend(Node head, int value) {
        return new Node(value, head);
    }

    // O(n) — walk index steps from the head
    static int getAt(Node head, int index) {
        if (head == null) throw new IndexOutOfBoundsException(index);
        if (index == 0)   return head.data();
        return getAt(head.next(), index - 1);  // recurse toward target
    }

    // O(n) — visit every node once
    static void print(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        System.out.print(head.data() + (head.next() != null ? " -> " : " -> "));
        print(head.next());
    }

    public static void main(String[] args) {
        Node head = null;
        head = prepend(head, 3);
        head = prepend(head, 2);
        head = prepend(head, 1);

        System.out.print("Linked list:   ");
        print(head);

        System.out.println("getAt(2) O(n): " + getAt(head, 2));

        head = prepend(head, 0);
        System.out.print("After prepend: ");
        print(head);
    }
}
