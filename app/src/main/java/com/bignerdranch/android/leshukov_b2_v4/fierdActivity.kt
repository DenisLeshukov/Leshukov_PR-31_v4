package com.bignerdranch.android.leshukov_b2_v4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class fierdActivity : AppCompatActivity() {
    private lateinit var resultName: EditText
    private lateinit var resultValue: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fierd)
        resultName = findViewById(R.id.result_name)
        resultValue = findViewById(R.id.result_value)

        val result = intent.getStringExtra("RESULT")
        if (result != null) {
            val parts = result.split(", ")
            resultName.setText(parts[0])
            resultValue.setText(parts[1])
        }
    }
    //Функция перехода с третьего экрана на первый
    fun goFirst(view:View)
    {
        var intent = Intent(this, FierstActivity::class.java)
        startActivity(intent)
    }
}