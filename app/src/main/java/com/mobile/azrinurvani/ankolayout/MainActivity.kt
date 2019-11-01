package com.mobile.azrinurvani.ankolayout

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import org.jetbrains.anko.*
import com.mobile.azrinurvani.ankolayout.R.color.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>)= with(ui){
            verticalLayout{
                padding = dip(16)

                val name = editText{
                    hint = "Siapa nama anda ?"
                }

                button("Say Hello"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    setOnClickListener{toast("Hello,${name.text}!")}
                }.lparams(width= matchParent){
                    topMargin = dip(5)
                }

                button("Show Alert"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    setOnClickListener{
                        alert("Selamat Mengoding!","Hello,${name.text}!"){
                            yesButton { toast("Oh...!") }
                            noButton {  }
                        }.show()
                    }
                }

                button("Show Selector!"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    setOnClickListener{
                        val club = listOf("Barcelona","Real Madrid","Bayern Munchen","Liverpool")
                        selector("Hello,${name.text}! What's your football club do you love ?",club){_,i->
                            toast("So you love ${club[i]},right ?")
                        }
                    }
                }.lparams(width= matchParent){
                    topMargin =dip(5)
                }

                button("Show Snackbar"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    setOnClickListener{
                        snackbar("Hello,${name.text}!")
                    }
                }.lparams(width= matchParent){
                    topMargin = dip(5)
                }

                button("Go to SecondActivity"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    setOnClickListener{
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }
            }
        }

    }
}
