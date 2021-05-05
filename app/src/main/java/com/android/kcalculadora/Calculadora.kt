package com.android.kcalculadora

import kotlin.math.sqrt

class Calculadora() {
    fun HelloWord() {
        println("Hello Word!")
    }

    fun soma(i: Double, i1: Double): Double {
        return i + i1
    }

    fun sub(i: Double, i1: Double): Double {
        return i - i1
    }

    fun multi(i: Double, i1: Double): Double {
        return i * i1
    }

    fun div(i: Double, i1: Double): Double {
        return i / i1
    }

    fun bhaskara(a: Int, b: Int, c: Int): Any {
        val delta = ((b * b) - (4 * a * c))
        val x1 = (-b + sqrt(delta.toDouble())) / (2 * a)
        val x2 = (-b - sqrt(delta.toDouble())) / (2 * a)
        return if (delta < 0) {
            false
        } else {
            mutableListOf(x1, x2)
        }
        //return mutableListOf(x1, x2)
    }


}





