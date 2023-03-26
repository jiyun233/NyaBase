package kawaii.jiyun233.nya.helper

import kawaii.jiyun233.nya.PluginName
import kawaii.jiyun233.nya.utils.plugin
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import java.util.logging.Logger

val logger: Logger
    get() = plugin.logger

fun String.mcColored(colorChar: Char = '&'): String {
    return ChatColor.translateAlternateColorCodes(colorChar, this)
}

fun logInfo(info: CharSequence) {
    logger.info("&7[&9INFO&7]&r$info".mcColored())
}

fun logError(error: CharSequence) {
    logger.info("&7[&cERROR&7]&r$error".mcColored())
}

fun CommandSender.sendErrorMessage(message: CharSequence) {
    this.sendMessage("&7[&9&l$PluginName&7][&9INFO&7]&r$message".mcColored())
}

fun CommandSender.sendColorMessage(message: CharSequence, prefix: Boolean = false) {
    this.sendMessage("${if (prefix) "&7[&9&l$PluginName&7]&r" else ""}$message".mcColored())
}