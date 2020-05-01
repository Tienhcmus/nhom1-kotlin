package com.example.homework01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.main_view.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_view)
        val letstart = findViewById<Button>(R.id.button)
        letstart.setOnClickListener{
            val intent = Intent(this, connexionActivity :: class.java)
            startActivity(intent)

        }
    }
}
