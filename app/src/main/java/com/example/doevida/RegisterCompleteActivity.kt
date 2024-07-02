package com.example.doevida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class RegisterCompleteActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_complete)

                val btnNext: Button = findViewById(R.id.btnNext)
                btnNext.setOnClickListener {
                        // Ação a ser executada quando o botão é clicado
                        val i = intent
                        val j = Intent(this, FeedActivity::class.java)
                        j.putExtras(i)
                        startActivity(j)
                }
        }
}