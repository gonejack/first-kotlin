package main

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

//import app.App
//import app.Conf
//
//fun main(args: Array<String>) {
//    Conf.init()
//    App.init().start(args)
//}

fun main() {
    runBlocking {
        launch {
            println("main ${Thread.currentThread().name}")
        }

        println("main 1")
        launch(Dispatchers.Unconfined) {
            println("Unconfined: ${Thread.currentThread().name}")
        }

        println("main 2")
        launch(Dispatchers.Default) {
            println("default: ${Thread.currentThread().name}")
        }

        println("main 3")
        launch(newSingleThreadContext("single thread")) {
            println("new single thread: ${Thread.currentThread().name}")
        }
    }

    println("done")
}
