package A_D_S


fun cspace(){
    // O(n): males new list with the same size
    fun printSorted(numbers: List<Int>) {
        val sorted = numbers.sorted()
        for (element in sorted) {
            println(element)
        }
    }

    // O(1): only allocates memory for a few vars
    fun printSorted2(numbers: List<Int>){
        if (numbers.isEmpty()) return

        var currentCount = 0
        var minValue = Int.MIN_VALUE

        for (value in numbers){
            if (value == minValue){
                println(value)
                currentCount++
            }
        }

        while (currentCount<numbers.size){
            var currentValue = numbers.max()!!

            for(value in numbers){
                if(value==currentValue && value>minValue){
                    println(value)
                    currentCount++
                }
            }
            minValue=currentValue
        }
    }
}

fun ctime() {
    // O(1): constant time, same time regardless of input size
    fun checkFirst(names: List<String>){
        println(names.first())
    }

    // O(n): linear time, running time is the same as the data size
    fun printName(names: List<String>){
        for(name in names){
            println(name)
        }
    }

    // O(n^2): quadratic time, n squared, takes a square of the input size
    fun multiplicationBoard(size: Int){
        for(num in 1..size){
            for (num2 in 1..size){
                println("$num x $num2 = ${num*num2}")
            }
        }
    }

    // : logarithemic time, can use shortcuts,
    fun containL(list: List<Int>, num: Int): Boolean{ // O(n): see all values
        for (i in list){
            if (i==num) return true
        }
        return false
    }
    fun containLog(list: List<Int>, num: Int): Boolean{ // O(log n): see only half values
        val midI = list.size/2
        if (num <= list[midI]) {
            for (i in 0..midI){
                if (list[i]==num) return true
            }
        }else{
            for (i in midI until list.size){
                if (list[i]==num) return true
            }
        }

        return false
    }
    // O(n log n): quasilinear time, worse than linear but better than quadratic
    fun sortK(list: List<Int>){
        list.sorted()
    }
}
