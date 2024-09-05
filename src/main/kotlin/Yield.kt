import kotlinx.coroutines.*

fun main(){
//    cancelCoroutine1()
    cooperativeCancellation1()
}

fun cancelCoroutine1() : Unit = runBlocking{
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

fun cooperativeCancellation1() : Unit = runBlocking{
    val job: Job = launch(Dispatchers.Default){
        repeat(20){
            Thread.sleep(500)
            yield()
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