package br.com.yasunaka.compras.bd;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import br.com.yasunaka.compras.domain.Produto;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ProdutoDAO_Impl implements ProdutoDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProduto;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfProduto;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfProduto;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ProdutoDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProduto = new EntityInsertionAdapter<Produto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `produto`(`id`,`nome`,`preco`,`quantidade`,`observacoes`,`inCarrinho`,`un`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Produto value) {
        stmt.bindLong(1, value.getId());
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        if (value.getPreco() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getPreco());
        }
        if (value.getQuantidade() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getQuantidade());
        }
        if (value.getObservacoes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getObservacoes());
        }
        final int _tmp;
        _tmp = value.getInCarrinho() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        if (value.getUn() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUn());
        }
      }
    };
    this.__deletionAdapterOfProduto = new EntityDeletionOrUpdateAdapter<Produto>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `produto` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Produto value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfProduto = new EntityDeletionOrUpdateAdapter<Produto>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `produto` SET `id` = ?,`nome` = ?,`preco` = ?,`quantidade` = ?,`observacoes` = ?,`inCarrinho` = ?,`un` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Produto value) {
        stmt.bindLong(1, value.getId());
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        if (value.getPreco() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getPreco());
        }
        if (value.getQuantidade() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getQuantidade());
        }
        if (value.getObservacoes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getObservacoes());
        }
        final int _tmp;
        _tmp = value.getInCarrinho() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        if (value.getUn() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUn());
        }
        stmt.bindLong(8, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM produto";
        return _query;
      }
    };
  }

  @Override
  public void insert(Produto produto) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfProduto.insert(produto);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Produto produto) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfProduto.handle(produto);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Produto produto) {
    __db.beginTransaction();
    try {
      __updateAdapterOfProduto.handle(produto);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public Produto getById(long id) {
    final String _sql = "SELECT * FROM produto where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNome = _cursor.getColumnIndexOrThrow("nome");
      final int _cursorIndexOfPreco = _cursor.getColumnIndexOrThrow("preco");
      final int _cursorIndexOfQuantidade = _cursor.getColumnIndexOrThrow("quantidade");
      final int _cursorIndexOfObservacoes = _cursor.getColumnIndexOrThrow("observacoes");
      final int _cursorIndexOfInCarrinho = _cursor.getColumnIndexOrThrow("inCarrinho");
      final int _cursorIndexOfUn = _cursor.getColumnIndexOrThrow("un");
      final Produto _result;
      if(_cursor.moveToFirst()) {
        _result = new Produto();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        _result.setNome(_tmpNome);
        final Float _tmpPreco;
        if (_cursor.isNull(_cursorIndexOfPreco)) {
          _tmpPreco = null;
        } else {
          _tmpPreco = _cursor.getFloat(_cursorIndexOfPreco);
        }
        _result.setPreco(_tmpPreco);
        final Float _tmpQuantidade;
        if (_cursor.isNull(_cursorIndexOfQuantidade)) {
          _tmpQuantidade = null;
        } else {
          _tmpQuantidade = _cursor.getFloat(_cursorIndexOfQuantidade);
        }
        _result.setQuantidade(_tmpQuantidade);
        final String _tmpObservacoes;
        _tmpObservacoes = _cursor.getString(_cursorIndexOfObservacoes);
        _result.setObservacoes(_tmpObservacoes);
        final boolean _tmpInCarrinho;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfInCarrinho);
        _tmpInCarrinho = _tmp != 0;
        _result.setInCarrinho(_tmpInCarrinho);
        final String _tmpUn;
        _tmpUn = _cursor.getString(_cursorIndexOfUn);
        _result.setUn(_tmpUn);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Produto> findAll() {
    final String _sql = "SELECT * FROM produto";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNome = _cursor.getColumnIndexOrThrow("nome");
      final int _cursorIndexOfPreco = _cursor.getColumnIndexOrThrow("preco");
      final int _cursorIndexOfQuantidade = _cursor.getColumnIndexOrThrow("quantidade");
      final int _cursorIndexOfObservacoes = _cursor.getColumnIndexOrThrow("observacoes");
      final int _cursorIndexOfInCarrinho = _cursor.getColumnIndexOrThrow("inCarrinho");
      final int _cursorIndexOfUn = _cursor.getColumnIndexOrThrow("un");
      final List<Produto> _result = new ArrayList<Produto>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Produto _item;
        _item = new Produto();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        _item.setNome(_tmpNome);
        final Float _tmpPreco;
        if (_cursor.isNull(_cursorIndexOfPreco)) {
          _tmpPreco = null;
        } else {
          _tmpPreco = _cursor.getFloat(_cursorIndexOfPreco);
        }
        _item.setPreco(_tmpPreco);
        final Float _tmpQuantidade;
        if (_cursor.isNull(_cursorIndexOfQuantidade)) {
          _tmpQuantidade = null;
        } else {
          _tmpQuantidade = _cursor.getFloat(_cursorIndexOfQuantidade);
        }
        _item.setQuantidade(_tmpQuantidade);
        final String _tmpObservacoes;
        _tmpObservacoes = _cursor.getString(_cursorIndexOfObservacoes);
        _item.setObservacoes(_tmpObservacoes);
        final boolean _tmpInCarrinho;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfInCarrinho);
        _tmpInCarrinho = _tmp != 0;
        _item.setInCarrinho(_tmpInCarrinho);
        final String _tmpUn;
        _tmpUn = _cursor.getString(_cursorIndexOfUn);
        _item.setUn(_tmpUn);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
