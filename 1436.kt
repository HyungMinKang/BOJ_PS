fun main(){
    var idx= readLine()!!.toInt()

    var cnt=0
    var num=0

    while(cnt!=idx){
        num++
        var temp= num
        while(temp!=0){
            if(temp%1000==666){
                cnt++
                break;
            }
            else{
                temp/=10
            }
        }
    }
    println(num)
}