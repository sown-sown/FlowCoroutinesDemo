import kotlinx.coroutines.*

fun main(){
//    cancelCoroutine2()
//    cooperativeCancellation2()
//    closingResources()
      closingResourcesWithNonCancellableBlock()
}

fun cancelCoroutine2() : Unit = runBlocking{
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

fun cooperativeCancellation2() : Unit = runBlocking{
    val job: Job = launch(Dispatchers.Default){
        repeat(20){
            if(!isActive) throw CancellationException()
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

fun closingResources() : Unit = runBlocking{
    val job: Job = launch(Dispatchers.Default){
        try {
            repeat(20) {
                if (!isActive) throw CancellationException()
                Thread.sleep(500)
                println("Fetch data $it time")
            }
        }finally {
            delay(1000)
            println("Closing resources")
        }
    }

    delay(1600)
    println("No more waiting...")
    job.cancel()
    job.join()
    //job.cancelAndJoin()
    println("Main ends here")
}

fun closingResourcesWithNonCancellableBlock() : Unit = runBlocking{
    val job: Job = launch(Dispatchers.Default){
        try {
            repeat(20) {
                if (!isActive) throw CancellationException()
                Thread.sleep(500)
                println("Fetch data $it time")
            }
        }finally {
           withContext(NonCancellable){
               delay(1000)
               println("Closing resources..")
           }
        }
    }

    delay(1600)
    println("No more waiting...")
    job.cancel()
    job.join()
    //job.cancelAndJoin()
    println("Main ends here")
}