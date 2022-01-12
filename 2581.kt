import java.util.*
import kotlin.math.sqrt

fun main(){

    var sc:Scanner=Scanner(System.`in`)
    var m:Int=0
    var n:Int=0
    var minPrimeNum:Int=0
    var primeNumSum:Int=0
    m= sc.nextInt()
    n=sc.nextInt()

    for(i:Int in m..n){
        if(isPrime(i)){
            primeNumSum+=i
            if(minPrimeNum==0 || i<minPrimeNum){
                minPrimeNum=i
            }
        }
    }
    if(minPrimeNum==0){
        println("-1")
    }
    else {
        println(primeNumSum)
        println(minPrimeNum)
    }
}

fun isPrime(num:Int):Boolean{

    val sqrtNum= sqrt(num.toDouble())
    if(num<=1){
        return false
    }
    for(i:Int in 2..sqrtNum.toInt()){
        if(num%i==0){
            return false
        }
    }
    return true

}