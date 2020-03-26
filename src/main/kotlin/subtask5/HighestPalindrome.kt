package subtask5

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val array = digitString.toCharArray()
        val array2 = digitString.toCharArray()
        var count = k
        for (i in 0..n / 2)
            if (array[i] > array[n - i - 1]) {
                array[n - i - 1] = array[i]
                if (--count == 0) break
            } else if (array[n - i - 1] > array[i]) {
                array[i] = array[n - i - 1]
                if (--count == 0) break
            }
        var max = 0
        for (i in 0 until n) if (array[max] < array[i]) max = i
        while (count >= 2)
            for (i in 0..n / 2)
                if (array[i] != array[max])
                    if (count >= 2) {
                        array[i] = array[max]
                        array[n - i - 1] = array[max]
                        count -= 2
                        if (count == 0) break
                    } else break

        count = k
        if (array2[max] != array2[n - 1 - max]) {
            array2[n - 1 - max] = array2[max]
            count--
        }
        while (count >= 2) {
            for (i in 0..n / 2) {
                if (array2[i] != array[max]) {
                    if (count >= 2) {
                        array2[i] = array[max]
                        array2[n - i - 1] = array[max]
                        count -= 2
                        if (count == 0) break
                    } else break
                }
            }
        }
        if (isPalindrome(n, array) && isPalindrome(n, array2)) {
            val i = compare(n, array, array2)
            if (i == 0 || i == 2) return String(array)
            if (i == 1) return String(array2)
        } else if (isPalindrome(n, array)) return String(array)
        else if (isPalindrome(n, array2)) return String(array2)
        return "-1"
    }

    fun isPalindrome(n: Int, array: CharArray): Boolean {
        for (a in 0..n / 2) if (array[a] != array[n - a - 1]) return false
        return true
    }

    fun compare(n: Int, array1: CharArray, array2: CharArray): Int {
        for (i in 0 until n) if (array1[i] > array2[i]) return 0
        else if (array2[i] > array1[i]) return 1
        return 2
    }
}