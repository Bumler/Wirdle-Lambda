package util

import java.util.*

class InputSanitizer {
    fun sanitizeString(s: String): String {
        return s.uppercase(Locale.getDefault()).trim()
    }
}
