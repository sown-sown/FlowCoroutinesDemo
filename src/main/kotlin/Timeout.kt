import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main(){
    timeOut()
  timeOutOrNull()
}

fun timeOut() = runBlocking {
    withTimeout(1000){
        repeat(20){
            delay(500)
            println("Fetch data $it times")
        }
    }
}

fun timeOutOrNull() = runBlocking {
    val result = withTimeoutOrNull(1000){
        repeat(20){
            delay(500)
            println("Fetch data $it times")
        }
    }
    println("The result is $result")
}

//cancellation is considered a normal operation in coroutines
//TimeoutCancellationException is often shown or logged to provide more specific information