package practise.trees

fun topView(root : IntBinaryTree.TreeNode) {
    if (root == null)
        return
    var temp: IntBinaryTree.TreeNode? = root
    val topViewList = ArrayList<Int>()
    while(temp != null) {
        topViewList.add(temp.`val`)
        temp = temp.left
    }
    temp = root.right
    while(temp != null) {
        topViewList.add(temp.`val`)
        temp = temp.right
    }
    topViewList.forEach { println(it) }
}

fun main() {
    val root = IntBinaryTree(5, 6, 3, 8, 7, 2, 9, 4, 1)
    topView(root.root)
}