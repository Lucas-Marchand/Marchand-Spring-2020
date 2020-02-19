package com.example.a01_project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
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

        button_add_profile_picture.setOnClickListener{
            val takePicture = Intent(Intent.ACTION_PICK)
            startActivityForResult(takePicture, 1)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val image = data?.data
                imageView.setImageURI(image)
                button_add_profile_picture.visibility = View.INVISIBLE
            }
            if (resultCode == Activity.RESULT_CANCELED) { //Write your code if there's no result
            }
        }
    } //onActivityResult
}
