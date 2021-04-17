package com.example.inflator

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_layout.view.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        this button implements the default dialogAlert
        clickMe1.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this@MainActivity)
            dialogBuilder.setTitle("Hey User")
            dialogBuilder.setMessage("This is the default dialog")

            dialogBuilder.setPositiveButton("ok", dialogInterface)
            dialogBuilder.setNegativeButton("cancel", dialogInterface)

            val alertDialog = dialogBuilder.create()
            alertDialog.show()
        }


//        this button implements the customs dialogAlert
        clickMe.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this@MainActivity)
            dialogBuilder.setTitle("Hey User")

//            inflating the layout to be used on the custom dialogAlert
            val view = layoutInflater.inflate(R.layout.my_layout, null)
            dialogBuilder.setView(view)

            val alertDialog = dialogBuilder.create()
            alertDialog.show()

            view.send.setOnClickListener {
                val name = view.etName.text.toString()
                Toast.makeText(this@MainActivity, "your name is: '$name", Toast.LENGTH_SHORT).show()

                alertDialog.dismiss()
            }
        }
    }


//    this is the default DialogInterface onClickListener
    private val dialogInterface = DialogInterface.OnClickListener { dialog, which ->
        when(which){
            AlertDialog.BUTTON_POSITIVE ->
                Toast.makeText(this@MainActivity, "you clicked 'ok' ", Toast.LENGTH_SHORT).show()
            AlertDialog.BUTTON_NEGATIVE ->
                Toast.makeText(this@MainActivity, "you clicked 'cancel' ", Toast.LENGTH_SHORT).show()
        }
    }

}