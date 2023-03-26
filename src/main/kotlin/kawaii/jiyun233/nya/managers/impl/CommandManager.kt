package kawaii.jiyun233.nya.managers.impl

import kawaii.jiyun233.nya.commands.CommandBase
import kawaii.jiyun233.nya.helper.instanceJava
import kawaii.jiyun233.nya.helper.sendErrorMessage
import kawaii.jiyun233.nya.managers.AbstractManager
import kawaii.jiyun233.nya.utils.containsIgnoreCase
import kawaii.jiyun233.nya.utils.plugin
import kawaii.jiyun233.nya.utils.reflections
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.HumanEntity

object CommandManager : AbstractManager("CommandManager"), CommandExecutor {

    val commands = mutableListOf<CommandBase>()

    override fun init() {
        reflections.getSubTypesOf(CommandBase::class.java)
            .filter { it != CommandBase::class.java }
            .forEach {
                val command = it.instanceJava
                if (plugin.getCommand(command.name.toString()) == null) {
                    logManagerError("plugin.yml might be corrupt. command: ${command.name}")
                    return@forEach
                }
                Bukkit.getPluginCommand(command.name.toString()).executor = this
                commands.add(command)
            }
        logManagerInfo(
            "&aLoaded ${commands.size} Command(s), it contains: ${
                commands.map { it::class.java.simpleName }.toTypedArray().contentToString()
            }"
        )
    }

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        commands.filter {
            it.name.toString().equals(command.name, true) ||
                    it.name.toString().equals(command.label, true) ||
                    it.alias.containsIgnoreCase(command.name) ||
                    it.alias.containsIgnoreCase(command.label)
        }
            .forEach {
                if (it.onlyAdmin && !(sender.isOp || sender is ConsoleCommandSender)) {
                    sender.sendErrorMessage("&cThis command is only operator can execute!!!")
                    return@forEach
                }
                if (it.onlyPlayer && sender !is HumanEntity) {
                    sender.sendErrorMessage("&cThis command is only player can execute!!!")
                    return@forEach
                }
                if (it.permission != "NonePermission" && !sender.hasPermission(it.permission)) {
                    sender.sendErrorMessage("&cYou need permission: &6${it.permission}&c to execute this command!")
                    return@forEach
                }
                it.execute(sender, args)
            }
        return false
    }

}