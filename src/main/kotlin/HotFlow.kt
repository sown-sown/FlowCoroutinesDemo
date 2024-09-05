import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val stateFlow = MutableStateFlow(0)

    launch {
        repeat(3) {
            delay(1000)
            stateFlow.value = stateFlow.value + 1
            println("StateFlow updated: ${stateFlow.value}")
        }
    }

    delay(2000)

    println("First collector:")
    stateFlow.collect { value ->
        println("Collected: $value")
    }
}
