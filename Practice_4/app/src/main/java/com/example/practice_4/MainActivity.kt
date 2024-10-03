package com.example.practice_4

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.camera_container,fragmentCamera).addToBackStack(null).commit()
        }

        val buttonFile = findViewById<Button>(R.id.buttonFile)
        buttonFile.setOnClickListener { supportFragmentManager.beginTransaction().replace(R.id.camera_container,fragmentFile).addToBackStack(null).commit() }

    }
    val fragmentCamera = CameraFragment()
    val fragmentFile = FileFragment()
}