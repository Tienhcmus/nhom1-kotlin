object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        if(factors.size < 1){
            return 0
        }
        var Sum: Int = 0
        var list: MutableSet<Int> = mutableSetOf(0)
        for(element in factors){
            var i: Int = 1
            if(element == 0){
                continue
            }
            while(element*i < limit){
                list.add(element*i)
                i++
            }
        }
        list = list.sorted().toMutableSet()
        for(element in list){
            Sum += element
        }
        return Sum
        TODO("Implement this function to complete the task")
    }
}
