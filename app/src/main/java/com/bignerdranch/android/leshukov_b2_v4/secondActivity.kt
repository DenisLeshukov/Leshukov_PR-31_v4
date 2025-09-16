package com.bignerdranch.android.leshukov_b2_v4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog

class secondActivity : AppCompatActivity() {
    lateinit var spin: Spinner
    private lateinit var mydata: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        mydata=findViewById(R.id.dann)
        spin = findViewById<Spinner>(R.id.sp)


        val adapter= ArrayAdapter.createFromResource(
            this,
            R.array.names,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapter


    }

    //Функция перехода со второго экрана на третий а так же вычисление по фигуре и формуле


    fun calculate(view: View) {
        val selectedFigure = spin.selectedItem.toString()
        val inputText = mydata.text.toString().trim()

        if (inputText.isEmpty()) {
            AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите данные")
                .setPositiveButton("OK", null)
                .show()
            return
        }

        try {
            val result = when (selectedFigure) {
                "Круг" -> {
                    val p = inputText.toDouble()
                    val r = p / (2 * Math.PI)
                    "Круг, R = %.2f".format(r)
                }
                "Треугольник" -> {
                    val parts = inputText.split(" ")
                    if (parts.size != 2) {
                        throw IllegalArgumentException("Введите два числа через пробел")
                    }
                    val a = parts[0].toDouble()
                    val b = parts[1].toDouble()
                    val p = 2 * a + b
                    "Треугольник, p = %.2f".format(p)
                }
                else -> throw IllegalArgumentException("Неизвестная фигура")
            }

            // Передаём результат в следующую активность
            val intent = Intent(this, fierdActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)

        } catch (e: Exception) {
            AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage(e.message ?: "Некорректные данные")
                .setPositiveButton("OK", null)
                .show()
        }
    }
}
