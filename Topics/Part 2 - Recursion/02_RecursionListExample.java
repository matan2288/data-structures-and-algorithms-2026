class RecursionListExample {

    // Same idea as Part 1, but kept local so this file is self-contained.
    record ListNode(int data, ListNode next) { }

    static int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + length(head.next());
    }

    static int sum(ListNode head) {
        if (head == null) {
            return 0;
        }
        return head.data() + sum(head.next());
    }

    static boolean contains(ListNode head, int value) {
        if (head == null) {
            return false;
        }
        if (head.data() == value) {
            return true;
        }
        return contains(head.next(), value);
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(2, new ListNode(5, new ListNode(7, new ListNode(9, null))));

        System.out.println("List: 2 -> 5 -> 7 -> 9 -> null");
        System.out.println("length (recursive) = " + length(list)); // 4
        System.out.println("sum (recursive)    = " + sum(list)); // 23
        System.out.println("contains 7?        = " + contains(list, 7)); // true
        System.out.println("contains 3?        = " + contains(list, 3)); // false
    }
}
