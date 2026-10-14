package lecture.solution

/**
 * # Exceptions
 * Kotlin inherited exceptions from Java, but only has unchecked exceptions.
 * My advice: Try to avoid throwing any exceptions on your own.
 *
 * ## Tasks:
 * - What are alternatives to using exceptions?
 * - Can the code crash? Fix any crashes.
 *
 * ## Resources:
 * - [Exceptions](https://kotlinlang.org/docs/exceptions.html)
 * - [(Infix functions)](https://kotlinlang.org/docs/functions.html#infix-notation)
 */
fun main() {
    fun checkName(name: String) {
        require(name.isNotBlank()) { "Please enter a name." } // IllegalArgumentException
        val names = name.split(' ').filter { it.isNotBlank() }
        // Deliberately use check here to demonstrate IllegalStateException as well.
        check(names.size > 1) { "You should have more than one name" }

        when (names.size) {
            2 -> println("Has first and last name")
            3 -> println("Has first, middle and last name")
            else -> throw IllegalStateException("Too many names!") // or: error
        }
    }

    try {
        while (true) {
            println("What's your full name?")
            val name = readlnOrNull() ?: break
            try {
                checkName(name)
                break
            } catch (e: IllegalArgumentException) {
                // Recover from invalid input by asking again.
                println("Invalid argument: ${e.message}")
            } catch (e: IllegalStateException) {
                println("Cannot process this name: ${e.message}")
            }
        }
    } finally {
        println("BYE!")
    }
}
