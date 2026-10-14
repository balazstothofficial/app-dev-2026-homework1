package lecture

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
    // Exceptions
    fun checkName(name: String) {
        require(name.isNotBlank()) { "Please enter a name." }

        val names = name.split(' ').filter { it.isNotBlank() }

        check(names.size > 1) { "You should have more than one name" }

        when (names.size) {
            2 -> println("Has first and last name")
            3 -> println("Has first, middle and last name")
            else -> throw IllegalStateException("Too many names!") // or: error
        }
    }

    try {
        println("What's your full name?")
        val name = readln()
        checkName(name)

        /*
            Example on how to *not* handle exceptions in your code!
            Always try to resolve the issues.
            Here a good way would be to ask for a name again.
        */
    } catch (e: IllegalStateException) {
        println("Invalid name! Exception: \"$e\"")
    } finally {
        println("BYE!")
    }
}
