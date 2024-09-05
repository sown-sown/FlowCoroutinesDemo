import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    // Create a MutableStateFlow with an initial value
    val stateFlow = MutableStateFlow(0)

    // Launch a coroutine to emit values to the state flow
    launch {
        repeat(5) { i ->
            delay(500) // Simulating some work
            stateFlow.value = i // Update the state
            println("State updated to $i")
        }
    }

    launch{
    repeat(3){
        j ->
        delay(300)
        stateFlow.value = j
        println("State updated to $j")
    }
}
    // Collect from the state flow
    val job = launch {
        stateFlow.collect { value ->
            println("Collector received: $value")
        }
    }
//    val job1 = launch {
//        stateFlow.collect {
//            value -> println("Collector received 1: $value")
//        }
//    }

    delay(3000) // Delay for demonstration purposes
    job.cancel() // Cancel the collection when done
//    job1.cancel()
}
