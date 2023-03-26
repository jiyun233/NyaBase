# NyaBase
a base for minecraft bukkit plgin, all kotlin code

## Command
````kotlin
object ExampleCommand :
    CommandBase(
        "example",
        "server.command.example",
        false,
        true,
        "Example Command",
        "exam", "exp"
    ) {
    override fun execute(sender: CommandSender, args: Array<out String>) {
        TODO("Not yet implemented")
    }
}
````

## EventListener
````kotlin
class ExampleListener : EventListener(ListenerPriority.NORMAL, listOf(PacketType.Play.Client.CHAT)) {
    init {
        onPacketReceive {
            TODO("On packet receiving runs")
        }
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        TODO("Other bukkit event listener")
    }
}
````
