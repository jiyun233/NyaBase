package kawaii.jiyun233.nya.helper

@Suppress("UNCHECKED_CAST")
inline val <T> Class<out T>.instanceJava: T
    get() = this.declaredFields
        .filter { it.type == this }.firstOrNull {
            try {
                it.isAccessible = true
                it[null]
                true
            } catch (e: Exception) {
                false
            }
        }?.run {
            isAccessible = true
            this[null] as T
        } ?: this.getDeclaredConstructor().newInstance() ?: throw NoSuchFieldException()