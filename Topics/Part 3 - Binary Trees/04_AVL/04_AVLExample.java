/*
 * ─────────────────────────────────────────────────────────────────────────────
 * Topic: AVL Tree — Self-Balancing BST with Rotations
 * ─────────────────────────────────────────────────────────────────────────────
 * Problem with plain BSTs: inserting sorted data (e.g. 1, 2, 3, 4, 5) creates
 * a right-skewed chain, making search O(n) instead of O(log n).
 *
 * An AVL tree fixes this by enforcing a BALANCE FACTOR invariant after every
 * insert or delete:
 *
 *   balanceFactor(node) = height(leftChild) - height(rightChild)
 *
 * The invariant: balanceFactor must always be -1, 0, or 1 for every node.
 * If it's ever 2 or -2, the tree performs a ROTATION to restore balance,
 * keeping the height at O(log n) and all operations at O(log n).
 *
 * ── 4 Rotation Cases ─────────────────────────────────────────────────────────
 *   Left-Left  (bf > 1, left child bf >= 0)  → rotateRight on current node
 *   Left-Right (bf > 1, left child bf <  0)  → rotateLeft on left child,
 *                                               then rotateRight on current node
 *   Right-Right(bf < -1, right child bf <= 0)→ rotateLeft on current node
 *   Right-Left (bf < -1, right child bf >  0)→ rotateRight on right child,
 *                                               then rotateLeft on current node
 *
 * Time complexity: O(log n) for insert, search, and delete
 * Space complexity: O(log n) recursion stack (guaranteed by balance)
 * ─────────────────────────────────────────────────────────────────────────────
 */
class AVLExample {

    // Each node stores its height so balanceFactor can be computed in O(1).
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data   = data;
            this.height = 1;  // a new leaf has height 1
        }
    }

    // ── Helper utilities ──────────────────────────────────────────────────────

    // Null-safe height getter — null nodes have height 0.
    static int height(Node n) {
        return n == null ? 0 : n.height;
    }

    // Balance factor = left height minus right height.
    // > 1  → left-heavy (needs right rotation or double rotation)
    // < -1 → right-heavy (needs left rotation or double rotation)
    static int balanceFactor(Node n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    // Recalculate height after children may have changed.
    static void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    // ── Rotations ─────────────────────────────────────────────────────────────

    /**
     * Right Rotation — fixes a Left-Left (LL) imbalance.
     *
     *   Before:          After:
     *       y                x
     *      / \              / \
     *     x   C    →       A   y
     *    / \                  / \
     *   A   t2               t2  C
     *
     * x becomes the new subtree root; y drops to the right.
     */
    static Node rotateRight(Node y) {
        Node x  = y.left;   // x will become the new root of this subtree
        Node t2 = x.right;  // t2 moves from x's right to y's left
        x.right = y;
        y.left  = t2;
        updateHeight(y);    // update y first (it's now lower)
        updateHeight(x);    // then x (it's now higher)
        return x;
    }

    /**
     * Left Rotation — fixes a Right-Right (RR) imbalance.
     *
     *   Before:          After:
     *       x                y
     *      / \              / \
     *     A   y    →       x   C
     *        / \          / \
     *       t2  C        A   t2
     *
     * y becomes the new subtree root; x drops to the left.
     */
    static Node rotateLeft(Node x) {
        Node y  = x.right;  // y will become the new root of this subtree
        Node t2 = y.left;   // t2 moves from y's left to x's right
        y.left  = x;
        x.right = t2;
        updateHeight(x);    // update x first (it's now lower)
        updateHeight(y);    // then y (it's now higher)
        return y;
    }

    // ── Balance ───────────────────────────────────────────────────────────────
    // Called on the way back up after every insert.
    // Checks the 4 imbalance cases and applies the right rotation(s).
    static Node balance(Node node) {
        updateHeight(node);
        int bf = balanceFactor(node);

        // Left-Left: single right rotation restores balance
        if (bf > 1 && balanceFactor(node.left) >= 0)
            return rotateRight(node);

        // Left-Right: left-rotate the left child first to make it a LL case
        if (bf > 1 && balanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right-Right: single left rotation restores balance
        if (bf < -1 && balanceFactor(node.right) <= 0)
            return rotateLeft(node);

        // Right-Left: right-rotate the right child first to make it a RR case
        if (bf < -1 && balanceFactor(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;  // already balanced — no rotation needed
    }

    // ── Insert ────────────────────────────────────────────────────────────────
    // Same traversal as plain BST insert, but calls balance() on the way back up.
    static Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data)      root.left  = insert(root.left,  key);
        else if (key > root.data) root.right = insert(root.right, key);
        else return root;  // duplicates are ignored
        return balance(root);  // rebalance this node if the subtree grew
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.printf("%d(bf=%d) ", root.data, balanceFactor(root));
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;

        // Inserting 10→50 in ascending order would skew a plain BST into a chain.
        // The AVL tree triggers rotations automatically to stay balanced.
        for (int v : new int[]{10, 20, 30, 40, 50, 25}) root = insert(root, v);

        // In-order prints nodes in sorted order; balance factors should all be -1, 0, or 1
        System.out.print("Inorder (with balance factors): ");
        inorder(root);
        System.out.println();

        System.out.println("Root: " + root.data + "  height: " + root.height);
        System.out.println("Root balance factor: " + balanceFactor(root) + "  (must be -1, 0, or 1)");
    }
}
