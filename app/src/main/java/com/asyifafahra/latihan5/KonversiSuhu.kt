package com.asyifafahra.latihan5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KonversiSuhu : AppCompatActivity() {
    private lateinit var txtJudul : TextView
    private lateinit var etNumber : EditText
    private lateinit var txtKonversi : TextView
    private lateinit var btnFarenheid : Button
    private lateinit var btnKelvin   : Button
    private lateinit var btnReamur  : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_konversi_suhu)
  txtJudul = findViewById(R.id.txtJudul)
  etNumber = findViewById(R.id.etNumber)
  txtKonversi = findViewById(R.id.txtKonversi)
  btnFarenheid = findViewById(R.id.btnFarenheid)
  btnKelvin  = findViewById(R.id.btnKelvin)
  btnReamur  = findViewById(R.id.btnReamur)


        btnFarenheid.setOnClickListener {
            val celsius = etNumber.text.toString().toFloatOrNull() ?: 0f
            val fahrenheit = celsius * 9 / 5 + 32
            txtKonversi.text = "Fahrenheit: $fahrenheit"
        }


        btnKelvin.setOnClickListener {
            val celsius = etNumber.text.toString().toFloatOrNull() ?: 0f
            val kelvin = celsius + 273.15
            txtKonversi.text = "Kelvin: $kelvin"
        }


        btnReamur.setOnClickListener {
            val celsius = etNumber.text.toString().toFloatOrNull() ?: 0f
            val reamur = celsius * 4 / 5
            txtKonversi.text = "Reamur: $reamur"
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}