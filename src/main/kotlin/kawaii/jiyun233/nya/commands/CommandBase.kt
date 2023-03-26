package kawaii.jiyun233.nya.commands

import kawaii.jiyun233.nya.helper.Nameable
import org.bukkit.command.CommandSender
import kawaii.jiyun233.nya.commands.impl.PluginCommand

/**
 * @param name Command execute name
 * @param permission Execute command permission need
 * @param onlyPlayer Only player can execute this command
 * @param onlyAdmin Only Server Operator can execute
 * @param descriptions Command descriptions show at [PluginCommand]
 * @param alias Other name can execute this command
 */
abstract class CommandBase @JvmOverloads constructor(
    override val name: CharSequence,
    val permission: String = "NonePermission",
    val onlyPlayer: Boolean = false,
    val onlyAdmin: Boolean = false,
    val descriptions: CharSequence = "Non descriptions.",
    vararg val alias: String = emptyArray()
) : Nameable {

    abstract fun execute(sender: CommandSender, args: Array<out String>)

}