
##  BOJ_1009 분산처리
https://www.acmicpc.net/problem/1009

![image](https://user-images.githubusercontent.com/58967292/148179119-bac73618-63ae-4895-b9ca-978bd5a56d6d.png)


10개의 컴퓨터 그리고  N개의 데이터가 있을 경우  1번 컴퓨터 1번째 데이터  2번 컴퓨터 2번째 데이터 순으로 처리하는 분산처리 시스템이 있다 가정
+ INPUT: 테스트 케이스 T,  정수 A, 정수 B ( 1<=A<=100, 1<=B<=1,000,000)
+ OUTPUT: A의 B승 데이터가 주어질때 마지막 데이터를 처리하는 컴퓨터 번호

### 구현 및 설명
주어진 수의 범위를 고려해서 나올수 있는 데이터개수를 계산해보면, 표준 데이터 타입으로 처리 불가능한것을 알 수 있다
1부터 쭉 써보면 %10이 핵심연산임을 알 수 있다. 즉 구해야 하는것은 A의 B승 전체가 아니라 그것의 일의자리다
0-9까지 고려해야 할필요가 있다는것이다.  이중 0은 10의 배수임으로,  첫째자리는 고려야할필요도 없이 10번 컴퓨터다
1-9까지의 경우를 B승 만큼 제곱한뒤의 일의 자리가 우리가 원하는 결과다. 이는 1-9까지 수를 여러번 곱해보면 발견되는 규칙성을 이용하면 구할수있다.
구한 일의 자리수가 바로 OUTPUT으로 원하는 마지막 데이터를 처리하는 컴퓨터 번호다

```Kotlin
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
```

##  BOJ_1076 저항
https://www.acmicpc.net/problem/1076

![image](https://user-images.githubusercontent.com/58967292/148179245-6ead49a6-fc07-42f4-83ff-251d2d04b11b.png)


+ INPUT: 세 개의 color 값
+ OUPUT: 세 개의 color 값으로 계산된 저항값

### 구현 및 설명
색깔과 값의 경우 구현하는 언어에따라 Map or Dictionary 형태로 표현하면 세 개의 color중  앞에 두 개의 color에 대한 해석은 쉽게 구현할 수 있다.
핵심은 마지막에 주어지는 color은 곱해진다는 것이다.  이는 값과 곱 사이의 10의 n승 관계만 발견하면 어렵지 않게 해결할 수 있다.  

```Kotlin

import kotlin.math.pow

fun computeResistValue(firstColor:String, secondColor:String, thirdColor:String):Long{
    val colorMap:Map<String, Int> = mapOf("black" to 0, "brown" to 1, "red" to 2, "orange" to 3, "yellow" to 4, "green" to 5, "blue" to 6, "violet" to 7, "grey" to 8, "white" to 9)
    val baseNum=10.0
    val firstValue = colorMap[firstColor]!!
    val secondValue = colorMap[secondColor]!!
    val thirdValue = colorMap[thirdColor]!!
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
```

##  BOJ_1052 
https://www.acmicpc.net/problem/1052

![image](https://user-images.githubusercontent.com/58967292/148179378-5a1af5f7-e5a2-4814-be50-9354fcdacfb2.png)

+ INPUT: N:물병의 수  K: 한 번에 옮길 수 있는 물병의 수
+ OUTPUT: 주어진 N개의 물병을 한 번에 옮기기 위해 추가로 구매해야 하는 물병의 수 출력

### 구현내용 및 설명
4문제중 남은 3문제에 소비된 시간만큼 소비한 문제다. 1부터 물병의 수를 늘려가며 쭉 써보면 2의 n승에 해당하는 개수의 물병은 하나로 합쳐지는 규칙은 쉽게 발견할 수 있다. 2의 n승이 아닌 개수의 물병들을 합쳐나가보면 Ex)5= (2,2,1)->(4,1) 7=(2,2,2,1)=(4,2,1)  /2를 통해 합쳐지는 물병 %2를 통해 합쳐지지 않는 물병을 구할 수 있는 것을 알 수 있다. Ex) 5/2=2  5%2=1   2/2=1  2%2=0  1/2=0  1%2=1  =>3개 . 즉 n개의 물병을 옮기는데 필요한 물병의 수는 %2를 통해 구해진다.  이것이 주어진 K보다 작거나 같으면 결과를 출력하면 된다. 이 떄 만약 구한 물병의 수가 K보다 작지 않으면 추가 구입이 필요한 CASE다. 이럴 경우 물병의 개수+1 씩 하면서 K보다 작거나 같은 결과를 나타낼 떄까지 반복하면 된다. 

```Kotlin
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
```
 위 코드에서 countWaterBottle에 있는  while문은 추가 물병이 필요한 경우 물병의 개수를 +1씩 반복하기 위한 로직(추가 물병개수 계산 로직)이고  checkbinNum 함수안에 있는 while문은 num(물병의 수)/2=0이 될 때까지 answer에 num%2를 구해 더해주는 과정을 위한 로직(필요한 물병의 계산 로직)이다.  
 
 ## BOJ_10757
 https://www.acmicpc.net/problem/10757

![image](https://user-images.githubusercontent.com/58967292/148179430-97b0ddc2-1629-410b-8f4c-68f5daac2bf0.png)


+ INPUT:  A,B  ( 0<=A,B<10의 10000승)
+ OUTPUT: A+B
 
 ### 구현 내용 및 설명
 숫자의 범위를 보면 바로 알 수있듯이  기본 데이터 타입으로는 처리가 불가능하다. 게다가 미션요구 사항에 BigNumer를 가능하면 사용하지 말라는 지시상항이 있었기 때문에, 단순 산술적인 방법으로 두 수를 더할수는 없다. 문제에 또다른 요구사항인 이진수 변환기와 nbit Adder을 통해 해결하라는 것이 있었지만, 해당 방법으로 구현할 방법을 떠올리지 못햇다. 따라서 A,B 두개의 수를 문자열로 받아,  index별로 더해 처리하는 방식으로 해결하였다. 어찌보면 half or full adder와 유사한 방법으로 작동된다. 두 개의 자리수를 더해 10이넘어가면 carry를 올리고, 남은값을 결과 String에 저장한다. 두 개의 String을 모두 다 돌고 나서, 마지막으로 남은 carry가 있는지 확인하고 결과 String에 저장한다. 결과 String을 역순으로 출력하면  원하는 OUTPUT인 A+B의 계산 결과가 출력된다. 
 
 ```Kotlin
import java.util.Scanner

fun addBigNumber(a:String, b:String){

    var lengthOfA= a.length
    var lengthOfB= b.length
    var resultString:String=""
    var sum=0
    var carry=0
    while(lengthOfA>0 || lengthOfB>0){
        var numberOfA=0
        if(lengthOfA>0){
            numberOfA= a[--lengthOfA]-'0'
        }
        var numberOfB=0
        if(lengthOfB>0){
            numberOfB= b[--lengthOfB]-'0'
        }
        sum= numberOfA + numberOfB + carry
        carry= sum/10
        sum= sum%10

        resultString+= sum.toString()

    }
    if(carry>0){
        resultString+= carry.toString()
    }

    for(index:Int in resultString.length-1 downTo 0 ){
        print(resultString[index])
    }


}

fun main(){
    val sc: Scanner = Scanner(System.`in`)
    var a =sc.next()
    var b= sc.next()
    addBigNumber(a,b)
}
```
