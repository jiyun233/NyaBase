package kawaii.jiyun233.nya.helper

interface Nameable {
    val name: CharSequence
        get() = name.toString()
}