import kotlinx.coroutines.*

fun main() {
    coroutineScope()
}

fun coroutineScope() = runBlocking {
    GlobalScope.launch {
        delay(1000)//nonblocking suspend function, Suspends the coroutines for 1 second without blocking the thread
        println("Current thread ${Thread.currentThread().name}")
        println("Task 1")
    }
    println("Task 2") //Prints immediately from the main thread
    println("Current thread ${Thread.currentThread().name}")
//    job.join()
    Thread.sleep(2000) //Blocks the main thread for 2 seconds
    delay(2000)
}

//The coroutine is suspended for 2 seconds,
// allowing the main thread to continue executing without waiting for the coroutine to finish.
//The thread can handle other tasks or coroutines while the first coroutine is suspended.

//DefaultDispatcher-worker-1: This indicates that the coroutine was
// executed on a thread managed by the Default dispatcher.
// The Default dispatcher uses a pool of shared background threads to perform work that is CPU-intensive