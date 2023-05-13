import java.io.Serializable;

public class TreeNode implements Comparable<TreeNode>, Serializable {
    private int frequency;
    private int c;
    private TreeNode left;
    private TreeNode right;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int frequency, int c, TreeNode left, TreeNode right) {
        this.frequency = frequency;
        this.c = c;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(TreeNode treeNode) {
        if (this.frequency > treeNode.frequency) {
            return 1;
        } else if (this.frequency == treeNode.frequency) {
            return 0;
        }

        return -1;
    }


}