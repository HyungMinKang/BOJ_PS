fun main(){
    var n= readLine()!!.toLong()

    val list:ArrayList<Int> = arrayListOf()

    while(n>0){
        val m= (n%10).toInt()
        list.add(m)
        n /= 10

    }

    list.sortDescending()
    list.map{
        print(it)
    }


}