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

    // Q5: Assuming the list pointed to by intNode is sorted in ascending order,
    // insert a node containing val into the correct position and return a pointer
    // to the head of the list.
    // The list might be empty (intNode == null), or val might be smaller than the
    // first value, so the head may change.
    // public static Node insertNode(int val, Node intNode) {

    // }

    public static void main(String[] args) {

    }
}
