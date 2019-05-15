package br.com.yasunaka.compras

import android.app.Application

class ProdutosApplication : Application() {
    private val TAG = "ProdutosApplication"

    // Chamado quando o Android criar o processo da aplicação
    override fun onCreate() {
        super.onCreate()
        // Salva a instância para termos acesso como Singleton
        appInstance = this
    }

    companion object {
        // Singleton da classe Application
        private var appInstance: ProdutosApplication? = null

        fun getInstance(): ProdutosApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configure a classe de Application no AndroidManifest.xml")
            }
            return appInstance!!
        }
    }

}