package org.utl.idgs.introkotlin_901.ejemplo1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.idgs.introkotlin_901.R

class SumaActivity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var radioOperaciones: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        radioOperaciones = findViewById(R.id.radioOperaciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun calcular(view: View) {
        val num1 = et1.text.toString().toDoubleOrNull()
        val num2 = et2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            tv1.text = "Ingresa números válidos"
            return
        }

        val selectedId = radioOperaciones.checkedRadioButtonId

        val resultado = when (selectedId) {
            R.id.rbSumar -> num1 + num2
            R.id.rbRestar -> num1 - num2
            R.id.rbMultiplicar -> num1 * num2
            R.id.rbDividir -> {
                if (num2 == 0.0) {
                    tv1.text = "No se puede dividir entre 0"
                    return
                } else {
                    num1 / num2
                }
            }
            else -> {
                tv1.text = "Selecciona una operación"
                return
            }
        }
        tv1.text = "Resultado = $resultado"
    }
}