import java.util.*
import kotlin.math.sqrt


fun main() {

    var sc: Scanner = Scanner(System.`in`)
    var checkNum = sc.nextInt()


        for (i: Int in 2..sqrt(checkNum.toDouble()).toInt()) {
            while (checkNum % i == 0) {
                println(i)
                checkNum /= i
            }
        }


    if(checkNum==1){
        return
    }
    else{
        println(checkNum)
    }
}