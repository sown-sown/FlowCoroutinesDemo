import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val numbersFlow = flow {
        for (i in 1..5) {
            delay(500) // Simulating some work
            emit(i)    // Emit the next value
        }
    }

    numbersFlow
        .map { it * it }  // Transform the emitted value
        .collect { value -> println(value) }  // Collect and print the values
}
