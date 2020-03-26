package subtask4

class StringParser {
    private var arr = arrayOf<String>()
    private val opn = arrayOf('[', '{', '(', '<')
    private val cls = arrayOf(']', '}', ')', '>')
    fun getResult(inputString: String): Array<String> {
        var index:Int
        var index2:Int
        for (i in inputString.indices)
            if (inputString[i] in opn) {
                index = arr.size
                result(i, inputString)
                arr.distinct()
                index2 = arr.size
                if (index2 - index > 1) {
                    while (index < index + (index2 - index) / 2) {
                        val tmp = arr[index]
                        arr[index++] = arr[index2 - 1]
                        arr[index2-- - 1] = tmp
                    }
                }
            }
        return arr.distinct().toTypedArray()
    }

    private fun result(begin: Int, inputString: String) {
        var str = ""
        val char = inputString[begin]
        var k = 0
        for (i in begin + 1 until inputString.length) {
            if (inputString[i] in cls && opn.indexOf(char) == cls.indexOf(inputString[i]) && k == 0) {
                arr += str
                return
            } else if (opn.indexOf(char) == cls.indexOf(inputString[i]) && k != 0) k--
            str = inputString.substring(begin + 1, begin + 1 + (i - begin))
            if (inputString[i] in opn)
                result(i, inputString)
            if (char == inputString[i]) k++
        }
    }
}
