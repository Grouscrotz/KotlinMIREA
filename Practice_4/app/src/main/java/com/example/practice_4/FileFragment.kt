package com.example.practice_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File


class FileFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fileAdapter: FileAdapter
    private lateinit var photoList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_file, container, false)


        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Загрузка данных из файла
        photoList = loadPhoto()

        fileAdapter = FileAdapter(photoList)
        recyclerView.adapter = fileAdapter

        return view
    }

    private fun loadPhoto(): MutableList<String> {
        val file = File(requireContext().filesDir, "photos/date")
        val list = mutableListOf<String>()
        if (file.exists()) {
            file.forEachLine { list.add(it) }
        }
        return list
    }


}