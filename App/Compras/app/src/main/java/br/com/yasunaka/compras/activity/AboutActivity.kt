package br.com.yasunaka.compras.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.yasunaka.compras.R
import br.com.yasunaka.compras.extensions.setUpToolbar
import kotlinx.android.synthetic.main.include_toolbar.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        //Toolbar
        setUpToolbar(R.id.toolbar, resources.getString(R.string.about), true)
    }

}
