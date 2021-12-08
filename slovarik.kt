import java.io.FileInputStream
import java.util.*

fun main(args: Array<String>){
    val stream = FileInputStream("LittlePrince.txt")
    val sc = Scanner(stream)
    val scanner = Scanner(System.`in`)
    val line = sc.nextLine()
    val wordlist = line.split(" ", "1", "2", "3", "4", "5", "6", "7", "8", "9",
        "!", "№", ";", "%", ":", "?", "*", "(", ")", "_","-", "=", "+", ".", ",", "*", "/", "#", "$", "^","<",">","{","}",
        "[","]","&")
    var map = sortedMapOf<String, Int>()
    for (i in wordlist) {
        if (i != "") {
            if (i in map.keys) {
                map[i] = map[i]?.plus(1) ?: 0
            } else {
                map[i] = 1
            }
        }
        else {}
    }

    var popularWord = ""
    var sum = 0
    var quantity = 0
    var fraction = 0
    for ((key, value) in map) {
        if (value > quantity) {
            popularWord = key
            quantity = value
        }
        sum += value
        if (value == 1) fraction += 1
    }
    println("Чаще всего встречается слово \"$popularWord\" : $quantity раз")
    println("Доля слов, которые встречаются один раз: ${fraction/sum.toDouble()}")
}