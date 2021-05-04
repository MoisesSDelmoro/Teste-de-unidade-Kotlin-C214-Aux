package com.android.kcalculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    fun HelloWord() {
        println("Hello Word!")
    }

    lateinit var editText: EditText

    var conta: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editTextConta)

    }



    fun positionButton(view: View) = when (view.id) {
        R.id.btn0 -> digite("0")
        R.id.btn1 -> digite("1")
        R.id.btn2 -> digite("2")
        R.id.btn3 -> digite("3")
        R.id.btn4 -> digite("4")
        R.id.btn5 -> digite("5")
        R.id.btn6 -> digite("6")
        R.id.btn7 -> digite("7")
        R.id.btn8 -> digite("8")
        R.id.btn9 -> digite("9")
        R.id.btnMais -> digite("+")
        R.id.btnMenos -> digite("-")
        R.id.btnDividi -> digite("/")
        R.id.btnMult -> digite("*")
        R.id.btnPonto -> digite(".")
        R.id.btnLimparT -> limpar()
        R.id.btnIgual -> calcular()
        R.id.btnDeletar -> deletar(1)
        else -> Log.d("nada", "Algo diferente")
    }

    fun soma(i: Double, i1: Double): Double {
        return i+i1
    }
    fun sub(i: Double, i1: Double): Double {
        return i-i1
    }
    fun multi(i: Double, i1: Double): Double {
        return i*i1
    }
    fun div(i: Double, i1: Double): Double {
        return i/i1
    }

    fun digite(s: String) {
        var auxS = s
        conta = editText.text.toString()
        if (conta.isEmpty()) {
            if (s == "+" || s == "-" || s == "/" || s == "*") {
                auxS = ""
            } else {
                conta += auxS
                editText.append(conta)
            }
        } else {
            if (s == "+" || s == "-" || s == "/" || s == "*") {
                if (conta.length > 1) {
                    var auxS2 = conta[conta.length - 2].toString()
                    auxS = verificarOperacao(auxS2, s)
                    conta += auxS
                    editText.setText(conta)
                } else {
                    conta += " $s "
                    editText.setText(conta)
                }
            } else {
                conta = auxS
                editText.append(conta)
            }
        }
    }

    fun limpar() {
        editText.setText("")
        conta = ""
    }

    fun calcular() {
        if (editText.text.toString() != "") {
            try {
                val expression = ExpressionBuilder(editText.text.toString()).build()
                val result: Double = expression.evaluate()
                conta = result.toString()
                editText.setText(conta)
            } catch (ex: NumberFormatException) {
                Log.e("Erro", ex.toString())
                conta = "0"
                editText.setText(conta)
            }
        }
    }

    fun deletar(int: Int) {
        if (conta.isNotEmpty()) {
            conta = conta.substring(0, conta.length - int)
            editText.setText(conta)
        }
    }

    fun verificarOperacao(aux: String, operacao: String): String {
        var retorno: String = operacao
        if (aux == operacao) {
            retorno = ""
        } else if (operacao == "+") {
            if (aux == "-" || aux == "/" || aux == "*") {
                retorno = "$operacao "
                deletar(2)
            } else {
                retorno = " + "
            }
        } else if (operacao == "-") {
            if (aux == "+" || aux == "/" || aux == "*") {
                retorno = "$operacao "
                deletar(2)
            } else {
                retorno = " - "
            }
        } else if (operacao == "/") {
            if (aux == "+" || aux == "-" || aux == "*") {
                retorno = "$operacao "
                deletar(2)
            } else {
                retorno = " / "
            }
        } else if (operacao == "*") {
            if (aux == "+" || aux == "/" || aux == "-") {
                retorno = "$operacao "
                deletar(2)
            } else {
                retorno = " * "
            }
        } else {
            if (operacao == "+") {
                retorno = " + "
            } else if (operacao == "-") {
                retorno = " - "
            } else if (operacao == "/") {
                retorno = " / "
            } else if (operacao == "*") {
                retorno = " * "
            } else {
                retorno = operacao
            }
        }
        HelloWord()
        return retorno

    }
}
