package modules.woker

import kotlin.concurrent.thread

class Twitter() : WorkerInterface {
    private var stopping = false;
    private var running = false;

    private fun fetchTweets() {
        println("fetch tweets")
    }

    override fun start() {
        this.running = true

        thread {
            while (this.running) {
                this.fetchTweets()

                Thread.sleep(1000)

                if (this.stopping) {
                    break;
                }
            }

            this.running = false
        }

        println("workers started")
    }

    override fun stop() {
        this.stopping = true

        while (this.running) {
            Thread.sleep(1000)

            println("worker stopped")
        }
    }
}