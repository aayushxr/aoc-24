import java.io.File

fun main(){
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    val file = File(".").resolve("01.txt")
    val fileText = file.readText()

    file.readLines().forEach { line ->
        val nums = line.split("   ").toTypedArray()
        left.add(nums[0].toInt())
        right.add(nums[1].toInt())
    }

    left.sort()
    right.sort()
   
    val rightCount: MutableMap<Int, Int> = mutableMapOf()
    for (num in right) {
        rightCount[num] = rightCount.getOrDefault(num, 0) + 1
    }
    
    var similarityScore: Int = 0
    for (num in left) {
        similarityScore += num * rightCount.getOrDefault(num, 0)
    }
    println(similarityScore) 
}
