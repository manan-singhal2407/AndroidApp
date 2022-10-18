import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object SemanticVersion {
    private const val major = 1
    private const val minor = 0
    private const val patch = 0

    // Increment this number before every prod or staging release.
    const val versionCode = 1

    val versionName = "$major.$minor.$patch($timeOfBuild)"

    private val timeOfBuild
        get() = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_hh-mma"))
}