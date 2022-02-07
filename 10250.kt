fun main(){
    var testCase= readLine()!!.toInt()
    while(testCase>0) {
        var input = readLine()!!.split(" ").map { it.toInt() }
        var h = input[0]
        var w = input[1]
        var n = input[2]
        var floor = n % h
        var number = n / h + 1
        if(floor==0){
            floor=h
            number=n/h
        }

        println(floor * 100 + number)
        testCase--
    }
}