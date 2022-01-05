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