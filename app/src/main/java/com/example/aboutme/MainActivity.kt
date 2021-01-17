package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneButton = findViewById<Button>(R.id.btnDone)
        doneButton.setOnClickListener {
            addNickname(it)  // it in this context refers to the Done button.
        }
    }

    private fun addNickname(view: View){
        // parameter View is the view in which this function is being called. In our case, Button view.
        val editText = findViewById<EditText>(R.id.etNicknameEdit)
        val nicknameText = findViewById<TextView>(R.id.tvNicknameText)

        nicknameText.text = editText.text
        editText.visibility = View.GONE  // Hiding EditText
        view.visibility = View.GONE      // Hiding Button
        nicknameText.visibility = View.VISIBLE  // Make the TextView visible.

        // Hide the keyboard when we are done.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}