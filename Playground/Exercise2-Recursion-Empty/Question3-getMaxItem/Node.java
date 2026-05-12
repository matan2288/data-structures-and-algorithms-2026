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

        if (ptr.next != null && (ptr.data <= ptr.next.data)) {
            ptr = ptr.next;
            return getMaxItem(ptr);
        }

        return ptr;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(3, new Node(4))));
        Node print = getMaxItem(list);

        System.out.println(print);
    }
}
