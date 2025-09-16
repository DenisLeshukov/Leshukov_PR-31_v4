package com.bignerdranch.android.leshukov_b2_v4

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class FierstActivity : AppCompatActivity() {
    final var app_pref = "mysetting"
    public var PREFS_FILE = "Users"
    public var PREF_NAME_LOGIN = "login"
    public var PREF_NAME_PASSWORD = "password"
    private val settings: SharedPreferences by lazy {
        getSharedPreferences(PREFS_FILE, MODE_PRIVATE)
    }

    private lateinit var myLogin: EditText
    private lateinit var myPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fierst)

        myLogin=findViewById(R.id.login)
        myPassword = findViewById(R.id.password)

    }
//Функция перехода с первого экрана на второй и проверка на заполняемые данные
    fun goSecond(view: View) {
        val logins_txt = myLogin.getText().toString();
        val passwords_txt = myPassword.getText().toString()
        if(logins_txt.isNotEmpty() && passwords_txt.isNotEmpty())
        {
            saveName(view)
            var intent = Intent(this, secondActivity::class.java)
            startActivity(intent)
        }
        else{
            AlertDialog.Builder(this).setTitle("Ошибка").setMessage("Заполните все поля")
                .setPositiveButton("OK", null).show()
        }
    }
    private fun saveData(){
        settings.edit() {
            putString(PREF_NAME_LOGIN, myLogin.getText().toString())
            putString(PREF_NAME_PASSWORD, myPassword.text.toString())
        }



    }
    fun saveName(view: View)
    {

        saveData()
    }

}