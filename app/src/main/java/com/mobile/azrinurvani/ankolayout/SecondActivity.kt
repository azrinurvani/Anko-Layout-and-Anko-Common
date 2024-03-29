package com.mobile.azrinurvani.ankolayout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class SecondActivity : AppCompatActivity() {

    private var name:String =""
    private lateinit var nameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout{
            padding = dip(16)
            nameTextView = textView()

        }
        val intent = intent
        name =intent.getStringExtra("name")
        nameTextView.text = name
    }
}
