package kawaii.jiyun233.nya.utils

import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.ProtocolManager
import kawaii.jiyun233.nya.PluginLoader
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler
import org.reflections.Reflections

val plugin: JavaPlugin
    get() = JavaPlugin.getPlugin(PluginLoader::class.java)

val reflections = Reflections("kawaii.jiyun233.nya")

val protocolLib: ProtocolManager
    get() = ProtocolLibrary.getProtocolManager()

val scheduler: BukkitScheduler
    get() = Bukkit.getScheduler()

inline fun <T> runCalcTime(runs: () -> T): Long {
    val timer = Timer()
    runs.invoke()
    return timer.passedMs()
}

fun Array<out String>.containsIgnoreCase(s: String): Boolean {
    this.forEach { if (it.equals(s, true)) return true }
    return false
}