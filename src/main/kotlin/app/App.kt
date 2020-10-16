package app

import modules.woker.Twitter
import modules.woker.WorkerInterface

class App {
    companion object {
        private val workers: MutableList<WorkerInterface> = mutableListOf()

        fun init(): Companion {
            workers.add(Twitter())

            return this
        }

        fun start(args: Array<String>) {
            Runtime.getRuntime().addShutdownHook(Thread { this.stop() })

            workers.forEach { it.start() }

            do {
                Thread.sleep(1000)
            } while (true)
        }

        fun stop() {
            workers.forEach { it.stop() }

            println("I'm shutting down")
        }
    }
}
