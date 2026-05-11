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

    // Q6: Complete the following method that removes any nodes from the list
    // intNode
    // that contain the integer value n and returns a pointer to the new head of the
    // list.
    // The first item might be deleted, so the head may change.
    // If all nodes are deleted, return null.
    public static Node deleteNum(int n, Node intNode) {

        if (intNode == null) {
            return null;
        } else if (intNode.data == n) {
            intNode = intNode.next;
        }

        Node listToManipulate = intNode;
        Node manipulatedListHead = listToManipulate;

        while (listToManipulate.next != null) {
            if (listToManipulate.next.data == n && listToManipulate.next.next != null) {
                listToManipulate.next = listToManipulate.next.next;
            } else {
                listToManipulate = listToManipulate.next;
            }
        }

        return manipulatedListHead;
    }

    public static void main(String[] args) {
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        Node print = deleteNum(5, list);

        LinkedListPrinter.printList(print);
    }
}
