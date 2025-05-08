package org.utl.idgs.introkotlin_901.temasKotlin

fun main() {
    // for
    for(number in 1..5){
        println(number)
    }
    val nombres = listOf("Oscar", "Juan", "Pedro", "Jose")

    for(nombre in nombres){
        println(nombre)
    }
    //while do-while
    var x = 0
    while (x<5){
        println(x)
        x++
    }

    do {
        println(x)
        x++
    } while (x<5)
}