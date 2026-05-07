public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int data) {
        this(data, null, null);
    }

    // Q6: Return true if the tree is complete as defined in the question.
    public static boolean complete(TreeNode node) {

    }

    public static void main(String[] args) {

    }
}
