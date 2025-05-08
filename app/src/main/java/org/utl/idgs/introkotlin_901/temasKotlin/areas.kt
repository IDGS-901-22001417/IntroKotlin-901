package org.utl.idgs.introkotlin_901.temasKotlin

import kotlin.math.PI

fun main() {
    var opcion: Int
    do {
        mostrarMenu()
        print("Seleccione una opcion (1-5): ")
        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> calcularAreaCirculo()
            2 -> calcularAreaCuadrado()
            3 -> calcularAreaPentagono()
            4 -> calcularAreaTriangulo()
            5 -> println("Saliendo del programa...")
            else -> println("Opción no válida. Intente de nuevo.")
        }
        println()
    } while (opcion != 5)
}

fun mostrarMenu() {
    println("""
        PRACTICA 1. CÁLCULO DE ÁREAS
        ----------------------------
        1. Area de circulo
        2. Area de cuadrado
        3. Area de pentagono
        4. Area de triangulo
        5. Salir
    """)
}

fun calcularAreaCirculo() {
    print("Ingrese el radio del circulo: ")
    val radio = readLine()?.toDoubleOrNull()

    if (radio != null && radio > 0) {
        val area = PI * radio * radio
        println("El area del circulo con radio $radio es: ${(area)}")
    } else {
        println("Radio no valido. Debe ser un numero positivo.")
    }
}

fun calcularAreaCuadrado() {
    print("Ingrese el lado del cuadrado: ")
    val lado = readLine()?.toDoubleOrNull()

    if (lado != null && lado > 0) {
        val area = lado * lado
        println("El area del cuadrado con lado $lado es: ${(area)}")
    } else {
        println("Lado no valido. Debe ser un numero positivo.")
    }
}

fun calcularAreaPentagono() {
    print("Ingrese la longitud de un lado del pentágono: ")
    val lado = readLine()?.toDoubleOrNull()

    print("Ingrese la medida del apotema: ")
    val apotema = readLine()?.toDoubleOrNull()

    when {
        lado == null || apotema == null ->
            println("Error: Ambos valores deben ser números válidos")

        lado <= 0 || apotema <= 0 ->
            println("Error: Los valores deben ser positivos")

        else -> {
            val perimetro = 5 * lado
            val area = (perimetro * apotema) / 2
            println("Area = ${(area)}")
        }
    }
}

fun calcularAreaTriangulo() {
    println("\nCALCULO DEL ÁREA DE UN TRIÁNGULO")
    println("-------------------------------")
    println("Formula: (base × altura) / 2\n")

    print("Ingrese la base del triángulo: ")
    val base = readLine()?.toDoubleOrNull()

    print("Ingrese la altura del triángulo: ")
    val altura = readLine()?.toDoubleOrNull()

    when {
        base == null || altura == null ->
            println("Error: Tanto la base como la altura deben ser numeros validos")

        base <= 0 || altura <= 0 ->
            println("Error: La base y la altura deben ser valores positivos")

        else -> {
            val area = (base * altura) / 2
            println("Area = ${(area)}")
        }
    }
}