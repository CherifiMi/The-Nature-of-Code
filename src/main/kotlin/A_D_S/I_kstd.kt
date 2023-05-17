package A_D_S

fun main() {
    cspace()
}

//region complexity
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
//endregion

// region range
fun x(bottom: Int = 1, top: Int = 100): Int = (top..bottom).filter { it % 2 == 0 }.sum()

fun fizzbuzz(m: MutableList<String> = mutableListOf()): MutableList<String> =
    (1..10000).forEach {
        m.add(
            when {
                it % 3 == 0 && it % 5 == 0 -> "fizzbuzz"
                it % 3 == 0 -> "fizz"
                it % 5 == 0 -> "buzz"
                else -> "$it"
            }
        )
    }.let { m }

// endregion

// region std

fun printCars(car: Car?) {
    // can return anything
    car?.let {
        println(it.name)
    }


    // can return anything but isolated
    val x = car?.run {
        this.name.reversed()
    }


    //need to return the original object
    var xx = car?.also {
        it.name = it.name.reversed()
    }
    println(xx)

    //need to return the original object but isolated
    val y = car?.apply {
        this.name = "apply ${this.name}"
    }

    println(y)
}

//endregion

//region generics
fun generics() {
    val box = Box<Int>()
    box.put(4)

    val boolBox = Box<Boolean>()
    boolBox.put(true)
    boolBox.isEmpty()

    println(box.retrive())
    println(boolBox.retrive())
}

class Box<S> {
    var content: S? = null
    fun put(content: S?) {
        this.content = content
    }

    fun retrive(): S? {
        return content
    }

    fun isEmpty(): Boolean {
        return content == null
    }
}
//endregion

//region fun
fun functions(a: Int, b: Int): Int = if (a > b) a else b
//endregion

//region loops
fun loops() {
    for (i in 1..3) {
        println(i)
    }
    val items = listOf("one", "two", "three")
    for (item in items) {
        println(item)
    }
    //___________
    var x = 10
    while (x > 0) {
        x--
        println(x)
    }
    var y = 10
    do {
        x--
        println(y)
    } while (x > 10)

    var z = 10
    while (z > 0) {
        z++
    }
    println("The light at the end of the tunnel!")
}
//endregion

//region null
fun null_safty() {
    val car1: Car? = null
    val car2: Car = Car(name = "hillo")

    val car3: Car? = car1 ?: Car("world")

    car1?.drive()
    car2.drive()
    car3!!.drive()
}

data class Car(
    var name: String
) {
    fun drive() {
        println("driving " + name)
    }
}
//endregion
