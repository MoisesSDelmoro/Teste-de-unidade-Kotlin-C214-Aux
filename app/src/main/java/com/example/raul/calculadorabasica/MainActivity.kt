package com.example.raul.calculadorabasica

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private var firstNumber:Int? = null
    private var secondNumber:Int? = null
    private var isResult:Boolean = false
    private var contas:ArrayList<Conta> = ArrayList<Conta>()
    private var shaPrefHelper = SharedPreferencesHelper()
    private val shaPrefKey = "contas"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_ce.setOnClickListener { txtVisor.text = "0" }

        bt_equal.setOnClickListener {
            var txtVisor = txtVisor.text.toString()
            if(isNumOpeNumFormat(txtVisor)) {
                if(txtVisor.indexOf('+') != -1) {
                    this.secondNumber = txtVisor.split('+')[1].toIntOrNull()
                    calculateResult('+')
                }
                else if(txtVisor.indexOf('-') != -1) {
                    this.secondNumber = txtVisor.split('-')[1].toIntOrNull()
                    calculateResult('-')
                }
                else if(txtVisor.indexOf('x') != -1) {
                    this.secondNumber = txtVisor.split('x')[1].toIntOrNull()
                    calculateResult('x')
                }
                else {
                    this.secondNumber = txtVisor.split('/')[1].toIntOrNull()
                    calculateResult('/')
                }
            }
        }

        // fonte: https://medium.com/@biratkirat/4-starting-activities-in-kotlin-ae3642126d3
        bt_historico.setOnClickListener {
            var intent = Intent(this, HistoricoActivity::class.java)
            startActivity(intent)
        }
    }

    fun calculateResult(operator: Char) {
        if(this.firstNumber != null && this.secondNumber != null) {
            var result = when (operator) {
                '+' -> this.firstNumber!! + this.secondNumber!!
                '-' -> this.firstNumber!! - this.secondNumber!!
                'x' -> this.firstNumber!! * this.secondNumber!!
                '/' -> {
                    if(this.secondNumber != 0) {
                        (this.firstNumber!!).toDouble() / (this.secondNumber!!).toDouble()
                    }
                    else {
                        toast("Cannot divide by zero.")
                        this.txtVisor.text = "0"
                        null
                    }
                }
                else -> null
            }
            if(result != null) {
                if(operator != '/')
                    this.txtVisor.text = result.toString()
                else
                    this.txtVisor.text = "%.2f".format(result)

                this.isResult = true
                var contaTxt = "" + this.firstNumber + operator + this.secondNumber + "=" + this.txtVisor.text
                var conta = Conta(contaTxt)

                contas.clear()

                var contasJson = shaPrefHelper.getText(this, shaPrefKey)
                if(!contasJson.isNullOrBlank()) {
                    var gson = GsonBuilder().create()
                    contas = gson.fromJson(contasJson, object : TypeToken<ArrayList<Conta>>() {}.type)
                }

                this.contas.add(conta)
                val gson = GsonBuilder().setPrettyPrinting().create()
                val jsonContas: String = gson.toJson(contas)
                shaPrefHelper.saveText(this, shaPrefKey, jsonContas)
            }
        }
    }

    fun onNumberClicked(view: View){
        val button = view as Button
        var number = button.text.toString()

        if(isResult) {
            txtVisor.text = number
            this.isResult = false
        }
        else if(txtVisor.text == "0") {
            txtVisor.text = number
        }
        else {
            var numberConcat = txtVisor.text.toString() + number
            txtVisor.text = numberConcat
        }

    }

    fun onOperatorClicked(view: View){
        val button = view as Button
        var operator = button.text.toString()

        var visorNumber = txtVisor.text.toString().toIntOrNull()
        if(visorNumber != null) {
            firstNumber = visorNumber
            var operatorConcat = txtVisor.text.toString() + operator
            txtVisor.text = operatorConcat
        }
    }

    fun isNumOpeNumFormat(txt:String): Boolean {
        val hasOperator = txt.contains("+") || txt.contains("-") || txt.contains("x") || txt.contains("/")
        if(txt.length < 3 || !hasOperator || isOperator(txt[0]) || isOperator(txt[txt.length - 1]))
            return false

        return true
    }

    fun isOperator(ch:Char) : Boolean {
        return ch == '+' || ch == '-' || ch == 'x' || ch == '/'
    }
}
