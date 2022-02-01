package wirdleLogic

class WirdleChecker {
    // assuming the words are the same length
    fun checkWord(guess: String, actual: String): List<WirdleResult>{
        val wirdleMap = WirdleMap.create(actual)
        return guess.mapIndexed{ index, it ->
            getResult(wirdleMap, it, index)
        }
    }

    private fun getResult(wirdleMap: WirdleMap, currentChar: Char, currentIndex: Int): WirdleResult {
        val indices = wirdleMap.getIndicesForChar(currentChar)
        if (indices.isEmpty())
            return WirdleResult.WRONG_LETTER

        return if (indices.contains(currentIndex)) WirdleResult.EXACT_MATCH
        else WirdleResult.HAS_LETTER
    }
}