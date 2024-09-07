package com.asyifafahra.latihan5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BangunRuang : AppCompatActivity() {
    private lateinit var txtjudul : TextView
    private lateinit var etPanjang : EditText
    private lateinit var etLebar   : EditText
    private lateinit var etTinggi  : EditText
    private lateinit var btnHitung : Button
    private lateinit var txtHasil : TextView
    private lateinit var txtHasilLuasPermukaan : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bangun_ruang)
        txtjudul = findViewById(R.id.txtjudul)
        etPanjang = findViewById(R.id.etPanjang)
        etLebar   = findViewById(R.id.etlebar)
        etTinggi  = findViewById(R.id.etTinggi)
        btnHitung = findViewById(R.id.btnHitung)
        txtHasil = findViewById(R.id.txtHasil)
        txtHasilLuasPermukaan = findViewById(R.id.txtHasilLuasPermukaan)

        btnHitung.setOnClickListener {
            val panjang = etPanjang.text.toString().toFloatOrNull() ?: 0f
            val lebar = etLebar.text.toString().toFloatOrNull() ?: 0f
            val tinggi = etTinggi.text.toString().toFloatOrNull() ?: 0f

            val volume = panjang * lebar * tinggi
            txtHasil.text = "Volume: $volume"

            val luasPermukaan = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi)
            txtHasilLuasPermukaan.text = "Luas Permukaan: $luasPermukaan"

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}