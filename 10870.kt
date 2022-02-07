fun main(){

    var n= readLine()!!.toInt()
    println(fibonacci(n))
}

 fun fibonacci(n:Int):Int{
    if(n<=1){
        return n
    }
    else {
        return fibonacci(n - 1)+fibonacci(n-2)
    }

}

fun fibo(n:Int) {
    run {
        fun fibon(n: Int, a: Int, b: Int): Int {
            return when (n == 0) {
                true -> b
                false -> fibon(n, a + b, b)
            }

        }
    fibon(n,1,0)
    }
}