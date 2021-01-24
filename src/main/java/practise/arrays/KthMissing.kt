package practise.arrays

fun findKMissingElement(arr: IntArray, k: Int):Int {
    var i = 0; var idx = 0;var missingElement = 0; var j = 1
    while (true) {
        if (idx < arr.size && j == arr[idx])
            idx++
        else {
            i++
            missingElement = j
        }
        if (i == k)
            break
        j++
    }

    return missingElement
}

fun main() {
    print(findKMissingElement(intArrayOf(1,2,3,4), 2))
}