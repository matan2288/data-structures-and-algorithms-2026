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

    // Q3: Complete the method getMaxItem to return a pointer to the largest element
    // of the linked list given by the parameter ptr, or return null if the list is
    // empty.
    // Your solution must be recursive.
    public static Node getMaxItem(Node ptr) {

        if (ptr == null || ptr.next == null) {
            return null;
        }

        Node previous = ptr;
        Node current = previous.next;
        
        if (current != null && current.data > max) {
            current = current.next;
            return getMaxItem(current);
        }

        return ptr;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(3, new Node(4))));
        Node print = findNode(list, 5);

        System.out.println(print);
    }
}
