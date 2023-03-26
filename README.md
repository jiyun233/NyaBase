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
