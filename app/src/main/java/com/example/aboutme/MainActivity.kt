package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Shokir")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

//        val doneButton = findViewById<Button>(R.id.btnDone)
//        doneButton.setOnClickListener {
//            addNickname(it)  // it in this context refers to the Done button.
//        }
        binding.btnDone.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View){
        binding.apply {
            // tvNicknameText.text = binding.etNicknameEdit.text
            myName?.nickname = etNicknameEdit.text.toString()
            invalidateAll()  // refresh the UI with the new data.
            etNicknameEdit.visibility = View.GONE
            btnDone.visibility = View.GONE
            tvNicknameText.visibility = View.VISIBLE
        }
    }
}
