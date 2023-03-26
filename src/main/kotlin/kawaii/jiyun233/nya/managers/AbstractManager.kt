package kawaii.jiyun233.nya.managers

import kawaii.jiyun233.nya.helper.Nameable
import kawaii.jiyun233.nya.helper.logError
import kawaii.jiyun233.nya.helper.logInfo

interface ILoading {
    val priority: Int
    fun init()
}

abstract class AbstractManager @JvmOverloads constructor(
    override val name: CharSequence,
    override val priority: Int = 0
) : ILoading, Nameable {

    fun logManagerInfo(info: String) {
        logInfo("&8[&b$name&8]&r$info")
    }

    fun logManagerError(error: String) {
        logError("&8[&b$name&8]&r$error")
    }
}