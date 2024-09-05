import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main(){
 cancelCoroutine()
 cooperativeCancellation()
}

fun cancelCoroutine() : Unit = runBlocking{
    val job: Job = launch {
        repeat(20){
            delay(500)
            println("Fetch data $it time")
        }
    }

    delay(5000)
    println("No more waiting...")
    job.cancel()
    job.join()
    //job.cancelAndJoin()
    println("Main ends here")
}

fun cooperativeCancellation() : Unit = runBlocking{
    val job: Job = launch(Dispatchers.Default){
        repeat(20){
            Thread.sleep(500)
            println("Fetch data $it time")
        }
    }

    delay(1600)
    println("No more waiting...")
    job.cancel()
    job.join()
    //job.cancelAndJoin()
    println("Main ends here")
}

//Dispatchers.Default is used to launch the coroutine on a shared background pool of threads.
//which is efficient for parallel execution.