/*
 * ─────────────────────────────────────────────────────────────────────────────
 * Topic: Binary Tree — Structure & Basic Recursive Operations
 * ─────────────────────────────────────────────────────────────────────────────
 * A binary tree is a hierarchical data structure where each node holds a value
 * and has at most TWO children: a left child and a right child (either can be null).
 *
 * Key terminology:
 *   Root   — the single top-most node (no parent)
 *   Leaf   — a node with no children (left == null && right == null)
 *   Height — the number of EDGES on the longest path from root to any leaf
 *            (empty tree = -1, single node = 0)
 *
 * All three methods below follow the same recursive pattern:
 *   1. Base case  → if the node is null, return the identity value (0 or -1)
 *   2. Recursive  → solve for left subtree, solve for right subtree, combine
 *
 * Time complexity: O(n) — every node is visited exactly once
 * Space complexity: O(h) — call-stack depth equals the tree height h
 * ─────────────────────────────────────────────────────────────────────────────
 */
class BinaryTreeNodeExample {

    // A node stores its value plus references to left and right children.
    // Using a Java record keeps the definition compact (immutable, auto-generates getters).
    record TreeNode(int data, TreeNode left, TreeNode right) { }

    /**
     * Counts the total number of nodes in the subtree rooted at 'root'.
     * Formula: count(node) = 1 + count(left) + count(right)
     */
    static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;  // empty subtree contributes 0 nodes
        }
        return 1 + countNodes(root.left()) + countNodes(root.right());
    }

    /**
     * Returns the height in edges: empty tree = -1, single node = 0.
     * Formula: height(node) = 1 + max(height(left), height(right))
     * The +1 counts the edge from this node down to its taller child.
     */
    static int height(TreeNode root) {
        if (root == null) {
            return -1;  // convention: null contributes -1 so a leaf gets height 0
        }
        return 1 + Math.max(height(root.left()), height(root.right()));
    }

    /**
     * Sums all node values in the subtree.
     * Formula: sum(node) = node.data + sum(left) + sum(right)
     */
    static int sumValues(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.data() + sumValues(root.left()) + sumValues(root.right());
    }

    public static void main(String[] args) {
        /*
         * Building this tree manually:
         *
         *         4          ← root (depth 0)
         *        / \
         *       2   7        ← depth 1
         *      / \    \
         *     1   3    9     ← depth 2, leaves
         *
         * Expected results:
         *   countNodes = 6
         *   height     = 2  (root → 2 → 1, two edges)
         *   sumValues  = 1+2+3+4+7+9 = 26
         */
        TreeNode tree = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(7,
                        null,
                        new TreeNode(9, null, null)));

        System.out.println("countNodes = " + countNodes(tree)); // 6
        System.out.println("height     = " + height(tree));     // 2 edges
        System.out.println("sumValues  = " + sumValues(tree));  // 26
    }
}
