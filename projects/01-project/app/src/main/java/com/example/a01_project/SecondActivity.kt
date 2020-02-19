package com.example.a01_project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_second.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        textView_username.text = intent.getStringExtra("username")

        button.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("password", editText_password.text.toString())
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
