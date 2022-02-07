fun main(){

    var n= readLine()!!.toInt()
    println(fact(n,1))
}

fun factorial(n:Int, res:Int):Long{

    return if(n<=0){
        res.toLong()
    }
    else{
        factorial(n-1, n*res)
    }

}

tailrec fun fact(n:Int, res:Int):Int{
    return if(n<=0){
        res
    }
    else{
        fact(n-1, res*n)
    }
}