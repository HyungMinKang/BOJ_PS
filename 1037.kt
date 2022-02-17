
/*

N의 모든 약수의 곱  = N의  약수의 개수/2승
약수의 개수가 홀수라면 =>  N의 약수의 개수-1/2 승 + sqrt(N)


 */

fun main(){
    val n= readLine()!!.toInt()
    var divider= readLine()?.split(" ")!!.map { it.toLong() }.sorted()
    println(divider[0]*divider[n-1])

}