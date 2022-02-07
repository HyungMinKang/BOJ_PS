fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val N: Int = br.readLine().toInt()

    val array = IntArray(10001)
    for (i in 0 until N) {
        array[br.readLine().toInt()]++
    }
    br.close()

    for (i in array.indices) {
        bw.write("$i\n".repeat(array[i]))
    }
    bw.close()
}