package practise.misc

fun main() = print(fibo(10))

private fun fibo(n: Int):Int {
    return if (n == 0 || n == 1)
        1
    else
        fibo(n-1) + fibo(n-2)
}