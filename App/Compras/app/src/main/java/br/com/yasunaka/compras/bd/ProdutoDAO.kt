package br.com.yasunaka.compras.bd

import android.arch.persistence.room.*
import br.com.yasunaka.compras.domain.Produto

@Dao
interface ProdutoDAO{
    @Query("SELECT * FROM produto where id = :id")
    fun getById(id: Long): Produto?

    @Query("SELECT * FROM produto")
    fun findAll(): List<Produto>

    @Insert
    fun insert(produto: Produto)

    @Delete
    fun delete(produto: Produto)

    @Update
    fun update(produto:Produto)

    @Query("DELETE FROM produto")
    fun deleteAll(): Unit
}