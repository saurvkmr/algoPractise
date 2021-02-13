package practise.arrays

fun main() {
    println(buySellOneTime(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(buySellOneTime(intArrayOf(7, 6, 4, 3, 1)))
    println(buySellOneTime(intArrayOf(4, 7, 2, 1)))

    println(buySellManyTimes(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(buySellManyTimes(intArrayOf(1, 2, 3, 4, 5)))
    println(buySellManyTimes(intArrayOf(4, 7, 2, 1)))
    println(buySellManyTimes(intArrayOf(7, 6, 4, 3, 1)))
    println(buySellManyTimes(intArrayOf(1, 2)))
}

private fun buySellOneTime(prices: IntArray): Int {
    var minprice = Int.MAX_VALUE
    var maxprofit = 0
    for (i in prices.indices) {
        if (prices[i] < minprice) minprice = prices[i]
        else if (prices[i] - minprice > maxprofit)
            maxprofit = prices[i] - minprice
    }
    return maxprofit
}

private fun buySellManyTimes(prices: IntArray): Int {
    if (prices.isEmpty()) return 0
    var profit = 0
    var curPrice = prices[0]
    prices.forEach {
        if (it < curPrice) {
            //buy
            curPrice = it
        } else if (it > curPrice) {
            //sell
            profit += it - curPrice
            curPrice = it
        }
    }
    return profit
}