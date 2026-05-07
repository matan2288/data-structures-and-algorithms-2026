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

    // Q8: Count how many nodes are at level pos (root level is 0).
    public static int countDepth(TreeNode node, int pos) {

    }

    public static void main(String[] args) {

    }
}
