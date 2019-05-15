package br.com.yasunaka.compras.extensions

import android.support.annotation.IdRes
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.Toast
import br.com.yasunaka.compras.R

//Toast
fun AppCompatActivity.toast(text: String, length: Int =
    Toast.LENGTH_SHORT) = Toast.makeText(this, text, length).show()

fun AppCompatActivity.setUpToolbar(@IdRes id: Int, title:String? = null,
                                   upNavigation: Boolean = false): ActionBar {
    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)
    if( title != null){
        supportActionBar?.setTitle(title)
    }

    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)
    return supportActionBar!!
}
