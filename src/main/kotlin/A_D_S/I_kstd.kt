package A_D_S


fun main() {
    println(fizzbuzz())
}


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
