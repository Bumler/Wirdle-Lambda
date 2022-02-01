package dataLayer.wordDataManager

import dataLayer.Word
import dataLayer.wordDataManager.WordCSVModel.idColumn
import dataLayer.wordDataManager.WordCSVModel.valueColumn
import java.util.*

object WordCsvToPokoConverter {
    fun convertWord (csvLine: String): Word{
        val csvArray = csvLine.split(',')
        return Word(
            UUID.fromString(csvArray[idColumn]),
            csvArray[valueColumn])
    }
}