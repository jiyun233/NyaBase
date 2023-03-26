package kawaii.jiyun233.nya.commands

import kawaii.jiyun233.nya.helper.Nameable
import org.bukkit.command.CommandSender

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