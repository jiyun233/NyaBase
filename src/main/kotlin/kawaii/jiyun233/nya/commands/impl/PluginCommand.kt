package kawaii.jiyun233.nya.commands.impl

import kawaii.jiyun233.nya.PluginName
import kawaii.jiyun233.nya.commands.CommandBase
import kawaii.jiyun233.nya.helper.sendColorMessage
import kawaii.jiyun233.nya.managers.impl.CommandManager
import org.bukkit.command.CommandSender

object PluginCommand : CommandBase(PluginName, descriptions = "Plugin Helper Command.", alias = arrayOf("Nya")) {

    override fun execute(sender: CommandSender, args: Array<out String>) {
        sender.sendColorMessage("&9$PluginName Helper&d&l -------->>")
        CommandManager.commands.forEach {
            sender.sendColorMessage("&a${it.name}: &e${it.descriptions}")
            sender.sendColorMessage("   &dPermission: &e${it.permission} &dOnlyPlayer: &e${it.onlyPlayer} &dOnlyAdmin: &e${it.onlyAdmin}")
            sender.sendColorMessage("   &dAliases: &e${it.alias.contentToString()}\n")
        }
    }
}