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

    // Q1: Complete the following method that returns the number of times that the
    // integer value num appears in the linked list pointed to by head.
    public static int findValues(int num, Node head) {
        Node current = head;
        int counter = 0;

        while (current != null) {
            if (current.data == num) {
                counter++;
            }

            current = current.next;
        }

        return counter;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        int print = findValues(2, list);

        System.out.println(print);
    }
}
