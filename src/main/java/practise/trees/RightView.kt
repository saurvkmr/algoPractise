package practise.trees

import java.lang.StringBuilder

fun main() {
    var root = IntBinaryTree(5, 6, 3, 8, 7, 2, 9, 4, 1)
    printRightView(root.root)
    root = IntBinaryTree(5, 6, 3, 8, 7, 2, 4, 1)
    printRightView(root.root)
}

fun printRightView(root: IntBinaryTree.TreeNode) {
    var temp: IntBinaryTree.TreeNode? = root
    val sb = StringBuilder()
    while (temp != null) {
        sb.append(temp.`val`).append(" ")
        temp = if (temp.right != null)
            temp.right
        else
            temp.left
    }
    println(sb)
}