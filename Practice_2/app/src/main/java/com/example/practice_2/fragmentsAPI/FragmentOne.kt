package com.example.practice_2.fragmentsAPI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.practice_2.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentOne : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_one, container, false)
        view.findViewById<Button>(R.id.buttonFragment1).setOnClickListener { view.findNavController().navigate(
            R.id.action_fragmentOne_to_fragmentTwo
        ) }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentOne().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}