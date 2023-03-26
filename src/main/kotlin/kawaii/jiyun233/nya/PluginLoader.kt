package kawaii.jiyun233.nya

import kawaii.jiyun233.nya.helper.logInfo
import kawaii.jiyun233.nya.helper.mcColored
import kawaii.jiyun233.nya.utils.runCalcTime
import org.bukkit.plugin.java.JavaPlugin

const val PluginName: String = "NyaBase"

class PluginLoader : JavaPlugin() {

    override fun onEnable() {
        logInfo("&aStart loading $PluginName plugin...")
        logInfo("&aLoaded $PluginName Compiled! it took time: ${
            runCalcTime { NyaBase.init() }
        }ms")
        val ascii = "\n" +
                ".__   __. ____    ____  ___      .______        ___           _______. _______ \n" +
                "|  \\ |  | \\   \\  /   / /   \\     |   _  \\      /   \\         /       ||   ____|\n" +
                "|   \\|  |  \\   \\/   / /  ^  \\    |  |_)  |    /  ^  \\       |   (----`|  |__   \n" +
                "|  . `  |   \\_    _/ /  /_\\  \\   |   _  <    /  /_\\  \\       \\   \\    |   __|  \n" +
                "|  |\\   |     |  |  /  _____  \\  |  |_)  |  /  _____  \\  .----)   |   |  |____ \n" +
                "|__| \\__|     |__| /__/     \\__\\ |______/  /__/     \\__\\ |_______/    |_______|\n" +
                "                                                                               "
        logger.info(
            "&9${ascii}".mcColored()
        )
    }
}

