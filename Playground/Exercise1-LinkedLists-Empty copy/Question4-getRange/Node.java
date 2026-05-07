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
        int min = head.data;
        int max = head.data;

        while (head != null) {
            if (head.data >= max) {
                max = head.data;
            } else if (head.data <= min) {
                min = head.data;
            }
            head = head.next;
        }

        return max - min;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        int print = getRange(list);

        System.out.println(print);
    }
}
