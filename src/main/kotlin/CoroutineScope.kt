import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main (){
    firstCoroutine()
}

fun firstCoroutine(): Unit = runBlocking{
    launch {
        delay(100)
        println("Inside runBlockingScope")
    }
    coroutineScope{
        launch {
            delay(100)
            println("Inside runBlockingScope")
        }
        delay(100)
        println("Inside coroutineScope")
    }
    println("RunBlocking scope over")

}