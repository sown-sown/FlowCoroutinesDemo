import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(){
//    sequentialFlow()
 concurrentFlow()
}
//simultaneously
fun concurrentFlow() : Unit = runBlocking {
    val time = measureTimeMillis {
        val one = async { oneTask() }
        val two = async{ twoTask() }

        val result = one.await() + two.await()
        println("the result is $result")
    }
    println("$time")
}
private suspend fun oneTask() : Int {
    delay(1000)
    return 444
}

private suspend fun twoTask() : Int {
    delay(2000)
    return 55
}

fun sequentialFlow() : Unit = runBlocking {
    val time = measureTimeMillis {
        val one = oneTask1()
        val two = twoTask2()

        val result = one + two
        println("the result is $result")
    }
    println("$time")
}
private suspend fun oneTask1() : Int {
    delay(1000)
    return 444
}

private suspend fun twoTask2() : Int {
    delay(2000)
    return 55
}