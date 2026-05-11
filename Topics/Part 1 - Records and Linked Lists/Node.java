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

    // --- Q4: Check if a linked list is sorted in ascending order ---
    public static boolean sorted(Node head) {
        Node current = head;
        int temp = current.data;
        boolean isSorted = true;
        current = current.next;

        while (current != null) {
            if (current.data < temp) {
                isSorted = false;
                break;
            }
            current = current.next;
        }

        return isSorted;
    }

    // --- Q5: Insert a node with value val into a sorted list in the correct position ---
    public static Node insertNode(int val, Node intNode) {
        Node newNode = new Node(val);

        if (intNode == null || val <= intNode.data) {
            newNode.next = intNode;
            return newNode;
        }

        Node previous = null;
        Node current = intNode;

        while (current != null && current.data < val) {
            previous = current;
            current = current.next;
        }

        previous.next = newNode;
        newNode.next = current;
        return intNode;
    }

    // --- Q6: Remove all nodes containing value n from the list ---
    public static Node deleteNum(int n, Node intNode) {
        while (intNode != null && intNode.data == n) {
            intNode = intNode.next;
        }

        Node previous = null;
        Node current = intNode;

        while (current != null) {
            if (current.data == n) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return intNode;
    }

    // --- Q7: Move the first node to the end of the list, no new nodes ---
    public static Node frontToBack(Node intList) {
        if (intList == null || intList.next == null) {
            return intList;
        }

        Node first = intList;
        intList = intList.next;

        Node current = intList;
        while (current.next != null) {
            current = current.next;
        }

        current.next = first;
        first.next = null;

        return intList;
    }

    // --- Q8: Reverse the linked list, no new nodes ---
    public static Node reverse(Node intList) {
        Node previous = null;
        Node current = intList;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    // --- Q9: Return the length of the longest sequence of identical consecutive values ---
    public static int getLongest(Node intList) {
        if (intList == null) {
            return 0;
        }

        int longest = 1;
        int streak = 1;
        Node previous = intList;
        Node current = intList.next;

        while (current != null) {
            if (current.data == previous.data) {
                streak++;
            } else {
                streak = 1;
            }
            if (streak > longest) {
                longest = streak;
            }
            previous = current;
            current = current.next;
        }

        return longest;
    }

    // --- Q10: Merge two sorted lists into a new sorted list (without modifying originals) ---
    public static Node merge(Node firstList, Node secondList) {
        Node dummy = new Node(0);
        Node tail = dummy;

        Node f = firstList;
        Node s = secondList;

        while (f != null && s != null) {
            if (f.data <= s.data) {
                tail.next = new Node(f.data);
                f = f.next;
            } else {
                tail.next = new Node(s.data);
                s = s.next;
            }
            tail = tail.next;
        }

        Node remaining = (f != null) ? f : s;
        while (remaining != null) {
            tail.next = new Node(remaining.data);
            tail = tail.next;
            remaining = remaining.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Build list: 2 -> 5 -> 7 -> 9 -> null
        Node list = new Node(2, new Node(5, new Node(7, new Node(9))));

        System.out.println("=== Original list ===");
        LinkedListPrinter.printList(list);

        // Q4: sorted
        System.out.println("\n=== Q4: sorted ===");
        System.out.println("Is sorted: " + sorted(list)); // true

        // Q5: insertNode — insert 6 into sorted list
        System.out.println("\n=== Q5: insertNode(6) ===");
        list = insertNode(6, list);
        LinkedListPrinter.printList(list); // 2 -> 5 -> 6 -> 7 -> 9 -> null

        // Q6: deleteNum — remove all 6s
        System.out.println("\n=== Q6: deleteNum(6) ===");
        list = deleteNum(6, list);
        LinkedListPrinter.printList(list); // 2 -> 5 -> 7 -> 9 -> null

        // Q7: frontToBack — move first node to end
        System.out.println("\n=== Q7: frontToBack ===");
        list = frontToBack(list);
        LinkedListPrinter.printList(list); // 5 -> 7 -> 9 -> 2 -> null

        // Q8: reverse
        System.out.println("\n=== Q8: reverse ===");
        list = reverse(list);
        LinkedListPrinter.printList(list); // 2 -> 9 -> 7 -> 5 -> null

        // Q9: getLongest — build a list with consecutive duplicates
        System.out.println("\n=== Q9: getLongest ===");
        Node streakList = new Node(2, new Node(1, new Node(1, new Node(1,
                new Node(1, new Node(1, new Node(8, new Node(3,
                        new Node(3, new Node(3, new Node(6, new Node(6))))))))))));
        LinkedListPrinter.printList(streakList);
        System.out.println("Longest streak: " + getLongest(streakList)); // 5

        // Q10: merge two sorted lists
        System.out.println("\n=== Q10: merge ===");
        Node a = new Node(2, new Node(2, new Node(3, new Node(5, new Node(6, new Node(8))))));
        Node b = new Node(1, new Node(3, new Node(4, new Node(5))));
        System.out.print("List A: "); LinkedListPrinter.printList(a);
        System.out.print("List B: "); LinkedListPrinter.printList(b);
        System.out.print("Merged: "); LinkedListPrinter.printList(merge(a, b)); // 1 -> 2 -> 2 -> 3 -> 3 -> 4 -> 5 -> 5 -> 6 -> 8 -> null
    }
}
