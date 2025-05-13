package org.utl.idgs.introkotlin_901.temasKotlin

fun saludo() {
    return println("Hola Mundio")
}
fun sum(x:Int, y:Int): Int {
    return x + y
}

fun sum2(x:Int, y:Int) = x + y

fun main(){
    saludo()
    println("----------------------------------------------------------------------------------------------------")
    println(sum(2, 3))
    println(sum2(2, 3))
}