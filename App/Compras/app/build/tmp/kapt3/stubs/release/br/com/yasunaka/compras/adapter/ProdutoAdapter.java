package br.com.yasunaka.compras.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006$"}, d2 = {"Lbr/com/yasunaka/compras/adapter/ProdutoAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lbr/com/yasunaka/compras/adapter/ProdutoAdapter$ProdutosViewHolder;", "produtos", "", "Lbr/com/yasunaka/compras/domain/Produto;", "context", "Landroid/content/Context;", "(Ljava/util/List;Landroid/content/Context;)V", "TAG", "", "getContext", "()Landroid/content/Context;", "getProdutos", "()Ljava/util/List;", "setProdutos", "(Ljava/util/List;)V", "alertDialog", "", "position", "", "calculaTotal", "", "changeBackgroundToGreen", "holder", "changeBackgroundToWhite", "getItemCount", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "snackBar", "view", "Landroid/view/View;", "message", "ProdutosViewHolder", "app_release"})
public final class ProdutoAdapter extends android.support.v7.widget.RecyclerView.Adapter<br.com.yasunaka.compras.adapter.ProdutoAdapter.ProdutosViewHolder> {
    private final java.lang.String TAG = "PRODUTO";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<br.com.yasunaka.compras.domain.Produto> produtos;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public br.com.yasunaka.compras.adapter.ProdutoAdapter.ProdutosViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int position) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    br.com.yasunaka.compras.adapter.ProdutoAdapter.ProdutosViewHolder holder, int position) {
    }
    
    private final void snackBar(android.view.View view, java.lang.String message) {
    }
    
    private final float calculaTotal() {
        return 0.0F;
    }
    
    private final void alertDialog(int position) {
    }
    
    private final void changeBackgroundToGreen(br.com.yasunaka.compras.adapter.ProdutoAdapter.ProdutosViewHolder holder) {
    }
    
    private final void changeBackgroundToWhite(br.com.yasunaka.compras.adapter.ProdutoAdapter.ProdutosViewHolder holder) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<br.com.yasunaka.compras.domain.Produto> getProdutos() {
        return null;
    }
    
    public final void setProdutos(@org.jetbrains.annotations.NotNull()
    java.util.List<br.com.yasunaka.compras.domain.Produto> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public ProdutoAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<br.com.yasunaka.compras.domain.Produto> produtos, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lbr/com/yasunaka/compras/adapter/ProdutoAdapter$ProdutosViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "app_release"})
    public static final class ProdutosViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        
        public ProdutosViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}