package practise.misc

private fun fizzWord(n : Int): String {

    val sb = StringBuilder()
    (1..n).forEach { i ->
        val divBy3 = i % 3 == 0
        val divBy5 = i % 5 == 0
        when {
            divBy3 && divBy5 -> sb.append("FizzBuzz").append("\n")
            divBy5 -> sb.append("Buzz").append("\n")
            divBy3 -> sb.append("Fizz").append("\n")
            else -> sb.append(i).append("\n")
        }
    }
    return sb.toString()
}

fun main() {
    println(fizzWord(10))
}