package org.utl.idgs.introkotlin_901.temasKotlin

import kotlin.math.sqrt
fun main() {
    calcularFormulaGeneral()
}

fun calcularFormulaGeneral() {
    println("\nRESOLUCION FORMULA GENERAL)")
    println("Forma general: ax^2 + bx + c = 0")

    var a: Double? = null
    while (a == null || a == 0.0) {
        print("Ingrese el coeficiente a: ")
        a = readLine()?.toDoubleOrNull()

        if (a == null) {
            println("Error: Debe ingresar un número válido")
        } else if (a == 0.0) {
            println("Error: El coeficiente 'a' no puede ser cero. Inténtelo nuevamente.")
        }
    }

    print("Ingrese el coeficiente b: ")
    val b = readLine()?.toDoubleOrNull()
    print("Ingrese el coeficiente c: ")
    val c = readLine()?.toDoubleOrNull()

    if (b == null || c == null) {
        println("Error: Todos los coeficientes deben ser numeros válidos")
        return
    }

    val discriminante = b * b - 4 * a * c

    when {
        discriminante > 0 -> {
            val x1 = (-b + Math.sqrt(discriminante)) / (2 * a)
            val x2 = (-b - Math.sqrt(discriminante)) / (2 * a)
            println("Las soluciones son reales y diferentes:")
            println("x1 = ${"%.4f".format(x1)}")
            println("x2 = ${"%.4f".format(x2)}")
        }
        discriminante == 0.0 -> {
            val x = -b / (2 * a)
            println("La solución es:")
            println("x = ${"%.4f".format(x)}")
        }
        else -> {
            println("No tiene soluciones reales")
        }
    }
}