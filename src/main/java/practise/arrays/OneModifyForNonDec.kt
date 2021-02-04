package practise.arrays

private fun oneModifyToMakeArrNonDec(a:IntArray): Boolean {
    var count = 0
    for (i in a.indices - 2) {
        if (a[i] > a[i+1]) {
            if (count == 0) count++
            else return false
        }
    }
    return true
}

fun main() {
    print(oneModifyToMakeArrNonDec(intArrayOf(4,2,3)))
}
