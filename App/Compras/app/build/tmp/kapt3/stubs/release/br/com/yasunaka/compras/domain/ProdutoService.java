package br.com.yasunaka.compras.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bJ\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u00a8\u0006\u0011"}, d2 = {"Lbr/com/yasunaka/compras/domain/ProdutoService;", "", "()V", "addProduto", "", "produto", "Lbr/com/yasunaka/compras/domain/Produto;", "atualizaProduto", "getProdutoInCarrinho", "", "getProdutos", "", "remAllProduto", "remProduto", "transformProdutosToText", "", "produtos", "app_release"})
public final class ProdutoService {
    public static final br.com.yasunaka.compras.domain.ProdutoService INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<br.com.yasunaka.compras.domain.Produto> getProdutos() {
        return null;
    }
    
    public final void remAllProduto() {
    }
    
    public final void addProduto(@org.jetbrains.annotations.NotNull()
    br.com.yasunaka.compras.domain.Produto produto) {
    }
    
    public final void remProduto(@org.jetbrains.annotations.NotNull()
    br.com.yasunaka.compras.domain.Produto produto) {
    }
    
    public final void atualizaProduto(@org.jetbrains.annotations.NotNull()
    br.com.yasunaka.compras.domain.Produto produto) {
    }
    
    public final boolean getProdutoInCarrinho(@org.jetbrains.annotations.NotNull()
    br.com.yasunaka.compras.domain.Produto produto) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String transformProdutosToText(@org.jetbrains.annotations.NotNull()
    java.util.List<br.com.yasunaka.compras.domain.Produto> produtos) {
        return null;
    }
    
    private ProdutoService() {
        super();
    }
}