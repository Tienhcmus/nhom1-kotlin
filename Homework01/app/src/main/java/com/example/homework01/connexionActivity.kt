package com.example.homework01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class connexionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_connexion)
        val login = findViewById<TextView>(R.id.login)
        login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val create = findViewById<Button>(R.id.create_ac)
        create.setOnClickListener {
            val intent = Intent(this, SignupActivity ::class.java )
            startActivity(intent)
        }
    }
}