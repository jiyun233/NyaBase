package kawaii.jiyun233.nya.tasks

abstract class AbstractTask @JvmOverloads constructor(
    val period: Long,
    val delay: Long = 0L,
    val async: Boolean = false
) : Runnable {
    abstract override fun run()
}