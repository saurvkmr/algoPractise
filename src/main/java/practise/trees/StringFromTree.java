package practise.trees;
// [1,2,3,4] -> "1(2(4))(3)"
// [1,2,3,null,4] -> "1(2()(4))(3)"
public class StringFromTree {

    public static void main(String[] args) {
        IntBinaryTree tree = new IntBinaryTree(5, 6, 3, 8, 7, 2, 9, 4, 1);
        StringBuilder sb = new StringBuilder();
        contructString(tree.root, sb);
        System.out.println(sb.toString());
    }

    private static void contructString(IntBinaryTree.TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val);

            if (node.left == null && node.right != null)
                sb.append("()");

            if (node.left != null) {
                sb.append("(");
                contructString(node.left, sb);
                sb.append(")");
            }

            if (node.right != null) {
                sb.append("(");
                contructString(node.right, sb);
                sb.append(")");
            }
        }
    }
}
