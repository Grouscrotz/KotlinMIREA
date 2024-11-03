package com.example.practice_5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = MainDB.getDb(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val todosApi = retrofit.create(TodosAPI::class.java)


        val button = findViewById<Button>(R.id.button)
        val buttonList = findViewById<Button>(R.id.buttonList)
        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editTextText)

        button.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                // получаем данные с сервера по id, которое вводит пользователь
                val todos = todosApi.getTodosById(editText.text.toString().toInt())

                // записываем класс с данными с сервера в БД
                db.getDao().insertProduct(todos)

                //отображаем считывамую задачу
                runOnUiThread {
                    textView.text = "Задача: ${todos.todo}"
                    editText.text.clear()
                }
            }
        }

        val intent = Intent(this, ListActivity::class.java)
        buttonList.setOnClickListener {
            startActivity(intent)
        }
    }
    
}