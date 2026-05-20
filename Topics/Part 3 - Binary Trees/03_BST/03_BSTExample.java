/*
 * ─────────────────────────────────────────────────────────────────────────────
 * Topic: Binary Search Tree (BST) — Insert · Search · Delete
 * ─────────────────────────────────────────────────────────────────────────────
 * A BST is a binary tree with one strict rule (the BST invariant):
 *   For every node N:
 *     • ALL values in N's LEFT  subtree are SMALLER than N.data
 *     • ALL values in N's RIGHT subtree are LARGER  than N.data
 *
 * This ordering lets us cut the search space in half at each step,
 * giving O(log n) performance on a balanced tree (O(n) worst-case if skewed).
 *
 * ── Delete has 3 cases ───────────────────────────────────────────────────────
 *   Case 1 — Leaf (0 children):  remove node directly.
 *   Case 2 — One child:          replace node with its only child.
 *   Case 3 — Two children:       find the IN-ORDER SUCCESSOR (the smallest node
 *             in the right subtree), copy its value here, then delete the successor.
 *             The successor always has 0 or 1 child, so it falls into Case 1 or 2.
 *
 * Time complexity (balanced tree):
 *   Search / Insert / Delete → O(log n)
 * Space complexity: O(h) recursion stack, where h = tree height
 * ─────────────────────────────────────────────────────────────────────────────
 */
class BSTExample {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // ── Insert ────────────────────────────────────────────────────────────────
    // Walk down the tree using the BST invariant to find the correct gap,
    // then attach a new node there. Returns the (possibly unchanged) root.
    static Node insert(Node root, int key) {
        if (root == null) return new Node(key);          // found the correct empty slot
        if (key < root.data)      root.left  = insert(root.left,  key);  // go left
        else if (key > root.data) root.right = insert(root.right, key);  // go right
        // equal keys are ignored (no duplicates)
        return root;
    }

    // ── Search ────────────────────────────────────────────────────────────────
    // At each node, compare key to node.data and eliminate one half of the tree.
    // Returns the matching node, or null if not found.
    static Node search(Node root, int key) {
        if (root == null || root.data == key) return root;
        if (key < root.data) return search(root.left,  key);  // key must be in left subtree
        else                 return search(root.right, key);  // key must be in right subtree
    }

    // ── findMin ───────────────────────────────────────────────────────────────
    // The minimum value in a BST is always at the leftmost node.
    // Used to find the in-order successor during deletion (Case 3).
    static Node findMin(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    // ── Delete ────────────────────────────────────────────────────────────────
    // First navigate to the node, then handle one of the 3 cases.
    static Node delete(Node root, int key) {
        if (root == null) return null;  // key not found — nothing to delete

        if (key < root.data) {
            root.left  = delete(root.left,  key);  // target is in the left subtree
        } else if (key > root.data) {
            root.right = delete(root.right, key);  // target is in the right subtree
        } else {
            // ── We found the node to delete ───────────────────────────────
            // Case 1: leaf — simply remove it
            if (root.left == null && root.right == null) return null;
            // Case 2: one child — bypass this node and return the surviving child
            if (root.left  == null) return root.right;
            if (root.right == null) return root.left;
            // Case 3: two children
            //   Find in-order successor (smallest value in the right subtree).
            //   Copy successor's value into this node, then delete the successor below.
            Node successor = findMin(root.right);
            root.data  = successor.data;
            root.right = delete(root.right, successor.data);
        }
        return root;
    }

    // ── In-order print ────────────────────────────────────────────────────────
    // Left → Root → Right visits a BST in ascending sorted order.
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Build BST: 5 is root, smaller values go left, larger go right
        //
        //         5
        //        / \
        //       3   7
        //      / \ / \
        //     1  4 6  9
        Node root = null;
        for (int v : new int[]{5, 3, 7, 1, 4, 6, 9}) root = insert(root, v);

        System.out.print("Inorder (sorted):   ");
        inorder(root);  // 1 3 4 5 6 7 9
        System.out.println();

        // Delete 5 → Case 3 (two children): replaced by in-order successor 6
        root = delete(root, 5);
        System.out.print("After deleting 5:   ");
        inorder(root);  // 1 3 4 6 7 9
        System.out.println();

        // Delete 1 → Case 1 (leaf): removed directly
        root = delete(root, 1);
        System.out.print("After deleting 1:   ");
        inorder(root);  // 3 4 6 7 9
        System.out.println();

        System.out.println("Search 4: " + (search(root, 4) != null ? "found" : "not found")); // found
        System.out.println("Search 5: " + (search(root, 5) != null ? "found" : "not found")); // not found
    }
}
