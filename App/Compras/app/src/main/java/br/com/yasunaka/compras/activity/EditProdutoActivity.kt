package br.com.yasunaka.compras.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import br.com.yasunaka.compras.ProdutosApplication
import br.com.yasunaka.compras.R
import br.com.yasunaka.compras.adapter.ProdutoAdapter
import br.com.yasunaka.compras.domain.Produto
import br.com.yasunaka.compras.domain.ProdutoService
import br.com.yasunaka.compras.extensions.setUpToolbar
import br.com.yasunaka.compras.extensions.toast
import kotlinx.android.synthetic.main.activity_edit_produto.*
import kotlinx.android.synthetic.main.activity_edit_produto.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.view.*

class EditProdutoActivity : AppCompatActivity() {

    private val TAG = "PRODUTO"
    private val produto by lazy { intent.getSerializableExtra(TAG) as Produto }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_produto)


        //Toolbar
        setUpToolbar(R.id.toolbar, "Editando Produto", true)

        val btnExcluir = findViewById<Button>(R.id.btnExcluir)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)


        val update = intent.getBooleanExtra("UPDATE", false)

        if(!update){
            //O usuário está criando um novo item
            //Personalização do EditText
            personEditText(editTextNomeProduto, true)
            personEditText(editTextPrecoProduto, true)
            personEditText(editTextQuantidade, true)
            personEditText(editTextObsProduto, true)

            //Fundo Laranja pois por padrão o produto não está no carrinho
            changeBackgroundToOrange(corFundo)
            produto.inCarrinho = false

        } else {
            //O usuário está editando um item já existente
            //Personalização do EditText
            editTextNomeProduto.setOnClickListener { personEditText(editTextNomeProduto, true) }
            editTextPrecoProduto.setOnClickListener { personEditText(editTextPrecoProduto, true) }
            editTextQuantidade.setOnClickListener { personEditText(editTextQuantidade, true) }
            editTextObsProduto.setOnClickListener { personEditText(editTextObsProduto) }

            //Preenche os itens
            editTextNomeProduto?.setText(produto.nome)
            if (produto.preco == "".toFloatOrNull()) {
                personEditText(editTextPrecoProduto, true)
            } else {
                editTextPrecoProduto?.setText(produto.preco.toString())
            }
            if (produto.quantidade == "".toFloatOrNull()) {
                personEditText(editTextQuantidade, true)
            } else {
                editTextQuantidade?.setText(produto.quantidade.toString())
            }
            editTextObsProduto?.setText(produto.observacoes)

            //Altera a cor de fundo
            if(produto.inCarrinho){
                changeBackgroundToGreen(corFundo)
            } else {
                changeBackgroundToOrange(corFundo)
            }

        }

        addCarrinho.setOnClickListener{
            if(!produto.inCarrinho){
                changeBackgroundToGreen(corFundo)
            } else {
                changeBackgroundToOrange(corFundo)
            }
            produto.inCarrinho = !produto.inCarrinho
        }

        img_carrinho.setOnClickListener{
            if(!produto.inCarrinho){
                changeBackgroundToGreen(corFundo)
            } else {
                changeBackgroundToOrange(corFundo)
            }
            produto.inCarrinho = !produto.inCarrinho
        }


        btnExcluir.setOnClickListener{ onClickButtonExcluir(btnExcluir, produto) }
        btnSalvar.setOnClickListener { onClickButtonSave(btnSalvar, produto) }

    }


    private fun personEditText(view: EditText, resetText: Boolean = false){
        view.isCursorVisible = true
        if(resetText) view.setText("")
    }

    //Exclui o item da lista
    private fun onClickButtonExcluir(button: Button, produto: Produto){
        button.setTextColor(resources.getColor(android.R.color.black))
        ProdutoService.remProduto(produto)
        val produtos = ProdutoService.getProdutos()
        recyclerView?.adapter = ProdutoAdapter(produtos, ProdutosApplication.getInstance().applicationContext)
        finish()
    }

    //Salva o item e atualiza o banco de dados
    private fun onClickButtonSave(button: Button, produto: Produto){
        button.setTextColor(resources.getColor(android.R.color.black))

        val nome = editTextNomeProduto.text.toString()

        if(!nome.equals("")) {

            val preco:Float? = editTextPrecoProduto.text.toString().toFloatOrNull()
            val qtd:Float? = editTextQuantidade.text.toString().toFloatOrNull()
            val unidade: String = unidadeMedida.text.toString()
            val obs = editTextObsProduto.text.toString()

            //Preenche o objeto
            produto.nome = nome

            if (preco == null) produto.preco = 0.0f else
                produto.preco = preco

            if (qtd == null) produto.quantidade = 0f else
                produto.quantidade = qtd

            if (obs.equals("")) produto.observacoes = null else
                produto.observacoes = obs

            if(unidade.equals("")) produto.un = "Un" else
                produto.un = unidade


            //Adiciona ou Atualiza o banco de dados e refaz o recyclerView
            val update = intent.getBooleanExtra("UPDATE", false)
            if(!update) ProdutoService.addProduto(produto) else ProdutoService.atualizaProduto(produto)

            var inCarrinho = ProdutoService.getProdutoInCarrinho(produto)
            Log.d("ProdutoInCarrinho", "$inCarrinho")

            finish()
        } else  {
            toast(resources.getString(R.string.necessarioNome))
            button.setTextColor(resources.getColor(R.color.primary_text))
        }

    }

    private fun changeBackgroundToGreen(v: View){
            v.background = v.resources.getDrawable(R.drawable.green_background_edit_produto)
            v.img_carrinho.background = v.resources.getDrawable(R.drawable.ic_rem_carrinho)
            v.addCarrinho.background = v.resources.getDrawable(R.drawable.remover_carrinho_btn_style)
            v.addCarrinho.text = v.resources.getText(R.string.remCarrinho)
            v.toolbar.setBackgroundColor(resources.getColor(R.color.verdeInicial))

    }


    private fun changeBackgroundToOrange(v:View) {
        v.background = v.resources.getDrawable(R.drawable.orange_background_edit_produto)
        v.img_carrinho.background = v.resources.getDrawable(R.drawable.ic_add_carrinho)
        v.addCarrinho.background = v.resources.getDrawable(R.drawable.adicionar_carrinho_btn_style)
        v.addCarrinho.text = v.resources.getText(R.string.addCarrinho)
        v.toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }


}

