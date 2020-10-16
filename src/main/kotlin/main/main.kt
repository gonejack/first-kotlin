package main

//import app.App
//import app.Conf
//
//fun main(args: Array<String>) {
//    Conf.init()
//    App.init().start(args)
//}

import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        // launch new coroutine in background and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }

    val first = GlobalScope.launch {
        delay(100L)

        delay(100L)

        println("abc")
    }

    println("Hello,") // main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}