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

    public static void printList(Node head) {
        for (Node n = head; n != null; n = n.next) {
            System.out.print(n.data + " -> ");
        }
        System.out.println("null");
    }

    // Q9: Return the length of the longest sequence of identical consecutive values
    // in the linked list pointed to by intList.
    // Example: (2,1,1,1,1,1,8,3,3,3,6,6) → 5 (five consecutive 1s).
    // If the list is empty, return 0.
    public static int getLongest(Node intList) {
        if (intList == null || intList.next == null) {
            return 0;
        }

        int counter = 0;
        int tmpCounter = 0;
        int longest = 0;

        Node prev = intList;
        Node current = prev.next;

        while (prev != null) {
            System.out.println("Outer loop: current.data = " + current.data);
            while (current.next != null) {
                if (prev.data == current.data) {
                    tmpCounter++;
                }
                System.out.println("  Inner loop: prev.data = " + prev.data + ", current.data = " + current.data);

                current = current.next;
            }

            if (counter < tmpCounter) {
                counter = tmpCounter;
                tmpCounter = 0;
                longest = current.data;
            }

            current = prev.next;
            prev = prev.next;
        }

        System.out.println(counter);

        return longest;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9, new Node(9)))));

        int print = getLongest(list);

        System.out.println(print);
    }
}
