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

    // Q4: Complete the following method that returns the difference between the
    // maximum and minimum value in the linked list pointed to by head.
    // Return 0 if the list is empty.
    public static int getRange(Node head) {
        if (head == null) {
            return 0;
        }

        Node current = head;
        int min = current.data;
        int max = current.data;

        while (current != null) {
            if (current.data >= max) {
                max = current.data;
            } else if (current.data <= min) {
                min = current.data;
            }

            current = current.next;
        }

        return max - min;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        int print = getRange(list);

        System.out.println(print);
    }
}
