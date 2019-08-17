package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{
            updateNickname(it)
        }
    }

    private fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_Edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        editText.visibility = View.VISIBLE
        nicknameTextView.visibility = View.GONE

        val doneButton = findViewById<Button>(R.id.done_button)
        done_button.visibility = View.VISIBLE

        editText.requestFocus() //เอา Cursor ไปไว้ที่ editText อัตโนมัติ

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_Edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val doneButton = findViewById<Button>(R.id.done_button)
        done_button.visibility = View.GONE
        //Hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
