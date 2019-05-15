package br.com.yasunaka.compras.domain

import android.content.Context
import android.util.Log
import br.com.yasunaka.compras.bd.DatabaseManager

object ProdutoService{
    fun getProdutos(): List<Produto>{
        val dao = DatabaseManager.getProdutoDAO()
        val listaProduto = dao.findAll()

        return listaProduto
    }

    fun remAllProduto(){
        val dao = DatabaseManager.getProdutoDAO()
        dao.deleteAll()
    }

    fun addProduto(produto: Produto){
        val dao = DatabaseManager.getProdutoDAO()
        dao.insert(produto)
    }

    fun remProduto(produto: Produto){
        val dao = DatabaseManager.getProdutoDAO()
        dao.delete(produto)
    }

    fun atualizaProduto(produto: Produto){
        val dao = DatabaseManager.getProdutoDAO()
        dao.update(produto)
    }

    fun getProdutoInCarrinho(produto: Produto): Boolean{
        val dao = DatabaseManager.getProdutoDAO()
        dao.getById(produto.id)
        return produto.inCarrinho
    }

    //Transformar produtos em um texto
    fun transformProdutosToText(produtos: List<Produto>): String{
        var texto: String? = ""
        var cont:Int = 0
        produtos.forEach {
            var item = it
            texto += item.nome + " "
            texto += "R$" + item.preco + " "
            texto += "Qtd: " + item.quantidade + "\n"

        }
        return texto!!
    }

}