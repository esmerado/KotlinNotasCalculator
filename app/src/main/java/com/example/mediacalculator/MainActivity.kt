package com.example.mediacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mediacalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val showResult = binding.tvInput
            val ad = binding.etAD.text.toString()
            val di = binding.etDI.text.toString()
            val pw = binding.etPW.text.toString()
            val e = binding.etE.text.toString()

            val ad_num = ad.toDouble()
            val di_num = di.toDouble()
            val pw_num = pw.toDouble()
            val e_num = e.toDouble()

            val media = (ad_num + di_num + pw_num + e_num) / 4

            if (media >= 5){
                showResult.setText("APROBADO")
            } else if (media < 5 && media >= 0) {
                showResult.setText("SUSPENSO")
            } else {
                Toast.makeText(this, "El resultado de la media no puede ser negativo!!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}

