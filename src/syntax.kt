// 代码块函数体
fun sum(x: Int, y: Int): Int {
    return x + y
}

// 表达式函数体 - 不需要声明返回值类型
fun sum(x: Int, y: Int, z: Int) = x + y + z

// 表达式函数体的弊端，无法针对递归函数进行全局类型推导
// fun foo(n: Int) = if (n==0) 1 else n * foo(n-1)
fun foo(n: Int): Int = if (n == 0) 1 else n * foo(n - 1) // 显式声明返回类型即可解决全局类型推导的问题

fun foo1(x: Int) {
    fun double(y: Int): Int {
        return y * 2
    }
    println(double(x))
}

class Book(val name: String)

fun book(s: (String) -> String) {
    val bookNames = listOf(Book("1"), Book("2")).map(Book::name) // 等价于.map { book -> book.name }
    println(bookNames)
    // 匿名函数的使用
    book(fun(k: String): String {
        return k
    })

    // Lambda
    book { k -> k }
}

val sum: (Int, Int) -> Int = { x, y -> x + y } // (Int, Int) -> Int为参数类型
val s = 1
val a: Int = 2