import java.lang.Integer.min
import kotlin.collections.toCollection as toCollection1

fun main() {
    var chess = readLine()!!.split(" ")
    var row = chess[0].toInt()
    var col = chess[1].toInt()
    var chessBoard = Array(row, { Array(col, { 'a' }) })
    for(i:Int in 0 until  row){
        var info= readLine()!!.toCharArray()
        for(j:Int in 0 until col){
            chessBoard[i][j]= info[j]
        }
    }

    // 맨 왼쪽 위 칸이 흰색
    val whiteChess = arrayOf(
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW"
    )

    // 맨 왼쪽 위 칸이 검은색
    val blackChess = arrayOf(
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB"
    )
    var curX=0
    var curY=0
    var count_w=0
    var count_b=0
    var min= 100000000

    while(true){
        if(curX+8>row && curY+8>col) break
        var x=0
        var y=0
        if(curX+8<=row){
            if(curY+8<=col){
                for(i:Int in curX until curX+8){
                    for(j:Int in curY until curY+8){
                        if(chessBoard[i][j]!=whiteChess[x][y])count_w++
                        if(chessBoard[i][j]!=blackChess[x][y])count_b++
                        x++
                    }
                    x=0
                    y++
                }
                var result= min(count_w,count_b)
                min= min(min,result)
                count_w=0
                count_b=0
                curY++
            }
            else{
                break
            }

        }
        else{
            curY=0
            curX++
        }
    }
    println(min)
}


