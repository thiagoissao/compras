package br.com.yasunaka.compras.bd

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.yasunaka.compras.domain.Produto

@Database(entities = arrayOf(Produto::class), version = 1)
abstract class ProdutoDB: RoomDatabase(){
    abstract fun ProdutoDAO(): ProdutoDAO
}