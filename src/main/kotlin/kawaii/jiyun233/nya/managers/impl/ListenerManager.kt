package kawaii.jiyun233.nya.managers.impl

import kawaii.jiyun233.nya.events.EventListener
import kawaii.jiyun233.nya.helper.instanceJava
import kawaii.jiyun233.nya.helper.logInfo
import kawaii.jiyun233.nya.managers.AbstractManager
import kawaii.jiyun233.nya.utils.plugin
import kawaii.jiyun233.nya.utils.protocolLib
import kawaii.jiyun233.nya.utils.reflections
import org.bukkit.Bukkit

@Suppress("unused")
object ListenerManager : AbstractManager("ListenerManager") {

    override fun init() {
        val classes = reflections.getSubTypesOf(EventListener::class.java)
            .filter { it != EventListener::class.java }
        classes
            .forEach {
                val listener = it.instanceJava
                Bukkit.getPluginManager().registerEvents(listener, plugin)
                protocolLib.addPacketListener(listener)
            }
        logManagerInfo(
            "&aLoaded ${classes.size} Listener(s), it contains: ${
                classes.map { it.simpleName }.toTypedArray().contentToString()
            }"
        )
    }

}