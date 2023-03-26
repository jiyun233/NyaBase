package kawaii.jiyun233.nya.tasks

import kawaii.jiyun233.nya.utils.plugin
import kawaii.jiyun233.nya.utils.scheduler
import org.bukkit.scheduler.BukkitTask

abstract class AbstractTask @JvmOverloads constructor(
    val period: Long,
     val delay: Long = 0L,
    val async: Boolean = false
) : Runnable {
    abstract override fun run()
}