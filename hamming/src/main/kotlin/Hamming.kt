import java.lang.IllegalArgumentException

object Hamming {

    @Throws(IllegalArgumentException::class)
    @Suppress("UNREACHABLE_CODE", "ThrowableNotThrown")
    fun compute(leftStrand: String, rightStrand: String): Int {
        if (leftStrand.isEmpty() || rightStrand.isEmpty()) {
            return 0
        }
        if (leftStrand.length != rightStrand.length)
        {
            throw IllegalArgumentException("left and right strands must be of equal length")
        }
        var count: Int = 0
        for (i in 0 until leftStrand.length) {
            if (leftStrand.get(i) != rightStrand.get(i)) {
                count++
            }
        }
        return count
    }
}
