package practise.trees

fun validateIntBinaryTree() {
    val tree = IntBinaryTree()
    tree.addNodeToBST(5, 6, 3, 8, 7, 2, 9, 4, 1)
    inOrderTraversal(tree.root)
    println()
    preOrderTraversal(tree.root)
}

fun inOrderTraversal(root: IntBinaryTree.TreeNode) {
    if (root.left != null) println(inOrderTraversal(root.left))
    if (root == null) return
    print("${root.`val`} ")
    if (root.right != null) println(inOrderTraversal(root.right))

}

fun preOrderTraversal(root: IntBinaryTree.TreeNode) {
    if (root == null) return
    print("${root.`val`} ")
    if (root.left != null) println(preOrderTraversal(root.left))
    if (root.right != null) println(preOrderTraversal(root.right))
}

fun main() {
    validateIntBinaryTree()
}