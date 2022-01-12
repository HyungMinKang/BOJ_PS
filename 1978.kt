import java.util.*
import kotlin.math.sqrt


fun main(args: Array<String>) {

    var scanner:Scanner= Scanner(System.`in`)
    var cnt:Int=0
    var num:Int=0
    var primeCount=0
    cnt=scanner.next().toInt()
    for(index:Int in 1..cnt){
        num=scanner.nextInt()
        if(isPrime(num)){
            primeCount++
        }
    }
    println(primeCount)


}

fun isPrime(num:Int):Boolean{

    var sqrtNum= sqrt(num.toDouble())
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
