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

    // Q2: Complete the method findNode to return a pointer to the element of the
    // linked list at position n, or return null if there is no such element.
    // The first element of the list is element number 0.
    // Your solution must be recursive.
    public static Node findNode(Node list, int n) {
        if (list == null) {
            return null;
        }
        if (n == 0) {
            return list;
        }
        return findNode(list.next, n - 1);
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));
        Node result = findNode(list, 2);
        System.out.println(result.data);
    }
}
