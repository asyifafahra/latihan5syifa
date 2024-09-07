package com.asyifafahra.latihan5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var txtView : TextView
    private lateinit var btnRuang :  Button
    private lateinit var btnSuhu  : Button
    private lateinit var btnBelanja : Button
    private lateinit var btnBilangan : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    txtView = findViewById(R.id.txtView)
    btnRuang = findViewById(R.id.btnRuang)
    btnSuhu = findViewById(R.id.btnSuhu)
    btnBelanja = findViewById(R.id.btnBelanja)
    btnBilangan = findViewById(R.id.btnBilangan)

        btnRuang.setOnClickListener() {
            Toast.makeText(this, "Menghitung bangun ruang", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, BangunRuang::class.java)
            startActivity(intent)
        }
        btnSuhu.setOnClickListener() {
            Toast.makeText(this, "Menghitung suhu", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, KonversiSuhu::class.java)
            startActivity(intent)
        }
        btnBelanja.setOnClickListener() {
            Toast.makeText(this, "Menghitung belanja", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Belanja::class.java)
            startActivity(intent)
        }
        btnBilangan.setOnClickListener() {
            Toast.makeText(this, "Menentukan bilangan ganjil dan genap", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, GanjilGenap::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
    }
}