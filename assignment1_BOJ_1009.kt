import kotlin.math.pow

fun computeDataCount() :Double {
    val numbers = readLine()!!.split(" ")
    val firstNum= numbers[0].toDouble()
    val secondNum= numbers[1].toInt()
    val firstDigitFlag= (firstNum%10)
    var lastComputerNum:Double=0.0
    when(firstDigitFlag){
        1.0,5.0,6.0-> lastComputerNum= firstDigitFlag
        2.0,3.0,
        7.0,8.0 -> if(secondNum%4==0) lastComputerNum= (firstDigitFlag.pow(4))%10 else lastComputerNum= ((firstDigitFlag).pow(secondNum%4 ))%10
        4.0,9.0-> if(secondNum%2==0) lastComputerNum=(firstDigitFlag.pow(2))%10 else lastComputerNum=((firstDigitFlag).pow(secondNum%2 ))%10
        0.0-> lastComputerNum= 10.0
    }
    return lastComputerNum

}

fun getComputeLastDataComputer(){
    val dataCount= computeDataCount().toInt()
    println(dataCount)

}

fun main(args: Array<String>){
    val testNumber= readLine()!!.toInt()
    for(index:Int in 1..testNumber){
        getComputeLastDataComputer()
    }
}