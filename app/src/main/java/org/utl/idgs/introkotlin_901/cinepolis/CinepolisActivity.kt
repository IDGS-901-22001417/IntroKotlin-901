package org.utl.idgs.introkotlin_901.cinepolis

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.idgs.introkotlin_901.R

class CinepolisActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etCompradores: EditText
    private lateinit var etBoletos: EditText
    private lateinit var rgTarjetaCineco: RadioGroup
    private lateinit var rbSi: RadioButton
    private lateinit var rbNo: RadioButton
    private lateinit var tvTotal: TextView
    private lateinit var btnCalcular: Button

    private val PRECIO_BOLETO = 12.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etNombre = findViewById(R.id.etNombre)
        etCompradores = findViewById(R.id.etCompradores)
        etBoletos = findViewById(R.id.etBoletos)
        rgTarjetaCineco = findViewById(R.id.rgTarjetaCineco)
        rbSi = findViewById(R.id.rbSi)
        rbNo = findViewById(R.id.rbNo)
        tvTotal = findViewById(R.id.tvTotal)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {calcularTotal() }
    }
    private fun calcularTotal() {
        if (!validarCampos()) {
            return
        }

        val nombre = etNombre.text.toString().trim()
        val compradores = etCompradores.text.toString().toInt()
        val boletos = etBoletos.text.toString().toInt()
        val tieneTarjetaCineco = rbSi.isChecked

        if (!validarCantBoletos(compradores, boletos)) {
            return
        }

        val total = calcularPrecioFinal(boletos, tieneTarjetaCineco)

        tvTotal.text = "$ " + total.toString()

        Toast.makeText(this, "Cálculo realizado para $nombre", Toast.LENGTH_SHORT).show()
    }

    private fun validarCampos(): Boolean {
        if (etNombre.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su nombre", Toast.LENGTH_SHORT).show()
            etNombre.requestFocus()
            return false
        }

        if (etCompradores.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor ingrese la cantidad de compradores", Toast.LENGTH_SHORT).show()
            etCompradores.requestFocus()
            return false
        }

        if (etBoletos.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor ingrese la cantidad de boletos", Toast.LENGTH_SHORT).show()
            etBoletos.requestFocus()
            return false
        }

        try {
            val compradores = etCompradores.text.toString().toInt()
            val boletos = etBoletos.text.toString().toInt()

            if (compradores <= 0) {
                Toast.makeText(this, "La cantidad de compradores debe ser mayor a 0", Toast.LENGTH_SHORT).show()
                return false
            }

            if (boletos <= 0) {
                Toast.makeText(this, "La cantidad de boletos debe ser mayor a 0", Toast.LENGTH_SHORT).show()
                return false
            }

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Por favor ingrese números válidos", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun validarCantBoletos(compradores: Int, boletos: Int): Boolean {
        val maxBoletosPermitidos = compradores * 7

        if (boletos > maxBoletosPermitidos) {
            Toast.makeText(
                this,
                "No se pueden comprar más de 7 boletos por persona.\nMáximo permitido: $maxBoletosPermitidos boletos",
                Toast.LENGTH_LONG
            ).show()
            return false
        }

        return true
    }

    private fun calcularPrecioFinal(boletos: Int, tieneTarjetaCineco: Boolean): Double {
        var total = boletos * PRECIO_BOLETO
        var descuento = 0.0

        when {
            boletos > 5 -> {
                descuento = 0.15
            }
            boletos in 3..5 -> {
                descuento = 0.10
            }
            boletos <= 2 -> {
                descuento = 0.0
            }
        }

        total -= (total * descuento)

        if (tieneTarjetaCineco) {
            total -= (total * 0.10)
        }

        return total
    }
}