package br.com.yasunaka.compras.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.yasunaka.compras.R
import br.com.yasunaka.compras.activity.EditProdutoActivity
import br.com.yasunaka.compras.domain.Produto
import br.com.yasunaka.compras.domain.ProdutoService
import kotlinx.android.synthetic.main.adapter_produto.view.*
import kotlinx.android.synthetic.main.alert_dialog_layout.view.*
import org.jetbrains.anko.toast


class ProdutoAdapter(var produtos: List<Produto>, val context: Context):
    RecyclerView.Adapter<ProdutoAdapter.ProdutosViewHolder>(){

    private val TAG = "PRODUTO"

    //ViewsHolder com as views
    class ProdutosViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    //Quantidade de itens
    override fun getItemCount(): Int = this.produtos.size

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ProdutosViewHolder {
        //Infla a view do adapter
        var view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_produto, parent, false)

        //Retorna o ViewHolder que contem todas as views
        return ProdutosViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {

        val view = holder.itemView

        view.textViewNomeProduto.text = this.produtos[position].nome
        view.valorPreco.text = "%.2f".format(this.produtos[position].preco)
        view.valorQuantidade.text = this.produtos[position].quantidade.toString()
        view.un.text = this.produtos[position].un

        if(this.produtos[position].inCarrinho) changeBackgroundToGreen(holder) else
            changeBackgroundToWhite(holder)

        //Clicou EDIT
        view.imgEdit.setOnClickListener {

            holder.itemView.imgEdit.background = context.resources.getDrawable(R.drawable.ic_edit_click)
            val intent = Intent(context, EditProdutoActivity::class.java)
            intent.putExtra(TAG, this.produtos[position])
            intent.putExtra("UPDATE", true)
            context.startActivity(intent)

        }

        //Clicou no carrinho, então é necessário salvar as alterações e atualizar a cor
        view.imgAdapterCarrinho.setOnClickListener {
            if(this.produtos[position].inCarrinho){
                changeBackgroundToWhite(holder)
            } else {
                changeBackgroundToGreen(holder)
            }

            this.produtos[position].inCarrinho = !this.produtos[position].inCarrinho
            ProdutoService.atualizaProduto(this.produtos[position])

            //Mostra um snackBar com o subtotal
            val total = calculaTotal()
            val message = "Subtotal: R$ "+"%.2f".format(total)
            Log.d("snackbar", "$total")
            snackBar(view, message)
        }

        //CLique longo em cima do cardView para excluir um item
        view.card_view.setOnLongClickListener {
            alertDialog(position)
            true
        }
    }

    private fun snackBar(view: View, message: String){
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }

    private fun calculaTotal(): Float{
        var lista = ProdutoService.getProdutos()
        var total: Float? = 0f
        lista.forEachIndexed { index, produto ->
            if(lista[index].inCarrinho){
                total = total?.plus(lista[index].preco!!.times(lista[index].quantidade!!))
            }
        }
        return total!!
    }

    private fun alertDialog(position: Int){
        val view = LayoutInflater.from(context).inflate(R.layout.alert_dialog_layout, null)

        val builder = AlertDialog.Builder(context)
        builder.setView(view)
        val alerta = builder.create()
        alerta.show()

        view.btnExcluir.setOnClickListener {
            ProdutoService.remProduto(this.produtos[position])
            notifyDataSetChanged()
            this.produtos = ProdutoService.getProdutos()
            context.toast("Removido")
            alerta.dismiss()
        }
        view.btnCancelar.setOnClickListener {
            alerta.dismiss()
        }
    }

    private fun changeBackgroundToGreen(holder: ProdutosViewHolder){
        holder.itemView.card_view.setCardBackgroundColor(context.resources.getColor(R.color.lettuce))
        holder.itemView.imgAdapterCarrinho.background = context.resources.getDrawable(R.drawable.ic_rem_carrinho)
    }


    private fun changeBackgroundToWhite(holder: ProdutosViewHolder) {
        holder.itemView.card_view.setCardBackgroundColor(Color.WHITE)
        holder.itemView.imgAdapterCarrinho.background = context.resources.getDrawable(R.drawable.ic_add_carrinho)
    }
}