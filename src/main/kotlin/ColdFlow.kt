import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val coldFlow = flow {
        println("Flow started")
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }

    println("First collector:")
    coldFlow.collect { value ->
        println("Collected: $value")
    }

    println("Second collector:")
    coldFlow.collect { value ->
        println("Collected: $value")
    }
}
