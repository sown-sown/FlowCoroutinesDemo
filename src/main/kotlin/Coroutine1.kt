import kotlinx.coroutines.*

fun main(){
    coroutineScope1()
}
fun coroutineScope1(){
   val job: Job = GlobalScope.launch {
        delay(1000)//nonblocking suspend function, Suspends the coroutines for 1 second without blocking the thread
        println("Current thread ${Thread.currentThread().name}")
        println("Task 1")
    }
   runBlocking {
       println("Task 2") //Prints immediately from the main thread
       println("Current thread ${Thread.currentThread().name}")
       job.join()
   }
}