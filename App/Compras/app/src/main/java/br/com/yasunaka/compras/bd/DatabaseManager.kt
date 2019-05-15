package br.com.yasunaka.compras.bd

import android.arch.persistence.room.Room
import android.content.Context
import br.com.yasunaka.compras.ProdutosApplication

object DatabaseManager{
    private var dbInstance: ProdutoDB
    init {
        val appContext = ProdutosApplication.getInstance().applicationContext

        //Configura o Room
        dbInstance = Room.databaseBuilder(
            appContext,
            ProdutoDB::class.java,
            "produtos.sqlite"
        ).allowMainThreadQueries().build()

    }

    fun getProdutoDAO(): ProdutoDAO{
        return dbInstance.ProdutoDAO()
    }
}