package com.abraxel.hescodeinstaller

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FirstFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_first, container, false)

        view.findViewById<Button>(R.id.button_youtube).setOnClickListener {
            val yIntent = Intent(Intent.ACTION_VIEW)
                yIntent.data = Uri.parse("https://youtu.be/J-Vdy5aNr70")
                startActivity(yIntent)
        }

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            val yIntent = Intent(Intent.ACTION_VIEW)
            yIntent.data = Uri.parse("Drive Linki")
            startActivity(yIntent)
        }

        return view

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}