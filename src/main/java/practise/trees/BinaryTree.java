package practise.trees;

public class BinaryTree<T> {
    TreeNode<T> head;

    public static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T t) {
            this.data = t;
        }

        TreeNode() {
        }

        TreeNode(T val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    }
}
