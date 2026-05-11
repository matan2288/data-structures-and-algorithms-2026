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

    // Q10: Merge two sorted lists into a single sorted list and return the merged
    // list.
    // Example: firstList = {2,2,3,5,6,8}, secondList = {1,3,4,5}
    // → merged = {1,2,2,3,3,4,5,5,6,8}
    // Create a new list — do not modify either of the two original lists.
    public static Node merge(Node firstList, Node secondList) {
        if (firstList == null || firstList.next == null || secondList == null || secondList.next == null) {
            return null;
        }

        Node head1 = firstList;
        Node head2 = secondList;

        Node combined = null;

        if (head1.data >= head2.data) {
            combined = head2;
            head2 = head2.next;
        } else {
            combined = head1;
            head1 = head1.next;
        }

        combined.next = null;

        Node combined_head = combined;

        while (head1 != null && head2 != null) {

            if (head1.data >= head2.data) {
                combined.next = head2;
                head2 = head2.next;
            } else {
                combined.next = head1;
                head1 = head1.next;

            }

            combined = combined.next;
        }

        if (head2 != null) {
            combined.next = head2;
        } else {
            combined.next = head1;
        }

        return combined_head;
    }

    public static void main(String[] args) {
        Node list1 = new Node(3, new Node(4, new Node(7, new Node(9, new Node(11)))));

        Node list2 = new Node(1, new Node(2, new Node(8, new Node(11))));

        Node print = merge(list1, list2);
        printList(print);

    }
}
