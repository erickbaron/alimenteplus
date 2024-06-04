package com.example.doevida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.loginButton).setOnClickListener{
            val i = intent
            val j = Intent(this, LoginActivity::class.java)
            j.putExtras(i)
            startActivity(j)
        }

        findViewById<Button>(R.id.registerButton).setOnClickListener{
            val i = intent
            val j = Intent(this, RegisterActivity::class.java)
            j.putExtras(i)
            startActivity(j)
        }
    }
}