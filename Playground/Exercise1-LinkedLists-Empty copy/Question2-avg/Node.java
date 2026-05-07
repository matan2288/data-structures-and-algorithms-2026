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

    // Q2: Complete the following method that calculates the average of the values
    // in the linked list pointed to by list. The average should be reported as 0
    // if the list is empty.
    public static double avg(Node list) {
        double sum = 0;
        int counter = 0;

        while (list != null) {
            sum = sum + list.data;
            counter++;
            list = list.next;
        }

        return sum / counter;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        double print = avg(list);

        System.out.println(print);
    }
}
