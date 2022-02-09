fun main(){
    val n= readLine()!!.toInt()
    val list:ArrayList<String> = arrayListOf()

    for(i in 0 until n){
        val str= readLine()!!
        list.add(str)
    }

    list.sortedWith(compareBy({it.length},{it})).toMutableSet().map{
        println(it)
    }


}