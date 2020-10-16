package app

import com.uchuhimo.konf.Config
import com.uchuhimo.konf.Item
import com.uchuhimo.konf.OptionalItem
import com.uchuhimo.konf.OptionalProperty
import const.AppConfig

class Conf {
    companion object {
        private val config = Config {
            addSpec(AppConfig.Server)
            addSpec(AppConfig.Account)
        }.from.json.resource("default.json")

        fun init() {
            println(config[AppConfig.Server.host])
            println(config[AppConfig.Account.first])
        }

        fun <T> get(item: Item<T>): T = config[item]
    }
}