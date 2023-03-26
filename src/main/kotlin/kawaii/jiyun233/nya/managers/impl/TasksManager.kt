package kawaii.jiyun233.nya.managers.impl

import kawaii.jiyun233.nya.helper.instanceJava
import kawaii.jiyun233.nya.managers.AbstractManager
import kawaii.jiyun233.nya.tasks.AbstractTask
import kawaii.jiyun233.nya.utils.plugin
import kawaii.jiyun233.nya.utils.reflections
import kawaii.jiyun233.nya.utils.scheduler
import org.bukkit.scheduler.BukkitTask

object TasksManager : AbstractManager("TasksManager") {

    private val tasks = mutableMapOf<AbstractTask, BukkitTask>()

    override fun init() {
        reflections.getSubTypesOf(AbstractTask::class.java)
            .filter { it != AbstractTask::class.java }
            .map { it.instanceJava }
            .forEach {
                tasks[it] =
                    if (it.async) scheduler.runTaskTimerAsynchronously(
                        plugin,
                        it,
                        it.delay,
                        it.period
                    ) else scheduler.runTaskTimer(plugin, it, it.delay, it.period)
            }
        logManagerInfo("Start run ${tasks.size} task(s)")
        logManagerInfo(
            "Sync task(s): ${
                tasks.filter { !it.key.async }.map { it.key }.toTypedArray().contentToString()
            }"
        )
        logManagerInfo(
            "Asynchronously task(s): ${
                tasks.filter { it.key.async }.map { it.key }.toTypedArray().contentToString()
            }"
        )
    }

    @JvmStatic
    fun createNewTask(taskImpl: AbstractTask): BukkitTask {
        tasks[taskImpl] =
            if (taskImpl.async) scheduler.runTaskTimerAsynchronously(
                plugin,
                taskImpl,
                taskImpl.delay,
                taskImpl.period
            ) else scheduler.runTaskTimer(plugin, taskImpl, taskImpl.delay, taskImpl.period)
        return tasks[taskImpl]!!
    }
}