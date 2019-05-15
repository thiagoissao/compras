package br.com.yasunaka.compras.domain

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "produto")
class Produto: Serializable{
    @PrimaryKey (autoGenerate = true)
    var id: Long = 0
    var nome: String = ""
    var preco: Float? = 0f
    var quantidade: Float? = 0f
    var observacoes: String? = ""
    var inCarrinho: Boolean = false
    var un: String = "Un"
}