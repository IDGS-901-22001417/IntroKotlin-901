package org.utl.idgs.introkotlin_901.diccionario

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.idgs.introkotlin_901.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class CapturarActivity : AppCompatActivity() {

    private val fileName = "palabras.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar)

        val etEspanol = findViewById<EditText>(R.id.etEspanol)
        val etIngles = findViewById<EditText>(R.id.etIngles)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnRegresarMenu = findViewById<Button>(R.id.btnRegresarMenu)

        btnRegresarMenu.setOnClickListener { navegateToMenu() }

        btnGuardar.setOnClickListener {
            val textoEspanol = etEspanol.text.toString().trim()
            val textoIngles = etIngles.text.toString().trim()

            if (textoEspanol.isNotBlank() && textoIngles.isNotBlank()) {

                if (palabraExiste(textoEspanol, textoIngles)) {
                    mostrarDialogo("Duplicado", "La palabra ya está registrada.")
                    return@setOnClickListener
                }

                val linea = "$textoEspanol,$textoIngles\n"

                try {
                    openFileOutput(fileName, MODE_APPEND).use {
                        it.write(linea.toByteArray())
                    }
                    etEspanol.text.clear()
                    etIngles.text.clear()

                    mostrarDialogo("Éxito", "Palabra guardada: $linea")

                } catch (e: IOException) {
                    e.printStackTrace()
                    mostrarDialogo("Error", "Error al guardar la palabra.")
                }
            } else {
                mostrarDialogo("Campos vacíos", "Ambos campos son obligatorios.")
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun palabraExiste(espanol: String, ingles: String): Boolean {
        return try {
            val inputStream = openFileInput(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            var linea: String?

            while (reader.readLine().also { linea = it } != null) {
                val partes = linea!!.split(",")
                if (partes.size == 2) {
                    val espExistente = partes[0].trim()
                    val ingExistente = partes[1].trim()

                    if (espanol.equals(espExistente, ignoreCase = true) ||
                        ingles.equals(ingExistente, ignoreCase = true)) {
                        reader.close()
                        return true
                    }
                }
            }

            reader.close()
            false
        } catch (e: IOException) {
            false
        }
    }

    private fun mostrarDialogo(titulo: String, mensaje: String) {
        AlertDialog.Builder(this)
            .setTitle(titulo)
            .setMessage(mensaje)
            .setPositiveButton("OK", null)
            .show()
    }

    private fun navegateToMenu() {
        val intent = Intent(this, DiccionarioActivity::class.java)
        startActivity(intent)
    }
}
