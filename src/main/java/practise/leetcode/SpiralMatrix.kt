package practise.leetcode

/**
 * Give a number n, create a spiral square matrix
 */

fun main() {
    val n = 3
    spiralMatrix(n)
}

fun spiralMatrix(n: Int) {
    val arr = 0
    val len = n; val width = n
    var r = true // right
    var d = false // down
    var l = false // left
    var u = false // up
    var num = 0; var dec = 0; var i = 0; var j = 0

    while(num < n*n) {
        if (r && j <= (len - dec)) {
            if (j == (len - dec)) {
                r = false ; d = true ; l = false; u = false
            }

        }
    }
}