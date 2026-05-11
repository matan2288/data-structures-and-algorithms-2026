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

    // Q1: Complete the method items to return the length of the linked list
    // given as its parameter (intList).
    // Your solution must be recursive.

    // Node current = head;
    // int counter = 0;

    // while (current != null) {
    // if (current.data == num) {
    // counter++;
    // }

    // current = current.next;
    // }

    // return counter;
    public static int items(Node intList) {
        Node current = intList;
        int counter = 0;

        if (current != null) {
            current = current.next;
            counter++;
            return counter + items(current);
        }

        return counter;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));
        int print = items(list);

        System.out.println(print);
    }
}
