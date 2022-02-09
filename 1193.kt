
fun main(){

    var x= readLine()!!.toInt()
    var up=0
    var down=0
    var count=1
    var total=1
    while(total<x){

        count++
        if(x<total+count){
            total+=count
            break
        }
        else{
            total+=count
        }
    }

    var diff= total -x
    if(count%2==0){
        up=count
        down=1
        for(i:Int in 0 until diff){
            up--
            down++
        }
        print("${up}/${down}")
    }
    else{
        up=1
        down=count
        for(i:Int in 0 until diff){
            up++
            down--
        }
        print("${up}/${down}")
    }
}