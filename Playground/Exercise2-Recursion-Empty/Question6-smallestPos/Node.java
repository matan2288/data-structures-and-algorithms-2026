import java.util.Scanner;

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

    public static void main(String[] args) {
        int smallest = 0;
        int pos = 0;

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (n > 0) {
            Node current = new Node(n);
            if (smallest == 0 || current.data < smallest) {
                smallest = n;
                pos = 0;
            } else {
                pos++;
            }

            current = current.next;
            n = scan.nextInt();

        }

        // 1 2 3 0
        // 3 last occurence,
        System.out.println("The smallest value was " + smallest);
        System.out.println("The last occurrence was " + pos + " numbers before the end");

    }
}
