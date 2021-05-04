package com.example.raul.calculadorabasica

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_historico.*

class HistoricoActivity : AppCompatActivity() {
    val contasTxt: ArrayList<String> = ArrayList()
    private var contas:ArrayList<Conta> = ArrayList<Conta>()
    private var shaPrefHelper = SharedPreferencesHelper()
    private val shaPrefKey = "contas"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        addContas()
        rv_contas.layoutManager = LinearLayoutManager(this)
        rv_contas.adapter = ContaAdapter(contasTxt, this)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        btLimpaHistorico.setOnClickListener {
            shaPrefHelper.clean(this)
            contasTxt.clear()
            rv_contas.adapter.notifyDataSetChanged()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

    fun addContas() {
        contas.clear()
        var contasJson = shaPrefHelper.getText(this, shaPrefKey)
        if(!contasJson.isNullOrBlank()) {
            var gson = GsonBuilder().create()
            contas = gson.fromJson(contasJson, object : TypeToken<ArrayList<Conta>>() {}.type)
        }
        for (conta in contas) {
            contasTxt.add(conta.calculo)
        }
    }
}
