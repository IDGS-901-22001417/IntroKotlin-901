package org.utl.idgs.introkotlin_901.temasKotlin

import kotlin.math.PI

class Circulo() {
    private var radio: Double = 0.0

    fun setRadio(radio: Double) {
        this.radio = radio
    }

    fun calcularArea(): Double {
        return PI * radio * radio
    }
}

class Cuadrado() {
    private var lado: Double = 0.0

    fun setLado(lado: Double) {
        this.lado = lado
    }

    fun calcularArea(): Double {
        return lado * lado
    }
}

class Pentagono() {
    private var lado: Double = 0.0
    private var apotema: Double = 0.0

    fun setLado(lado: Double) {
        this.lado = lado
    }

    fun setApotema(apotema: Double) {
        this.apotema = apotema
    }

    fun calcularArea(): Double {
        val perimetro = 5 * lado
        return (perimetro * apotema) / 2
    }
}

class Triangulo() {
    private var base: Double = 0.0
    private var altura: Double = 0.0

    fun setBase(base: Double) {
        this.base = base
    }

    fun setAltura(altura: Double) {
        this.altura = altura
    }

    fun calcularArea(): Double {
        return (base * altura) / 2
    }
}

fun mostrarOpciones() {
    println("""
        PRACTICA 1. CALCULO DE AREAS
        ----------------------------
        1. Area de circulo
        2. Area de cuadrado
        3. Area de pentagono
        4. Area de triangulo
        5. Salir
    """)
}

fun main() {
    var opcion: Int

    do {
        mostrarOpciones()
        print("Seleccione una opcion (1-5): ")
        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                val circulo = Circulo()
                print("Ingrese el radio: ")
                val radio = readLine()?.toDoubleOrNull()
                if (radio != null && radio > 0) {
                    circulo.setRadio(radio)
                    println("Area del circulo: ${circulo.calcularArea()}")
                } else {
                    println("Radio invalido.")
                }
            }

            2 -> {
                val cuadrado = Cuadrado()
                print("Ingrese el lado: ")
                val lado = readLine()?.toDoubleOrNull()
                if (lado != null && lado > 0) {
                    cuadrado.setLado(lado)
                    println("Area del cuadrado: ${cuadrado.calcularArea()}")
                } else {
                    println("Lado invalido.")
                }
            }

            3 -> {
                val pentagono = Pentagono()
                print("Ingrese el lado: ")
                val lado = readLine()?.toDoubleOrNull()
                print("Ingrese el apotema: ")
                val apotema = readLine()?.toDoubleOrNull()
                if (lado != null && apotema != null && lado > 0 && apotema > 0) {
                    pentagono.setLado(lado)
                    pentagono.setApotema(apotema)
                    println("Area del pentagono: ${pentagono.calcularArea()}")
                } else {
                    println("Valores invalidos.")
                }
            }

            4 -> {
                val triangulo = Triangulo()
                print("Ingrese la base: ")
                val base = readLine()?.toDoubleOrNull()
                print("Ingrese la altura: ")
                val altura = readLine()?.toDoubleOrNull()
                if (base != null && altura != null && base > 0 && altura > 0) {
                    triangulo.setBase(base)
                    triangulo.setAltura(altura)
                    println("Area del triangulo: ${triangulo.calcularArea()}")
                } else {
                    println("Valores invalidos.")
                }
            }

            5 -> println("Saliendo del programa...")
            else -> println("Opcion no valida.")
        }
        println()
    } while (opcion != 5)
}