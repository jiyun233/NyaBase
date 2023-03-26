package kawaii.jiyun233.nya

import kawaii.jiyun233.nya.helper.instanceJava
import kawaii.jiyun233.nya.helper.logInfo
import kawaii.jiyun233.nya.managers.AbstractManager
import kawaii.jiyun233.nya.managers.ILoading
import kawaii.jiyun233.nya.utils.reflections

object NyaBase {

    private val nonAddon = arrayOf(
        ILoading::class.java,
        AbstractManager::class.java
    )

    @JvmStatic
    fun init() {
        reflections.getSubTypesOf(AbstractManager::class.java)
            .filter { it !in nonAddon }
            .map { it.instanceJava }
            .sortedBy { it.priority }
            .reversed()
            .forEach {
                it.init()
                logInfo("&6Loaded Manager: ${it.name}")
            }
    }
}