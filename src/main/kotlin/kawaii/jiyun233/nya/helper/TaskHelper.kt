package kawaii.jiyun233.nya.helper

import kawaii.jiyun233.nya.utils.plugin
import kawaii.jiyun233.nya.utils.scheduler
import org.bukkit.scheduler.BukkitTask

fun runBukkitTask(runs: () -> Unit): BukkitTask {
    return scheduler.runTask(plugin, runs)
}

fun runBukkitTaskAsync(runs: () -> Unit): BukkitTask {
    return scheduler.runTaskAsynchronously(plugin, runs)
}

fun runBukkitTaskLater(delay: Long, runs: () -> Unit): BukkitTask {
    return scheduler.runTaskLater(plugin, runs, delay)
}

fun runBukkitTaskLaterAsync(delay: Long, runs: () -> Unit): BukkitTask {
    return scheduler.runTaskLaterAsynchronously(plugin, runs, delay)
}