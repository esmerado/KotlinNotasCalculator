package com.example.mediacalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.example.mediacalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Añadimos un clicklistener a nuestro botón.

        binding.btnCalculate.setOnClickListener {

            // Obtenemos el TextView en el que queremos añadir el resultado.
            val showResult = binding.tvInput

            // Comprobamos que todas nuestras variables tiene algún valor.
            if (binding.etAD.text.toString().isNotEmpty() && binding.etDI.text.toString()
                    .isNotEmpty()
                && binding.etPW.text.toString().isNotEmpty() && binding.etE.text.toString()
                    .isNotEmpty()
            ) {

                // Obtenemos los valores de nuestras variables.
                val ad = binding.etAD.text.toString()
                val di = binding.etDI.text.toString()
                val pw = binding.etPW.text.toString()
                val e = binding.etE.text.toString()

                // Llamamos al método que realiza el cálculo.
                calculate(ad, di, pw, e, showResult)

            } else {

                //Lanzamos un toast si alguno de los valores está vacío.
                Toast.makeText(this, "Prueba", Toast.LENGTH_SHORT).show()
            }


        }
    }

    /**
     * Función creada para el cálculo de la media y muestra de resultado.
     */
    private fun calculate(ad: String, di: String, pw: String, e: String, showResult: TextView) {

        // Parseamos los string a Double para realizar el cálculo.
        val ad_num = ad.toDouble()
        val di_num = di.toDouble()
        val pw_num = pw.toDouble()
        val e_num = e.toDouble()

        //Calculamos la media
        val media = (ad_num + di_num + pw_num + e_num) / 4

        // Comprobamos que todos los número son menos a 10
        if (ad_num > 10 || di_num > 10 || pw_num > 10 || e_num > 10) {
            Toast.makeText(this, "Las notas no deben ser mayor a 10", Toast.LENGTH_SHORT).show()
        } else {
            // Imprimimos los resultados.
            if (media >= 5) {
                showResult.setText(R.string.aprobado)
                showResult.setTextColor(Color.GREEN)
            } else if (media < 5 && media >= 0) {
                showResult.setText(R.string.suspenso)
                showResult.setTextColor(Color.RED)
            }
        }

    }
}

