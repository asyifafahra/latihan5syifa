package com.asyifafahra.latihan5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Belanja : AppCompatActivity() {
    private lateinit var txtDiskon: TextView
    private lateinit var etBelanja: EditText
    private lateinit var btnHasil: Button
    private lateinit var txtBelanja: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_belanja)

        txtDiskon = findViewById(R.id.txtDiskon)
        etBelanja = findViewById(R.id.etBelanja)
        btnHasil = findViewById(R.id.btnHasil)
        txtBelanja = findViewById(R.id.txtBelanja)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnHasil.setOnClickListener {
            val totalBelanja = etBelanja.text.toString().toDoubleOrNull()
            if (totalBelanja != null) {
                var diskon = 0.0 // Initialize discount
                if (totalBelanja < 100000) {
                    diskon = 0.0
                } else if (totalBelanja in 100000.0..500000.0) {
                    diskon = 0.10
                } else if (totalBelanja in 500000.0..1000000.0) {
                    diskon = 0.20
                } else {
                    diskon = 0.30
                }

                val totalDiskon = totalBelanja * diskon
                val totalAkhir = totalBelanja - totalDiskon
                txtBelanja.text =
                    "Total Belanja: Rp. " + totalBelanja + "\nDiskon: Rp. " + totalDiskon + "\nTotal Setelah Diskon: Rp. " + totalAkhir

            } else {
                txtBelanja.text = "Input tidak valid!" // Error message for invalid input
            }


        }
    }
}