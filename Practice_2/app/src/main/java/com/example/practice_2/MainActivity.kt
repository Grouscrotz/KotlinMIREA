package com.example.practice_2


import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button1 = findViewById<Button>(R.id.buttonNav1)
        button1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container1, fragment1).addToBackStack(null).commit()
        }

        val button2 = findViewById<Button>(R.id.buttonNav2)
        button2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container1, fragment2).addToBackStack(null).commit()
        }

        val button3 = findViewById<Button>(R.id.buttonNav3)
        button3.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container1, fragment3).addToBackStack(null).commit()
        }


    }


}

val fragment1:BlankFragment1 = BlankFragment1()
val fragment2:BlankFragment2 = BlankFragment2()
val fragment3:BlankFragment3 = BlankFragment3()
