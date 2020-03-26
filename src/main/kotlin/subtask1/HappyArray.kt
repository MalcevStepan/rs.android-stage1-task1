package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        var i = 0
        var k = 0
        var happyArray: IntArray = sadArray.copyOf()
        while (i < sadArray.size) {
            if (i != 0 && i != (sadArray.size - 1) && sadArray[i] > (sadArray[i - 1] + sadArray[i + 1])) {
                k = i
                while (k < sadArray.size - 1) sadArray[k] = sadArray[++k]
                happyArray = sadArray.copyOf(happyArray.size - 1)
                i -= 1
                continue
            }
            i++
        }
        return happyArray
    }
}
