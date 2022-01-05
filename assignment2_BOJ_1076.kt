
import kotlin.math.pow

fun computeResistValue(firstColor:String, secondColor:String, thirdColor:String):Long{
    val colorMap:Map<String, Int> = mapOf("black" to 0, "brown" to 1, "red" to 2, "orange" to 3, "yellow" to 4, "green" to 5, "blue" to 6, "violet" to 7, "grey" to 8, "white" to 9)
    val baseNum=10.0
    val firstValue = colorMap[firstColor]!!
    val secondValue = colorMap[secondColor]!!
    val thirdValue = (colorMap[thirdColor])!!
    val multipleValue=baseNum.pow(thirdValue)
    val result:Long= ((firstValue*10 + secondValue)*multipleValue).toLong()
    return result


}

fun getResistValue(){
    val firstColor= readLine()!!
    val secondColor= readLine()!!
    val thirdColor= readLine()!!
    val result= computeResistValue(firstColor, secondColor, thirdColor)
    println(result)

}

fun main(args: Array<String>){
    getResistValue()

}