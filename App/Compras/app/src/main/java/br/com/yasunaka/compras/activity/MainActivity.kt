package br.com.yasunaka.compras.activity

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.annotation.UiThread
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.yasunaka.compras.ProdutosApplication
import br.com.yasunaka.compras.R
import br.com.yasunaka.compras.adapter.ProdutoAdapter
import br.com.yasunaka.compras.domain.Produto
import br.com.yasunaka.compras.domain.ProdutoService
import br.com.yasunaka.compras.extensions.setUpToolbar
import br.com.yasunaka.compras.extensions.toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.include_toolbar.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var produtos = listOf<Produto>()
    private val TAG: String = "PRODUTO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toolbar
        setUpToolbar(R.id.toolbar)

        //RecyclerView
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)

        fab.setOnClickListener {
            onClickNewItem()
        }
    }

    private fun onClickNewItem(){
        val produto = Produto()
        val vazio: String? = ""
        produto.nome = ""
        produto.inCarrinho = false
        produto.observacoes = ""
        produto.quantidade = vazio?.toFloatOrNull()
        produto.preco = vazio?.toFloatOrNull()
        val intent = Intent(this, EditProdutoActivity::class.java)
        intent.putExtra(TAG, produto)
        intent.putExtra("UPDATE", false)
        startActivity(intent)
    }

    override fun onResume() {
        //Preenche a view
        listaProdutos()

        //Recycler View
        recyclerView.addOnScrollListener(
            object: RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if(dy > 0 && fab.isShown) fab.hide()
                    if(dy < 0 && fab.isOrWillBeHidden) fab.show()
                    if(dy == 0 && fab.isOrWillBeHidden) fab.show()
                }

            }
        )


        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        produtos = listOf()
    }

    //Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when(item?.itemId){
        R.id.about -> {
            startActivity<AboutActivity>()
            true
        }

        R.id.share -> {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"

            //Recupera a lista em formato de texto
            val produtos = ProdutoService.getProdutos()

            if(produtos.isEmpty()){
                toast("Nenhum item para compartilhar")
            } else{
                //transforma a lista em um texto
                val texto = ProdutoService.transformProdutosToText(produtos)

                intent.putExtra(Intent.EXTRA_TEXT, texto)
                val chooserIntent = Intent.createChooser(intent, resources.getString(R.string.sendListTo))
                startActivity(chooserIntent)
            }
            true
        }
        R.id.removeAll -> {
            //AlertDialog
            val builder = AlertDialog.Builder(this)
            builder.setIcon(R.drawable.ic_lixo)
            builder.setTitle("Esvaziar Lista")
            builder.setMessage("Esta ação irá excluir a lista, deseja continuar?")
            builder.setPositiveButton("Sim"){
                dialog, which ->
                esvaziarLista()
            }
            builder.setNegativeButton("Cancelar"){
                dialog, which ->
                dialog.dismiss()
            }
            var dialog = builder.create()
            dialog.show()

            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun esvaziarLista(){
        ProdutoService.remAllProduto()
        listaProdutos()

    }

    private fun listaProdutos(){
        //Busca os produtos
        produtos = ProdutoService.getProdutos()
        //Atualiza a lista
        if(produtos.isNotEmpty()) {
            recyclerView?.adapter = ProdutoAdapter(produtos, this)
            emptyList.visibility = View.GONE
        }else {
            recyclerView?.adapter = null
            emptyList.visibility = View.VISIBLE
        }

    }


    /***
    private fun setUpNavDrawer(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawer_layout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener(this)
    }

    **/

    override fun onBackPressed() {
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            return super.onBackPressed()
        }
    }

    //Trata os eventos do menu lateral
    override fun onNavigationItemSelected(item: MenuItem): Boolean{
        when(item.itemId){
            R.id.lista0 -> {
                toast("Clicou no primeiro item")
            }
            R.id.lista1 -> {
                toast("Clicou no segundo item")
            }
            R.id.lista2 -> {
                toast("Clicou no terceiro item")
            }
            R.id.lista3 -> {
                toast("Clicou no quarto item")
            }
            R.id.lista4 -> {
                toast("Clicou no quinto item")
            }
        }

        val drawer_layout = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
