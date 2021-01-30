package practise.trees

import java.util.*


fun main() {
    val root: IntBinaryTree.TreeNode = IntBinaryTree(10, 7, 15, 4, 8, 9, 13, 17, 2, 6, 14, 16, 20, 1, 3, 5).root
    print(minimumDepth(root))
}

fun minimumDepth(root: IntBinaryTree.TreeNode): Int {
    val q = ArrayDeque<IntBinaryTree.TreeNode>()
    q.add(root)
    var tempNode = IntBinaryTree.TreeNode()
    var minDepth = 1
    while(q != null) {
        var levelLen = q.size
        while(levelLen != 0) {
            tempNode = q.pop()
            if (tempNode.left == null && tempNode.right == null) {
                return minDepth
            }
            if (tempNode.left != null) {
                q.add(tempNode.left)
            }
            if (tempNode.right != null) {
                q.add(tempNode.right)
            }
            levelLen--
        }
        minDepth++
    }
    return minDepth
}