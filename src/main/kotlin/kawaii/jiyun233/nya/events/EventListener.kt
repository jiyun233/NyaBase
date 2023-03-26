package kawaii.jiyun233.nya.events

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import kawaii.jiyun233.nya.utils.plugin
import org.bukkit.event.Listener
import java.util.concurrent.CopyOnWriteArrayList

abstract class EventListener @JvmOverloads constructor(
    listenerPriority: ListenerPriority = ListenerPriority.NORMAL,
    packetTypes: Iterable<PacketType> = emptyList()
) : Listener, PacketAdapter(plugin, listenerPriority, packetTypes) {
    private val packetReceiveCustomers = CopyOnWriteArrayList<(event: PacketEvent) -> Unit>()
    private val packetSendCustomers = CopyOnWriteArrayList<(event: PacketEvent) -> Unit>()

    protected fun onPacketReceive(onReceive: (event: PacketEvent) -> Unit) {
        packetReceiveCustomers.add(onReceive)
    }

    protected fun onPacketSend(onSend: (event: PacketEvent) -> Unit) {
        packetSendCustomers.add(onSend)
    }

    override fun onPacketReceiving(event: PacketEvent) {
        packetReceiveCustomers.forEach { it.invoke(event) }
    }

    override fun onPacketSending(event: PacketEvent) {
        packetReceiveCustomers.forEach { it.invoke(event) }
    }
}