package com.example.a01_project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    val LAUNCH_SECOND_ACTIVITY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        textView2.visibility = View.INVISIBLE

        button_Login.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val string = editText_username.text.toString()
            intent.putExtra("username", string)
            startActivityForResult(intent, 1)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                val password = data?.getStringExtra("password")
                textView2.visibility = View.VISIBLE
                textView_password.text = password.toString()

                val user = User(userName = editText_username.text.toString(), password = password.toString())
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    } //onActivityResult


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    class User(userName: String, password: String) {
        companion object Factory {
            val users = mutableListOf<User>()

            fun makeUser(userName: String, password: String): User {
                val user = User(userName, password)
                users.add(user)
                return user
            }
        }
    }
}
