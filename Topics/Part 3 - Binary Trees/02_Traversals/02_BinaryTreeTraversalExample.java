/*
 * ─────────────────────────────────────────────────────────────────────────────
 * Topic: Binary Tree Traversals — Pre-order · In-order · Post-order
 * ─────────────────────────────────────────────────────────────────────────────
 * A traversal visits every node in the tree exactly once.
 * The three classic recursive traversals differ only in WHEN the current node
 * is processed relative to its children:
 *
 *   Pre-order  (Root → Left → Right)
 *     • Process node FIRST, then recurse into children.
 *     • Use case: copying a tree, serializing structure (parent always before children).
 *
 *   In-order   (Left → Root → Right)
 *     • Recurse left, process node, recurse right.
 *     • Use case: visiting a BST in SORTED ascending order.
 *
 *   Post-order (Left → Right → Root)
 *     • Recurse into both children first, process node LAST.
 *     • Use case: deleting a tree bottom-up, evaluating expression trees.
 *
 * All three share the same base case: if the node is null, return immediately.
 * Time complexity:  O(n) — every node visited once
 * Space complexity: O(h) — recursion depth equals tree height h
 * ─────────────────────────────────────────────────────────────────────────────
 */
class BinaryTreeTraversalExample {

    record TreeNode(int data, TreeNode left, TreeNode right) { }

    // ── Pre-order: Root → Left → Right ───────────────────────────────────────
    // The root is printed BEFORE its subtrees, so parents always appear first.
    static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data() + " ");  // visit root
        preorder(root.left());                 // then left subtree
        preorder(root.right());                // then right subtree
    }

    // ── In-order: Left → Root → Right ────────────────────────────────────────
    // For a BST, this visits nodes in ascending sorted order because all left
    // values are smaller and all right values are larger than the current node.
    static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left());                  // descend to smallest values first
        System.out.print(root.data() + " ");   // visit root (in sorted position)
        inorder(root.right());                 // then larger values
    }

    // ── Post-order: Left → Right → Root ──────────────────────────────────────
    // The root is printed LAST — after all descendants have been processed.
    // Useful when a node can only be cleaned up after its children are gone.
    static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left());                // process left subtree first
        postorder(root.right());               // then right subtree
        System.out.print(root.data() + " ");   // visit root last
    }

    public static void main(String[] args) {
        /*
         * Tree used:
         *         4
         *        / \
         *       2   7
         *      / \    \
         *     1   3    9
         *
         * Expected output:
         *   Pre-order:   4  2  1  3  7  9   (root first)
         *   In-order:    1  2  3  4  7  9   (sorted — valid BST)
         *   Post-order:  1  3  2  9  7  4   (root last)
         */
        TreeNode tree = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(7,
                        null,
                        new TreeNode(9, null, null)));

        System.out.print("Preorder:  ");
        preorder(tree);
        System.out.println();  // 4 2 1 3 7 9

        System.out.print("Inorder:   ");
        inorder(tree);
        System.out.println("  (sorted for a BST)");  // 1 2 3 4 7 9

        System.out.print("Postorder: ");
        postorder(tree);
        System.out.println();  // 1 3 2 9 7 4
    }
}
