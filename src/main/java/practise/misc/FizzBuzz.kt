package practise.misc

fun main() {
    fizzBuzz()
}

private fun fizzBuzz() {
    for (i in 0..100) {
        when {
            i % 15 == 0 -> println("FizzBuzz")
            i % 5 == 0 -> println("Fizz")
            i % 3 == 0 -> println("Buzz")
            else -> println(i)
        }
    }
}