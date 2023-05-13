public interface MinHeap<TreeNode extends Comparable<TreeNode>> {

    void insert(TreeNode k);

    TreeNode findMin();

    TreeNode deleteMin();

    boolean isEmpty();

    int size();

    void clear();
}