import java.util.Scanner

fun checkBindNum(bottleNum:Long):Long{
    var num =bottleNum
    var answer:Long=0
    while(true){

        var a= num/2
        var b= num%2
        answer+=b
        num=a
        if(num.toInt() ==0){
            break;
        }
    }
    return answer
}


fun countWaterBottle(N:Long, K:Int):Long{

    var result:Long=0

    if(K>=N){
        return 0
    }
    else{
        var bottleNum=N
        while(true) {
            if (checkBindNum(bottleNum) <= K) {
                result = bottleNum - N
                break;
            } else {
                bottleNum++
            }
        }
    }
    return result
}



fun getWaterBottleCount(){
    val sc: Scanner = Scanner(System.`in`)
    val N = sc.nextLong()
    val K = sc.nextInt()
    val result= countWaterBottle(N,K)
    println(result)
}



fun main(){
    getWaterBottleCount()
}