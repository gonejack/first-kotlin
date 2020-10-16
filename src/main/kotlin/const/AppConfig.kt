package const

import com.uchuhimo.konf.ConfigSpec

object AppConfig {
    object Server: ConfigSpec("server") {
        val host by optional("0.0.0.0")
        val port by required<Int>()
    }

    object Account: ConfigSpec("account") {
        val first by optional("first")
        val second by optional("first")
    }
}