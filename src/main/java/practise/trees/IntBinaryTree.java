package practise.trees;

import java.util.Arrays;

public class IntBinaryTree {
    TreeNode root = new TreeNode();

    public IntBinaryTree() {}

    public IntBinaryTree(int... val) {addNodeToBST(val);}

    public void addNodeToBST(int... val) {
        Arrays.stream(val).forEach(value -> root.addRecursiveToBST(value, root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        private void addRecursiveToBST(int val, TreeNode root) {
            if (root == null || root.val == 0) {
                root.val = val;
                return;
            }
            TreeNode temp = root;
            while (temp != null) {
                if (val < temp.val) {
                    if (temp.left == null) {
                        temp.left = new TreeNode(val);
                        break;
                    }
                    temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = new TreeNode(val);
                        break;
                    }
                    temp = temp.right;
                }
            }
        }
    }
}
