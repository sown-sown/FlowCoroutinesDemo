import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main(){
    sharedFlow()
}

fun sharedFlow() = runBlocking {
    val sharedFlow = MutableSharedFlow<Int>() // Create a SharedFlow

    // Launch a coroutine to emit values to the shared flow
    launch {
        for (i in 1..5) {
            delay(500) // Simulating some work
            println("Emitting $i")
            sharedFlow.emit(i) // Emit value to the shared flow
        }
    }

    // Collect from the shared flow in two different collectors
    launch {
        sharedFlow.collect { value ->
            println("Collector 1 received: $value")
        }
    }

    launch {
        sharedFlow.collect { value ->
            println("Collector 2 received: $value")
        }
    }
}
