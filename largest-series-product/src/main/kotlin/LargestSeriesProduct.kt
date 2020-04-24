class Series (input: String){

    private val input = if(input.all{it.isDigit()}) input else {throw IllegalArgumentException()}

    fun getLargestProduct(span: Int): Long {
        require(span >= 0 && span <= input.length)
        if (span == 0) return 1
        val n = input.length
        var ans: Long = 0
        for (i in 0 until n - span + 1)
        {
            val s = input.substring(i, i+span)
            val x : Long = s.toCharArray().map { it.toLong() - '0'.toLong() }.reduce{acc, j -> acc*j}
            ans = if (x > ans) x else ans
        }
        return ans
    }
}
