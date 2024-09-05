import kotlinx.coroutines.*

fun main(){
    dispatcherExample()
//    singleThreadContext()
//    debuggingExample()
}

fun singleThreadContext() :Unit = runBlocking {
    newSingleThreadContext("Custom Thread").use{ctx->
        val job = launch(ctx) {
            log("MyCustom Thread")
        }
        job.join()
    }
}

fun dispatcherExample(): Job = runBlocking {
    launch(Dispatchers.Default) {
        //uses pool of thread
        log("Default")
    }

    launch(newSingleThreadContext("MyCustomThread")) {
        //creates new thread
        log("MyCustom Thread")
    }

    launch(Dispatchers.Unconfined){
        //not confined to any specific thread
        log("Unconfined")
    }
    launch {
        //uses the default one
        log("runblocking")
    }
}

private fun log(message:String) {
    println("$message I'm using thread ${Thread.currentThread().name}")
}

fun debuggingExample() = runBlocking {
    val num1 = async{
        log("Fetching first number")
        4
    }
    val num2 = async {
        log("Fetching second number")
        5
    }
    val result = num1.await() + num2.await()

    log("Result is $result")
}