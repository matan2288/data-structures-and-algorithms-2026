class BinaryTreeNodeExample {

    record TreeNode(int data, TreeNode left, TreeNode right) { }

    /** Number of nodes in the subtree rooted at root */
    static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left()) + countNodes(root.right());
    }

    /** Height in edges: empty tree = -1, single node = 0 */
    static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left()), height(root.right()));
    }

    static int sumValues(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.data() + sumValues(root.left()) + sumValues(root.right());
    }

    public static void main(String[] args) {
        /*
                4
               / \
              2   7
             / \   \
            1   3   9
        */
        TreeNode tree = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(7,
                        null,
                        new TreeNode(9, null, null)));

        System.out.println("countNodes = " + countNodes(tree)); // 6
        System.out.println("height     = " + height(tree)); // 2 edges
        System.out.println("sumValues  = " + sumValues(tree)); // 26
    }
}
