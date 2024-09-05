import kotlin.concurrent.thread

fun main(){
    withThread()
}

fun withThread(){
    thread{
        Thread.sleep(1000) //Blocks this new thread for 1 second
        println("Current thread ${Thread.currentThread().name}")
        println("Task 1") //Prints after the new thread wakes up
    }

//    thread{
//        Thread.sleep(1000) //Blocks this new thread for 1 second
//        println("Current thread ${Thread.currentThread().name}")
//        println("Task 3") //Prints after the new thread wakes up
//    }
    println("Task 2") //Prints immediately from the main thread
    println("Current thread ${Thread.currentThread().name}")
    Thread.sleep(2000) //Blocks the main thread for 2 seconds
}
//The main thread and the new thread are both blocked for 2 seconds,
// but the new thread starts after the main thread, leading to sequential blocking.
//The coroutine is suspended for 2 seconds,
// allowing the main thread to continue executing without waiting for the coroutine to finish.