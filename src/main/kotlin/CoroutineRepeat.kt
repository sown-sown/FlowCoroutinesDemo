import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
    usingCoroutine()
//    usingThread()
}

fun usingCoroutine(): Unit = runBlocking {
    repeat(10000) {
        launch {
            delay(5000)
            println("Lightweight coroutine $it")
        }
        launch {
            delay(200)
            println("Hello")
        }
    }
}

fun usingThread(): Unit = runBlocking {
    try {
        repeat(1000000) { // Increased the number significantly
            thread {
                val largeArray = ByteArray(10 * 1024 * 1024) // Allocate 10MB per thread
                Thread.sleep(1000)
                println("Heavyweight thread $it")
            }
        }
    } catch (e: OutOfMemoryError) {
        println("Out of memory error occurred: ${e.message}")
    }
}