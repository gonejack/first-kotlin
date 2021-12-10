package main

import kotlinx.coroutines.*

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
        launch {
            println(this@runBlocking)
        }
        launch(newSingleThreadContext("single thread")) {
            println("new single thread: ${Thread.currentThread().name}")
        }
    }

    run {
        println("this is run")
    }

    runBlocking {
        val job = launch {
            abc()
        }

        job.join()
    }

    println("done")
}

suspend fun abc() {
    var qq = ded()
}

suspend fun ded() {
    val abc = 200
    val def = 300
    println(abc.plus(def))
}
