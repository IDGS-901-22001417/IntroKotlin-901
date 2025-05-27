package org.utl.idgs.introkotlin_901

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.idgs.introkotlin_901.archivoDeTexto.ArchivoTextoActivity
import org.utl.idgs.introkotlin_901.cinepolis.CinepolisActivity
import org.utl.idgs.introkotlin_901.diccionario.DiccionarioActivity
import org.utl.idgs.introkotlin_901.ejemplo1.SumaActivity
import org.utl.idgs.introkotlin_901.ejemplo2.SaludoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnCalculadora = findViewById<Button>(R.id.btn1)
        val btnSaludo = findViewById<Button>(R.id.btn2)
        val btnCinepolis = findViewById<Button>(R.id.btnCinepolis)
        val btnDiccionario = findViewById<Button>(R.id.btnDiccionario)
        val btnArchivoTexto = findViewById<Button>(R.id.btnArchivoTexto)

        btnCalculadora.setOnClickListener {navegateToCalculadora()}
        btnSaludo.setOnClickListener {navegateToSaludo()}
        btnCinepolis.setOnClickListener {navegateToCinepolis()}
        btnArchivoTexto.setOnClickListener {navegateToArchivoTexto()}
        btnDiccionario.setOnClickListener { navegateToDiccionario() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun navegateToCalculadora() {
        val intent = Intent(this, SumaActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToSaludo() {
        val intent = Intent(this, SaludoActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToCinepolis() {
        val intent = Intent(this, CinepolisActivity::class.java)
        startActivity(intent)
    }
    private fun navegateToArchivoTexto() {
        val intent = Intent(this, ArchivoTextoActivity::class.java)
        startActivity(intent)
    }
    private fun navegateToDiccionario() {
        val intent = Intent(this, DiccionarioActivity::class.java)
        startActivity(intent)
    }
}