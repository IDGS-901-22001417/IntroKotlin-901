package org.utl.idgs.introkotlin_901.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.utl.idgs.introkotlin_901.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class BuscarActivity : AppCompatActivity() {

    private val fileName = "palabras.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)

        val rbEspanol = findViewById<RadioButton>(R.id.rbEspanol)
        val rbIngles = findViewById<RadioButton>(R.id.rbIngles)
        val etPalabraBuscar = findViewById<EditText>(R.id.etPalabraBuscar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnRegresar = findViewById<Button>(R.id.btnRegresarMenuBuscar)

        btnRegresar.setOnClickListener { navegateToMenu() }

        btnBuscar.setOnClickListener {
            val palabra = etPalabraBuscar.text.toString().trim()

            if (palabra.isBlank()) {
                tvResultado.text = "Debes ingresar una palabra."
                return@setOnClickListener
            }

            if (!rbEspanol.isChecked && !rbIngles.isChecked) {
                tvResultado.text = "Selecciona un idioma."
                return@setOnClickListener
            }

            try {
                val inputStream = openFileInput(fileName)
                val reader = BufferedReader(InputStreamReader(inputStream))
                var linea: String?
                var encontrada = false

                while (reader.readLine().also { linea = it } != null) {
                    val partes = linea!!.split(",")
                    if (partes.size == 2) {
                        val espanol = partes[0].trim()
                        val ingles = partes[1].trim()

                        if (rbEspanol.isChecked && palabra.equals(ingles, ignoreCase = true)) {
                            tvResultado.text = espanol
                            encontrada = true
                            break
                        }

                        if (rbIngles.isChecked && palabra.equals(espanol, ignoreCase = true)) {
                            tvResultado.text = ingles
                            encontrada = true
                            break
                        }
                    }
                }
                reader.close()

                if (!encontrada) {
                    tvResultado.text = "Palabra no encontrada."
                }
            } catch (e: IOException) {
                e.printStackTrace()
                tvResultado.text = "No se pudo leer el archivo."
            }
        }
    }

    private fun navegateToMenu() {
        val intent = Intent(this, DiccionarioActivity::class.java)
        startActivity(intent)
    }
}
