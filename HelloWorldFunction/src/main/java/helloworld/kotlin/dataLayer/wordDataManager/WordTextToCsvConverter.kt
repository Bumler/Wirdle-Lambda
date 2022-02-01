package dataLayer.wordDataManager

import util.InputSanitizer
import java.io.File
import java.util.*

class WordTextToCsvConverter(val inputSanitizer: InputSanitizer) {
    fun createCsv(filePath: String, fileName: String){
        val fileContents = File(filePath).readLines()
        val textAsCsv = fileContents.joinToString("\n")
            { "${UUID.randomUUID()},${inputSanitizer.sanitizeString(it)}" }
        File("./src/main/kotlin/dataLayer/wordDataManager/files/$fileName.csv").writeText(textAsCsv)
    }
}