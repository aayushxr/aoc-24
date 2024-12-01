import java.io.File

fun main(){
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    val file = File(".").resolve("01_1.txt")
    val fileText = file.readText()

    file.readLines().forEach { line ->
        val nums = line.split("   ").toTypedArray()
        left.add(nums[0].toInt())
        right.add(nums[1].toInt())
    }

    left.sort()
    right.sort()

    var totalDistance = 0
    for (i in 0 until left.size){
        totalDistance += Math.abs(left[i] - right[i])
    }
    
    println(totalDistance)
}
