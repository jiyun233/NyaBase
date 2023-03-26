package kawaii.jiyun233.nya.utils

class Timer {
    private var timeStamp = System.currentTimeMillis()

    fun reset() {
        timeStamp = System.currentTimeMillis()
    }

    fun passedMs(): Long {
        return System.currentTimeMillis() - timeStamp
    }

    fun isPassedMs(ms: Long): Boolean {
        return System.currentTimeMillis() - timeStamp > ms
    }
}