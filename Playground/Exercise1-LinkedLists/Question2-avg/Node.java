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
        Node current = list;
        int counter = 0;
        double sum = 0;

        while(current != null) {
            counter++;
            sum = sum + current.data; 

            current = current.next;
        }

        return sum / counter;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        double print = avg(list);

        System.out.println(print);
    }
}
