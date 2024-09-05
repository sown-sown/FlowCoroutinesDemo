import kotlinx.coroutines.*

fun main(){
    coroutineScope2()
}
fun coroutineScope2():Unit = runBlocking {
        launch {
            delay(1000)//nonblocking suspend function, Suspends the coroutines for 1 second without blocking the thread
            println("Task 1")
        }
    println("Task 2")
    }
//Readability and Maintainability.. Code following structured concurrency principles is easier to read, understand, and maintain.