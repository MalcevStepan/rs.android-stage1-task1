package subtask4

class StringParser {
    private var arr = arrayOf<String>()
    private val opn = arrayOf('[', '{', '(', '<')
    private val cls = arrayOf(']', '}', ')', '>')
    fun getResult(inputString: String): Array<String> {
        for (i in inputString.indices)
            if (inputString[i] in opn) {
                result(i, inputString)
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
