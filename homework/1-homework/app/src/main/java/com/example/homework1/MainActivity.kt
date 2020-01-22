package com.example.homework1

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.os.Handler
import android.view.View
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        setupConcatButton()
        setupAddButton()
    }

    private fun setupConcatButton() {
        button_concat.setOnClickListener {
            var mgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            mgr.hideSoftInputFromWindow(currentFocus?.getWindowToken(), 0)
            currentFocus?.clearFocus()

            // Variable to hold progress status
            var progressStatus = 0;

            // Initialize a new Handler instance
            val handler: Handler = Handler()

            val string = edit_year.text.toString() + " " + edit_make.text.toString() + " " + edit_model.text.toString()
            edit_make.text.clear()
            edit_model.text.clear()
            edit_year.text.clear()

            // Start the lengthy operation in a background thread
            Thread(Runnable {

                var processTime = Random.nextLong(40,50);

                while (progressStatus < 100) {
                    // Update the progress status
                    progressStatus += 1

                    // Try to sleep the thread for 50 milliseconds
                    try {
                        Thread.sleep(processTime)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                    // Update the progress bar
                    handler.post(Runnable {
                        progressBar.progress = progressStatus

                        // Show the progress on text view
                        textView_add.text = progressStatus.toString() + "%"
                    })
                }

                textView_concat.text = string
            }).start() // Start the operation
        }
    }

    private fun setupAddButton() {
        button_add.setOnClickListener {
            var mgr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            mgr.hideSoftInputFromWindow(currentFocus?.getWindowToken(), 0)
            currentFocus?.clearFocus()

            // Variable to hold progress status
            var progressStatus = 0;

            // Initialize a new Handler instance
            val handler: Handler = Handler()

            val count = edit_year.text.length + edit_make.text.length + edit_model.text.length
            edit_make.text.clear()
            edit_model.text.clear()
            edit_year.text.clear()

            // Start the lengthy operation in a background thread
            Thread(Runnable {

                var processTime = Random.nextLong(40,50);

                while (progressStatus < 100) {
                    // Update the progress status
                    progressStatus += 1

                    // Try to sleep the thread for 50 milliseconds
                    try {
                        Thread.sleep(processTime)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                    // Update the progress bar
                    handler.post(Runnable {
                        progressBar.progress = progressStatus

                        // Show the progress on text view
                        textView_add.text = progressStatus.toString() + "%"
                    })
                }

                textView_concat.text = count.toString()
            }).start() // Start the operation
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_add_converter -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
