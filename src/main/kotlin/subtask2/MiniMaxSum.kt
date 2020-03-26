package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        var min = 0
        var max = 0
        var sum = 0
        for (i in input) {
            if (min == 0 && max == 0) {
                min = i
                max = i
            }
            min = if (i < min) i else min
            max = if (i > max) i else max
            sum += i
        }
        return intArrayOf(sum - max, sum - min)
    }
}
