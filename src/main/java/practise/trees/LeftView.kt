package practise.trees

import java.lang.StringBuilder

fun main() {
    var root = IntBinaryTree(5, 6, 3, 8, 7, 2, 9, 4, 1)
    printLeftView(root.root)
    root = IntBinaryTree(5, 6, 3, 8, 7, 9, 4)
    printLeftView(root.root)
}

fun printLeftView(root: IntBinaryTree.TreeNode) {
    var temp: IntBinaryTree.TreeNode? = root
    val sb = StringBuilder()
    while (temp != null) {
        sb.append(temp.`val`).append(" ")
        temp = if (temp.left != null)
            temp.left
        else
            temp.right
    }
    println(sb)
}