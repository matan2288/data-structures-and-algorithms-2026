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

    // Q10: Merge two sorted lists into a single sorted list and return the merged list.
    // Example: firstList = {2,2,3,5,6,8}, secondList = {1,3,4,5}
    //        → merged = {1,2,2,3,3,4,5,5,6,8}
    // Create a new list — do not modify either of the two original lists.
    // public static Node merge(Node firstList, Node secondList) {

    // }

    public static void main(String[] args) {

    }
}
