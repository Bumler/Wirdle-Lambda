package wirdleLogic

class WirdleMap private constructor(
    private val wirdleMap: Map<Char, List<Int>>){

    fun getIndicesForChar(c: Char): List<Int>{
        return wirdleMap[c] ?: listOf()
    }

    companion object{
        fun create(wird: String): WirdleMap {
            val wirdMap = mutableMapOf<Char, List<Int>>()

            wird.toCharArray().forEachIndexed { index, c ->
                wirdMap[c] = addOrCreateListItem(wirdMap[c], index)
            }

            return WirdleMap(wirdMap)
        }

        private fun addOrCreateListItem(list: List<Int>?, int: Int): List<Int>{
            return if(list == null){
                listOf(int)
            } else
                list + int
        }
    }
}
