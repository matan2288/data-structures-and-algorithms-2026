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

        if (head == null || head.next == null) {
            return 0;
        }

        Node previous = head;
        Node current = head.next;

        int min = current.data;
        int max = current.data;

        while (current != null) {
            if (previous.data > current.data) {
                max = previous.data;
            } else if (previous.data < current.data) {
                min = previous.data;
            }

            previous = previous.next;
            current = current.next;
            
        }

        System.out.println(max);
        System.out.println(min);
        return max - min;
    }

    public static void main(String[] args) {
        Node list = new Node(51, new Node(5, new Node(7, new Node(9))));

        int print = getRange(list);

        System.out.println(print);
    }
}
