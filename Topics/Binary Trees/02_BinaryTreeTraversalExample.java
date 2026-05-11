class BinaryTreeTraversalExample {

    record TreeNode(int data, TreeNode left, TreeNode right) { }

    static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data() + " ");
        preorder(root.left());
        preorder(root.right());
    }

    static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left());
        System.out.print(root.data() + " ");
        inorder(root.right());
    }

    static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left());
        postorder(root.right());
        System.out.print(root.data() + " ");
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(7,
                        null,
                        new TreeNode(9, null, null)));

        System.out.print("Preorder:  ");
        preorder(tree);
        System.out.println();

        System.out.print("Inorder:   ");
        inorder(tree);
        System.out.println("  (sorted for a BST)");

        System.out.print("Postorder: ");
        postorder(tree);
        System.out.println();
    }
}
