package br.com.yasunaka.compras.domain;

import java.lang.System;

@android.arch.persistence.room.Entity(tableName = "produto")
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\"\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014\u00a8\u0006%"}, d2 = {"Lbr/com/yasunaka/compras/domain/Produto;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()J", "setId", "(J)V", "inCarrinho", "", "getInCarrinho", "()Z", "setInCarrinho", "(Z)V", "nome", "", "getNome", "()Ljava/lang/String;", "setNome", "(Ljava/lang/String;)V", "observacoes", "getObservacoes", "setObservacoes", "preco", "", "getPreco", "()Ljava/lang/Float;", "setPreco", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "quantidade", "getQuantidade", "setQuantidade", "un", "getUn", "setUn", "app_release"})
public final class Produto implements java.io.Serializable {
    @android.arch.persistence.room.PrimaryKey(autoGenerate = true)
    private long id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String nome;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Float preco;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Float quantidade;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String observacoes;
    private boolean inCarrinho;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String un;
    
    public final long getId() {
        return 0L;
    }
    
    public final void setId(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNome() {
        return null;
    }
    
    public final void setNome(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getPreco() {
        return null;
    }
    
    public final void setPreco(@org.jetbrains.annotations.Nullable()
    java.lang.Float p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getQuantidade() {
        return null;
    }
    
    public final void setQuantidade(@org.jetbrains.annotations.Nullable()
    java.lang.Float p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getObservacoes() {
        return null;
    }
    
    public final void setObservacoes(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean getInCarrinho() {
        return false;
    }
    
    public final void setInCarrinho(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUn() {
        return null;
    }
    
    public final void setUn(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Produto() {
        super();
    }
}