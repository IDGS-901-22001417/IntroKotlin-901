package org.utl.idgs.introkotlin_901.temasKotlin

fun main() {
    println("PROGRAMA DE PIRÁMIDES")
    println("----------------------------")
    println("Ingrese la altura de la piramide (0 para salir)")

    var altura: Int

    do {
        print("\nAltura de la piramide: ")
        altura = readLine()?.toIntOrNull() ?: -1

        if (altura == 0) {
            println("Saliendo del programa...")
        } else if (altura > 0) {
            var i = 1
            do {
                var j = 1
                do {
                    print("*")
                    j++
                } while (j <= i)
                println()
                i++
            } while (i <= altura)
        } else {
            println("Por favor ingrese un numero entero positivo o 0 para salir")
        }
    } while (altura != 0)
}
