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

    // Q3: Complete the following method that tests if the linked list pointed to by
    // head is sorted in ascending order (each element is less than or equal to the
    // next one). Return true if sorted, false otherwise.
    // An empty list or a single-element list is considered sorted.
    public static boolean sorted(Node head) {
        boolean isSorted = true;

        if (head == null) {
            return isSorted;
        }

        Node previous = head;
        Node current = previous.next;

        while (current != null) {

            if (previous.data > current.data) {
                isSorted = false;
            }

            previous = previous.next;
            current = current.next;
        }

        return isSorted;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        boolean print = sorted(list);

        System.out.println(print);
    }
}
